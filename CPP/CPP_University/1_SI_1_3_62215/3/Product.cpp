#include "Product.h"
#include <iostream>

int Product::getSKU() const {
    return SKU;
}

void Product::setSKU(int SKU) {
    Product::SKU = SKU;
}

char *Product::getBrand() const {
    return brand;
}

void Product::setBrand(char *brand) {
    Product::brand = brand;
}

char *Product::getModel() const {
    return model;
}

void Product::setModel(char *model) {
    Product::model = model;
}

double Product::getPrice() const {
    return price;
}

void Product::setPrice(double price) {
    Product::price = price;
}

int Product::getCount() const {
    return count;
}

void Product::setCount(int count) {
    Product::count = count;
}

int Product::getCaseDiameter() const {
    return caseDiameter;
}

void Product::setCaseDiameter(int caseDiameter) {
    Product::caseDiameter = caseDiameter;
}

bool Product::isAutomaticMechanism() const {
    return automaticMechanism;
}

void Product::setAutomaticMechanism(bool automaticMechanism) {
    Product::automaticMechanism = automaticMechanism;
}

Product::Product() {
    this->SKU = 0;
    this->brand = nullptr;
    this->model = nullptr;
    this->price = 0.0;
    this->count = 0;
    this->caseDiameter = 0;
    this->automaticMechanism = false;
}

Product::Product(Product const &other) {
    this->SKU = other.getSKU();
    this->brand = other.getBrand();
    this->model = other.getModel();
    this->price = other.getPrice();
    this->count = other.getCount();
    this->caseDiameter = other.getCaseDiameter();
    this->automaticMechanism = other.isAutomaticMechanism();
}

Product &Product::operator=(Product const &other) {
    if  (this != &other) {
        this->SKU = other.getSKU();
        this->brand = other.getBrand();
        this->model = other.getModel();
        this->price = other.getPrice();
        this->count = other.getCount();
        this->caseDiameter = other.getCaseDiameter();
        this->automaticMechanism = other.isAutomaticMechanism();
    }
    return *this;
}

Product::~Product() {
    delete[] this->brand;
    delete[] this->model;
}

Product::Product(int SKU, char *brand, char *model, double price, int count, int caseDiameter,
                 bool automaticMechanism) {
    this->SKU = SKU;
    this->brand = brand;
    this->model = model;
    this->price = price;
    this->count = count;
    this->caseDiameter = caseDiameter;
    this->automaticMechanism = automaticMechanism;
}

void Product::printInfo() {
    std::cout<< "SKU: " << this->SKU << std::endl;
    std::cout<< "Brand: " << this->brand << std::endl;
    std::cout<< "Model: " << this->model << std::endl;
    std::cout<< "Price: " << this->price << std::endl;
    std::cout<< "Count: " << this->count << std::endl;
    std::cout<< "Case Diameter: " << this->caseDiameter << std::endl;
    std::cout<< "Automatic Mechanism: ";
    if (this->automaticMechanism)
        std::cout<<"true"<< std::endl;
    else
        std::cout<<"false"<<std::endl;
}

void Product::change() {
    std::cout<< "SKU: " ;
    int a;
    std::cin>>a;
    this->SKU = a;

    std::cout<< "Brand: ";
    char*brand = new char[100];
    std::cin>>brand;
    this->brand = brand;

    std::cout<< "Model: ";
    char*model = new char[100];
    std::cin>>model;
    this->model = model;

    std::cout<< "Price: ";
    double price;
    std::cin>>price;
    this->price = price;

    std::cout<< "Count: ";
    int count;
    std::cin>>count;
    this->count = count;

    std::cout<< "Case Diameter: ";
    int diameter;
    std::cin>>diameter;
    this->caseDiameter = diameter;

    std::cout<< "Automatic Mechanism(0 is for false, 1 is for true): ";
    int mechanism;
    std::cin>>mechanism;
    if (mechanism == 1) {
        this->automaticMechanism = true;
    } else {
        this->automaticMechanism = false;
    }
}
