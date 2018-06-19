#include "StateOwnedCompany.h"

StateOwnedCompany::StateOwnedCompany(const char *name) : Company(name) {
    this->currentProjectNum = 0;
}

bool StateOwnedCompany::perform(const char *project) {
    this->currentProjectNum++;
    bool b = false;

    if ((this->currentProjectNum % 20) != 0) {
        b = true;
        iterateSuccessfulProjects();
        iterateAllProjects();
    } else {
        iterateAllProjects();
    }

    return b;
}
