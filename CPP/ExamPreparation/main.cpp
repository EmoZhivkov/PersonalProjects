#include <iostream>
using namespace std;

#include "Company.h"
#include "PrivateCompany.h"

int main() {
    Company * company = new PrivateCompany(5, "Gosho");
    company->perform("Opa");
    company->perform("OOAOOAOA");
    company->perform("Opa");
    company->perform("OOAOOAOA");
    company->perform("Opa");
    company->perform("OOAOOAOA");

    cout << company->getName() << endl;

    return 0;
}