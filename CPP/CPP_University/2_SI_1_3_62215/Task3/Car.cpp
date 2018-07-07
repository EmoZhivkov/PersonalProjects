#include "Car.h"
using namespace std;


Car::Car()
{
	this->setYear(0);
	this->setMileage(0.0);
	this->setMake("");
	this->setModel("");
	this->setColor("");
}

Car::Car(const char * make, const char * model, const char * color, int year, double mileage)
{
	this->setYear(year);
	this->setMileage(mileage);
	this->setMake(make);
	this->setModel(model);
	this->setColor(color);
}

Car & Car::operator=(const Car & temp)
{
	if (this != &temp)
	{
		Vehicle::operator=(temp);
	}
	return *this;
}

void Car::details() const
{
	cout << "This car was made by : " << getMake() << "." << endl;
	cout << "It is a " << getColor() << " " << getModel() << "." << endl;
	cout << "It is made in " << getYear() << " and its mileage is currently at "
		<< getMileage() << " miles" << endl;
}
