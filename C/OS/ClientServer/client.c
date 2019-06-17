#include <sys/types.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <semaphore.h>
#include <sys/mman.h>
#include "comm.h"

int main(int argc, char **argv) {
    if (argc != 2) 
        error("The client takes exactly one argument. Namely the account identifier.");
    
    char *accountIdentifier = argv[1];

    if (strlen(accountIdentifier) != 1) 
        error("Invalid account identifier.");
    
    Query *shared_mem_ptr;
    sem_t *mutex_sem, *spool_signal_sem, *take_from_bank_sem;
    int fd_shm;

    if ((mutex_sem = sem_open(SEM_MUTEX_NAME, O_RDWR)) == SEM_FAILED)
        error("sem_open failed");
    
    if (sem_wait(mutex_sem) == -1)
        error("sem_wait failed");

    if ((fd_shm = shm_open(SHARED_MEM_NAME, O_RDWR, 0)) == -1)
        error("shm_open failed");

    if (ftruncate(fd_shm, sizeof(Query)) < 0) 
        error("Could not set the shared memory");
    
    if ((shared_mem_ptr = mmap(NULL, sizeof(Query), PROT_READ | PROT_WRITE, MAP_SHARED, fd_shm, 0)) == MAP_FAILED)
        error("Failed to map the shared memory");

    if ((spool_signal_sem = sem_open(SEM_SIGNAL_NAME, O_RDWR)) == SEM_FAILED)
        error("sem_open failed");

    if ((take_from_bank_sem = sem_open(SEM_BANK_NAME, O_RDWR)) == SEM_FAILED)
        error("sem_open failed");

    Query currentAccount = {0,0,accountIdentifier[0]};

    memcpy(shared_mem_ptr, &currentAccount, sizeof(Query));

    if (sem_post(spool_signal_sem) == -1)
        error("sem_post: spool_signal_sem failed");

    if (sem_wait(take_from_bank_sem) == -1)
        error("sem_wait: take_from_bank failed");

    if (shared_mem_ptr->transaction == -1) {
        if (sem_post(mutex_sem) == -1)
            error("sem_post: mutex_sem failed");

        error("Invalid account number!");
    } else {
        printf("Account %s has ", accountIdentifier);
        printf("%u", shared_mem_ptr->inBank);
        printf(" left in it. What transaction would you like to make:\n");
    }
    
    if (scanf("%d", &currentAccount.transaction) < 0) {
        if (sem_post(mutex_sem) == -1)
            error("sem_post: mutex_sem failed");

        error("Failed to get the desired amount");
    }

    memcpy(shared_mem_ptr, &currentAccount, sizeof(Query));
  
    if (sem_post(spool_signal_sem) == -1)
        error("sem_post: spool_signal_sem failed");

    if (sem_wait(take_from_bank_sem) == -1)
        error("sem_wait: take_from_bank failed");

    if (shared_mem_ptr->transaction == -1) {
        if (sem_post(mutex_sem) == -1)
            error("sem_post: mutex_sem failed");

        error("Invalid amount! Could not make the transaction.");
    } 

    if (sem_post(mutex_sem) == -1)
        error("sem_post: mutex_sem failed");

    exit(0);
}
