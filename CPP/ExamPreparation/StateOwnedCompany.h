#ifndef EXAMPREPARATION_STATEOWNEDCOMPANY_H
#define EXAMPREPARATION_STATEOWNEDCOMPANY_H

#include "Company.h"

class StateOwnedCompany : public Company{
private:
    int currentProjectNum;
public:
    StateOwnedCompany(const char* name);
    bool perform(const char *project) override;
    virtual friend ostream& operator<<(ostream& os, const StateOwnedCompany& privateCompany);
};


#endif //EXAMPREPARATION_STATEOWNEDCOMPANY_H
