#include <iostream>
using namespace std;

#include "Company.h"
#include "PrivateCompany.h"
#include "StateOwnedCompany.h"

int main() {
    Company * company = new PrivateCompany(9, "Gosho");
    company->perform("Opa");
    company->perform("OOAOOAOA");
    company->perform("Opa");
    company->perform("OOAOOAOA");
    company->perform("Opa");
    company->perform("OOAOOAOA");

    cout << company->getName() << endl;
    cout << company->reliabilityRate() << endl;

    PrivateCompany a = PrivateCompany(2, "Begaj");
    PrivateCompany b = PrivateCompany(4, "Begaj");

    //a = b;

    StateOwnedCompany c = StateOwnedCompany("OOpa");
    StateOwnedCompany d = StateOwnedCompany("OOpa");

    c = d;

    cout << a << endl;
    cout << b << endl;
    cout << (PrivateCompany&)*company << endl;

    return 0;
}