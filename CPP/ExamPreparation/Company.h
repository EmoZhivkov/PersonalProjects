#ifndef EXAMPREPARATION_COMPANY_H
#define EXAMPREPARATION_COMPANY_H


class Company {
private:
    int successfulProjects;
    int unsuccessfulProjects;
public:
    virtual bool perform(char * project) = 0;
    double reliabilityRate() const;
    void iterateSuccessfulProjects();
    void iterateUnsuccessfulProjects();
};


#endif //EXAMPREPARATION_COMPANY_H
