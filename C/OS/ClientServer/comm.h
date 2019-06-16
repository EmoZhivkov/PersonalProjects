#ifndef CLIENTSERVER_COMM_H
#define CLIENTSERVER_COMM_H


#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

#define SEM_MUTEX_NAME "/sem-mutex"
#define SEM_SPOOL_SIGNAL_NAME "/sem-spool-signal"
#define SHARED_MEM_NAME "/posix-shared-mem-example"
#define SEM_BANK_NAME "/sem-bank"

typedef struct Query {
    uint32_t inBank;
    int32_t transaction; 
    char account;
} Query;

uint8_t isValidAccount[128];

void initValidAccount() {
    for (int j = 0; j < 128; ++j) {
        isValidAccount[j] = 0;
    }

    for (int i = 0; i < 8; ++i) {
        isValidAccount[i + 65] = 1;
    }
}

int doesFileExist(char* filename){
    struct stat buffer;
    int exist = stat(filename,&buffer);
    if(exist == 0)
        return 1;
    else
        return 0;
}

void error(char *msg) {
    fprintf(stderr, "%s\n", msg);
    exit(-1);
}

void initializeSemaphoresAndShm(Query *shared_mem_ptr, sem_t *mutex_sem, sem_t *spool_signal_sem, sem_t *take_from_bank_sem) {
    int fd_shm;

    if ((fd_shm = shm_open(SHARED_MEM_NAME, O_RDWR | O_CREAT, 0660)) == -1)
        error("shm_open");

    if (ftruncate(fd_shm, sizeof(Query)) < 0) 
        error("Could not set the shared memory size.");
    
    if ((shared_mem_ptr = mmap(NULL, sizeof(Query), PROT_READ | PROT_WRITE, MAP_SHARED, fd_shm, 0)) == MAP_FAILED)
        error("Failed to map the shared memory");
        
    if ((spool_signal_sem = sem_open(SEM_SPOOL_SIGNAL_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open");

    if ((take_from_bank_sem = sem_open(SEM_BANK_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open");
    
    if ((mutex_sem = sem_open(SEM_MUTEX_NAME, O_CREAT, 0660, 0)) == SEM_FAILED)
        error("sem_open");
}

#endif //CLIENTSERVER_COMM_H
