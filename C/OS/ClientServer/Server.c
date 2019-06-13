#include <sys/types.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <semaphore.h>
#include <sys/mman.h>
#include "Comm.h"

int main(int argc, char **argv) {
    if (argc != 2) {
        error("The server takes exactly one argument. Namely the file it reads from");
    }

    initValidAccount();

    u_int32_t bank[8];
    int fd;

    char *fileName = argv[1];
    if (!doesFileExist(fileName)) {
        fd = open(fileName, O_CREAT | O_RDWR, 0666);
        for (int i = 0; i < 8; ++i) {
            uint32_t temp = 0;
            uint32_t size = write(fd, &temp, 4);
            if (size != 4) {
                error("Could not write the numbers to the file.");
            }
            bank[i] = 0;
        }
    } else {
        fd = open(fileName, O_RDWR);
        read(fd, &bank, 8*4);
    }

    char *shared_mem_ptr;
    sem_t *mutex_sem,*spool_signal_sem,*take_from_bank_sem;
    int fd_shm;
    char buff[256];

    //  mutual exclusion semaphore, mutex_sem with an initial value 0.
    if ((mutex_sem = sem_open(SEM_MUTEX_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open");

    // Get shared memory
    if ((fd_shm = shm_open(SHARED_MEM_NAME, O_RDWR | O_CREAT, 0660)) == -1)
        error("shm_open");

    ftruncate(fd_shm, 256);

    shared_mem_ptr = mmap(NULL, 256, PROT_READ | PROT_WRITE, MAP_SHARED,
                          fd_shm, 0);

    // counting semaphore, indicating the number of strings to be printed. Initial value = 0
    if ((spool_signal_sem = sem_open(SEM_SPOOL_SIGNAL_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open");

    if ((take_from_bank_sem = sem_open(SEM_BANK_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open");

    // Initialization complete; now we can set mutex semaphore as 1 to
    // indicate shared memory segment is available
    if (sem_post(mutex_sem) == -1)
        error("sem_post: mutex_sem");

    while (1) {
        // Is there a string to print? P (spool_signal_sem);
        if (sem_wait(spool_signal_sem) == -1)
            error("sem_wait: spool_signal_sem");

        strcpy (buff, shared_mem_ptr);
        char account = buff[1];
        uint8_t index = (uint8_t)account;
        if (!isValidAccount[index]) {
            sprintf(buff, "%d", -1);
            strcpy(shared_mem_ptr, buff);
        } else {
            sprintf(buff, "%d", bank[account - 65]);
            strcpy(shared_mem_ptr, buff);
        }

        if (sem_post(take_from_bank_sem) == -1)
            error("sem_post: take_from_bank_sem");

        //printf("%s", buff);
    }
}
