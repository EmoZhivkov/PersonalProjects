//
// Created by emozh on 6/19/2018.
//

#include "Company.h"

double Company::reliabilityRate() const {
    if (successfulProjects == 0) {
        return 0;
    }
    return (double)this->successfulProjects / (double)this->allProjects;
}

void Company::iterateSuccessfulProjects() {
    this->successfulProjects++;
}

void Company::iterateAllProjects() {
    this->allProjects++;
}





