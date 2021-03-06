#include "PrivateCompany.h"



bool PrivateCompany::perform(const char *project) {
    this->currentProjectNum++;
    bool b = false;

    if((this->currentProjectNum % this->successRate) != 0) {
        b = true;
        iterateSuccessfulProjects();
        iterateAllProjects();
    } else {
        iterateAllProjects();
    }

    return b;
}

PrivateCompany::PrivateCompany(int successRate, const char *name) : Company(name) {
    this->successRate = successRate;
}

ostream &operator<<(ostream &os, const PrivateCompany &privateCompany) {
    os << "private: " << privateCompany.successRate << " " << privateCompany.getName() << endl;
    return os;
}

Company *PrivateCompany::newInstanceOf() const {
    return new PrivateCompany(*this);
}
