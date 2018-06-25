#include "Company.h"
#include <iostream>

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

void Company::setName(const char *name) {
    delete[] this->name;
    int lenght = strlen(name) + 1;
    this->name = new char[lenght];
    memcpy(this->name, name, lenght);
}

void Company::clearCompany() {
    delete[] this->name;
}

void Company::copyCompany(const Company &company) {
    this->successfulProjects = company.successfulProjects;
    this->allProjects = company.allProjects;
    this->setName(company.name);
}

Company::~Company() {
    this->clearCompany();
}

Company &Company::operator=(const Company &company) {
    if (this != &company) {
        this->copyCompany(company);
    }
    return *this;
}

Company::Company(const Company &company) : name(nullptr){
    copyCompany(company);
}

Company::Company() : name(nullptr) {
    this->successfulProjects = 0;
    this->allProjects = 0;
}

Company::Company(const char *name) : name(nullptr) {
    this->successfulProjects = 0;
    this->allProjects = 0;
    this->setName(name);
}

char *Company::getName() const{
    return this->name;
}





