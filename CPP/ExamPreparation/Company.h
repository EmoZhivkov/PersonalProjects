#ifndef EXAMPREPARATION_COMPANY_H
#define EXAMPREPARATION_COMPANY_H


class Company {
private:
    int successfulProjects;
    int allProjects;
public:
    virtual bool perform(char * project) = 0;
    double reliabilityRate() const;
    void iterateSuccessfulProjects();
    void iterateAllProjects();
};


#endif //EXAMPREPARATION_COMPANY_H
