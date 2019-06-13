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
    perror(msg);
    exit(1);
}

#endif //CLIENTSERVER_COMM_H
