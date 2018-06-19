#include <iostream>
using namespace std;

#include "Company.h"
#include "PrivateCompany.h"

int main() {
    PrivateCompany company = PrivateCompany(5);
    company.perform("Opa");
    company.perform("OOAOOAOA");
    company.perform("Opa");
    company.perform("OOAOOAOA");
    company.perform("Opa");
    company.perform("OOAOOAOA");

    cout << company.reliabilityRate() << endl;

    return 0;
}