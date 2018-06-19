#ifndef EXAMPREPARATION_PRIVATECOMPANY_H
#define EXAMPREPARATION_PRIVATECOMPANY_H

#include "Company.h"

class PrivateCompany : public Company{
private:
    int currentProjectNum;
    int successRate;
public:
    PrivateCompany(int successRate);
    virtual bool perform(char *project);
};


#endif //EXAMPREPARATION_PRIVATECOMPANY_H
