#ifndef EXAMPREPARATION_COMPANY_H
#define EXAMPREPARATION_COMPANY_H


class Company {
private:
    int successfulProjects;
    int allProjects;
    char *name;

    void copyCompany(const Company& company);
    void clearCompany();
    void setName(const char *name);
public:
    Company();
    Company(const char* name);
    Company(const Company &company);
    Company& operator=(const Company& company);
    virtual ~Company();

    virtual bool perform(const char * project) = 0;
    double reliabilityRate() const;

    void iterateSuccessfulProjects();
    void iterateAllProjects();

    char *getName();
};


#endif //EXAMPREPARATION_COMPANY_H
