#ifndef ONLINESTORE_STORE_H
#define ONLINESTORE_STORE_H

#include "Product.h"

class Store {
private:
    int counter = 0;
    int productCount;
    Product* products;
public:
    Store(int productCount);
    Store(Store const & other);
    Store& operator =(Store const & other);
    ~Store();
    void addProduct();
    void addProduct(Product& product);
    void deleteProduct(int SKU);
    void changeProduct(int SKU);
    void showProducts();

    int getProductCount() const;

    void setProductCount(int productCount);

    Product *getProducts() const;

    void setProducts(Product *products);
};


#endif //ONLINESTORE_STORE_H
