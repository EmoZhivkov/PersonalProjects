#include <iostream>
#include "Product.h"
#include "Store.h"

int main() {
    Store *store = new Store(10);
    char a = 'o';
    while (a != 'Q') {
        std::cout<<"Command: ";
        std::cin >> a;
        if (a == 'A') {
            store->addProduct();
        } else if (a == 'X') {
            int which;
            std::cin>>which;
            store->deleteProduct(which);
        } else if (a == 'C') {
            int which;
            std::cin >> which;
            store->changeProduct(which);
        } else if (a == 'D') {
            store->showProducts();
        }
    }
    return 0;
}