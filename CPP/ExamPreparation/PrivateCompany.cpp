#include "PrivateCompany.h"

PrivateCompany::PrivateCompany(int successRate) : Company(){
    this->successRate = successRate;

    this->currentProjectNum = 0;
}

bool PrivateCompany::perform(char *project) {
    this->currentProjectNum++;

    bool b = false;

    if((this->currentProjectNum % this->successRate) != 0) {
        b = true;
        iterateSuccessfulProjects();
        iterateAllProjects();
    } else {
        b = false;
        iterateAllProjects();
    }

    return b;
}
