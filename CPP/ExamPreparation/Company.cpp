//
// Created by emozh on 6/19/2018.
//

#include "Company.h"

double Company::reliabilityRate() const {
    return (double)this->successfulProjects / (double)this->unsuccessfulProjects;
}

void Company::iterateSuccessfulProjects() {
    this->successfulProjects++;
}

void Company::iterateUnsuccessfulProjects() {
    this->unsuccessfulProjects++;
}





