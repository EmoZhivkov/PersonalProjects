#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <semaphore.h>
#include <sys/mman.h>

#define SEM_MUTEX_NAME "/sem-mutex"
#define SEM_SPOOL_SIGNAL_NAME "/sem-spool-signal"
#define SHARED_MEM_NAME "/posix-shared-mem-example"

void error(char *msg);

int main(int argc, char **argv) {
    char *shared_mem_ptr;
    sem_t *mutex_sem,*spool_signal_sem;
    int fd_shm;
    char buff[256];

    //  mutual exclusion semaphore, mutex_sem with an initial value 0.
    if ((mutex_sem = sem_open(SEM_MUTEX_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open");

    // Get shared memory
    if ((fd_shm = shm_open(SHARED_MEM_NAME, O_RDWR | O_CREAT, 0660)) == -1)
        error("shm_open");


    if ((shared_mem_ptr = mmap(NULL, 256, PROT_READ | PROT_WRITE, MAP_SHARED,
                               fd_shm, 0)) == MAP_FAILED)
        error("mmap");

    // counting semaphore, indicating the number of strings to be printed. Initial value = 0
    if ((spool_signal_sem = sem_open(SEM_SPOOL_SIGNAL_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
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

        printf("%s", buff);
    }
}

// Print system error and exit
void error(char *msg) {
    perror(msg);
    exit(1);
}