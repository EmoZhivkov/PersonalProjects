#include <sys/types.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <semaphore.h>
#include <sys/mman.h>
#include "Comm.h"

int main(int argc, char **argv) {
    if (argc != 2) {
        error("The client takes exactly one argument. Namely the bank identifier");
    }

    char* identifier = argv[1];

    if (strlen(identifier) != 2) {
        error("Invalid identifier");
    }

    char *shared_mem_ptr;
    sem_t *mutex_sem, *spool_signal_sem,*take_from_bank_sem;
    int fd_shm;

    //  mutual exclusion semaphore, mutex_sem
    if ((mutex_sem = sem_open(SEM_MUTEX_NAME, 0, 0, 0)) == SEM_FAILED)
        error("sem_open");

    // Get shared memory
    if ((fd_shm = shm_open(SHARED_MEM_NAME, O_RDWR, 0)) == -1)
        error("shm_open");

    ftruncate(fd_shm, 256);

    shared_mem_ptr = mmap(NULL, 256, PROT_READ | PROT_WRITE, MAP_SHARED,
                          fd_shm, 0);

    // counting semaphore, indicating the number of strings to be printed. Initial value = 0
    if ((spool_signal_sem = sem_open(SEM_SPOOL_SIGNAL_NAME, 0, 0, 0)) == SEM_FAILED)
        error("sem_open");

    if ((take_from_bank_sem = sem_open(SEM_BANK_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open");

    char buff[256];

    printf("Please type a message: ");

   // while (fgets(buff, 256, stdin)) {
    fgets(buff, 256, stdin);
        // remove newline from string
        int length = strlen(buff);
        if (buff[length - 1] == '\n')
            buff[length - 1] = '\0';

        /* There might be multiple producers. We must ensure that
            only one producer uses buffer_index at a time.  */
        // P (mutex_sem);
        if (sem_wait(mutex_sem) == -1)
            error("sem_wait: mutex_sem");

        sprintf (shared_mem_ptr, "%s\n", buff);

        // Release mutex sem: V (mutex_sem)
        if (sem_post(mutex_sem) == -1)
            error("sem_post: mutex_sem");

        // Tell spooler that there is a string to print: V (spool_signal_sem);
        if (sem_post(spool_signal_sem) == -1)
            error("sem_post: (spool_signal_sem");

        if (sem_wait(take_from_bank_sem) == -1)
            error("sem_wait: take_from_bank");

        //sprintf (shared_mem_ptr, "%s\n", buff);
        printf("%s\n", shared_mem_ptr);

        //printf("Please type a message: ");
    //}

    if (munmap(shared_mem_ptr, sizeof(buff)) == -1)
    exit(0);
}
