#include <sys/types.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <semaphore.h>
#include <sys/mman.h>
#include "comm.h"

int main(int argc, char **argv) {
    if (argc != 2) 
        error("The server takes exactly one argument. Namely the file it reads from");
    
    initValidAccount();

    uint32_t bank[8];
    int fd;

    char *fileName = argv[1];
    if (!doesFileExist(fileName)) {
        fd = open(fileName, O_CREAT | O_RDWR, 0666);
        for (int i = 0; i < 8; ++i) {
            uint32_t temp = 0;
            uint32_t size = write(fd, &temp, 4);
            if (size != 4) 
                error("Could not write the numbers to the file.");
            
            bank[i] = 0;
        }
    } else {
        fd = open(fileName, O_RDWR);
        int bytesRead = read(fd, &bank, 8*4);
        if (bytesRead != 8*4)
            error("Could not read the numbers from the file");   
    }

    Query *shared_mem_ptr;
    sem_t *mutex_sem,*spool_signal_sem,*take_from_bank_sem;
    int fd_shm;

    if ((mutex_sem = sem_open(SEM_MUTEX_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open failed");
    
    sem_init(mutex_sem, 1, 0);

    if ((fd_shm = shm_open(SHARED_MEM_NAME, O_RDWR | O_CREAT, 0660)) == -1)
        error("shm_open");

    if (ftruncate(fd_shm, sizeof(Query)) < 0) 
        error("Could not set the shared memory size.");
    
    if ((shared_mem_ptr = mmap(NULL, sizeof(Query), PROT_READ | PROT_WRITE, MAP_SHARED, fd_shm, 0)) == MAP_FAILED)
        error("Failed to map the shared memory");
        
    if ((spool_signal_sem = sem_open(SEM_SIGNAL_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open failed");
    
    sem_init(spool_signal_sem, 1, 0);

    if ((take_from_bank_sem = sem_open(SEM_BANK_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open failed");
    
    sem_init(take_from_bank_sem, 1, 0);

    if (sem_post(mutex_sem) == -1)
        error("sem_post: mutex_sem failed");

    while (1) {
        if (sem_wait(spool_signal_sem) == -1)
            error("sem_wait: spool_signal_sem failed");

        Query currentAccount = {0,0,shared_mem_ptr->account};
        
        uint8_t indexForValid = shared_mem_ptr->account;
        uint8_t index = indexForValid - 65;
        
        if (!isValidAccount[indexForValid]) {
            currentAccount.transaction = -1;
            memcpy(shared_mem_ptr, &currentAccount, sizeof(Query));

            if (sem_post(take_from_bank_sem) == -1)
                error("sem_post: take_from_bank_sem failed");

            continue;
        } else {
            currentAccount.inBank = bank[index];
            memcpy(shared_mem_ptr, &currentAccount, sizeof(Query));
        }

        if (sem_post(take_from_bank_sem) == -1)
            error("sem_post: take_from_bank_sem failed");

        if (sem_wait(spool_signal_sem) == -1)
            error("sem_wait: spool_signal_sem failed");
        
        int32_t toAdd = shared_mem_ptr->transaction;
        if (toAdd > INT16_MAX || toAdd < INT16_MIN) {
            currentAccount.transaction = -1;
            memcpy(shared_mem_ptr, &currentAccount, sizeof(Query));

            if (sem_post(take_from_bank_sem) == -1)
                error("sem_post: take_from_bank_sem failed");

            continue;
        } else {
            int64_t result = (int64_t)bank[index] + (int64_t)toAdd;
            if (result < 0 || result > UINT32_MAX) {
                currentAccount.transaction = -1;
                memcpy(shared_mem_ptr, &currentAccount, sizeof(Query));

                if (sem_post(take_from_bank_sem) == -1)
                    error("sem_post: take_from_bank_sem failed");

            continue;
            } else {
                currentAccount.transaction = 0;
                bank[index] = bank[index] + toAdd;

                memcpy(shared_mem_ptr, &currentAccount, sizeof(Query));

                lseek(fd, 0, SEEK_SET);
                int size = write(fd, &bank, 8*4);    
                if (size != 8*4) 
                    error("Failed to write to file.");
            }
        }
        
        if (sem_post(take_from_bank_sem) == -1)
            error("sem_post: take_from_bank_sem failed");
    }
}
