#ifndef EXAMPREPARATION_PRIVATECOMPANY_H
#define EXAMPREPARATION_PRIVATECOMPANY_H

#include "Company.h"

class PrivateCompany : public Company{
private:
    int currentProjectNum;
    int successRate;
public:
    PrivateCompany(int successRate, const char* name);
    virtual bool perform(const char *project);
};


#endif //EXAMPREPARATION_PRIVATECOMPANY_H
