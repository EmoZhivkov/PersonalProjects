#include "Store.h"

int Store::getProductCount() const {
    return productCount;
}

void Store::setProductCount(int productCount) {
    Store::productCount = productCount;
}

Product *Store::getProducts() const {
    return products;
}

void Store::setProducts(Product *products) {
    Store::products = products;
}

Store::Store(int productCount) {
    this->productCount = productCount;
    this->products = new Product[productCount];
}

Store::Store(Store const &other) {
    this->productCount = other.getProductCount();
    this->products = other.getProducts();
}

Store &Store::operator=(Store const &other) {
    if (this != &other) {
        this->productCount = other.getProductCount();
        this->products = other.getProducts();
    }
    return *this;
}

Store::~Store() {
    delete[] this->products;
}

void Store::addProduct(Product &product) {
    this->products[counter] = product;
    counter++;
}

void Store::deleteProduct(int SKU) {
    for (int i = 0; i < counter; ++i) {
        if (this->products[i].getSKU() == SKU) {
            products[i] = Product();
        }
    }
}

void Store::changeProduct(int SKU) {
    for (int i = 0; i < counter; ++i) {
        if (this->products[i].getSKU() == SKU) {
            products[i].change();
        }
    }
}

void Store::showProducts() {
    for (int i = 0; i < counter; ++i) {
        this->products[i].printInfo();
    }
}

void Store::addProduct() {
    Product *product = new Product();
    product->change();
    this->addProduct(*product);
}
