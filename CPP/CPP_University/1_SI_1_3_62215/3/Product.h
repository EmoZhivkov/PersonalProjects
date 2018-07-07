#ifndef ONLINESTORE_PRODUCT_H
#define ONLINESTORE_PRODUCT_H

//the products will be watches
class Product {
private:
    int SKU;
    char * brand;
    char * model;
    double price;
    int count;
    int caseDiameter; //the diameter of the case in mm
    bool automaticMechanism; //is the mechanism automatic
public:
    Product();
    Product(Product const & other);
    Product& operator =(Product const & other);
    ~Product();
    Product(int SKU, char * brand, char * model, double price,
            int count, int caseDiameter, bool automaticMechanism);

    void printInfo();

    void change();

    int getSKU() const;

    void setSKU(int SKU);

    char *getBrand() const;

    void setBrand(char *brand);

    char *getModel() const;

    void setModel(char *model);

    double getPrice() const;

    void setPrice(double price);

    int getCount() const;

    void setCount(int count);

    int getCaseDiameter() const;

    void setCaseDiameter(int caseDiameter);

    bool isAutomaticMechanism() const;

    void setAutomaticMechanism(bool automaticMechanism);
};


#endif //ONLINESTORE_PRODUCT_H
