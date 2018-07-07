#include "Motorcycle.h"
using namespace std;


Motorcycle::Motorcycle()
{
	this->setYear(0);
	this->setMileage(0.0);
	this->setMake("");
	this->setModel("");
	this->setColor("");
	this->type = nullptr;
}

Motorcycle::Motorcycle(const char * make, const char * model, const char * color, int year, double mileage, const char * type)
{
	this->setYear(year);
	this->setMileage(mileage);
	this->setMake(make);
	this->setModel(model);
	this->setColor(color);
	this->type = new char[strlen(type) + 1];
	memcpy(this->type, type, strlen(type) + 1);
}

Motorcycle::Motorcycle(const Motorcycle & temp) : Vehicle(temp)
{
	this->type = new char[strlen(temp.type) + 1];
	memcpy(this->type, temp.type, strlen(temp.type) + 1);
}

Motorcycle & Motorcycle::operator=(const Motorcycle & temp)
{
	if (this != &temp)
	{
		Vehicle::operator=(temp);
		delete[] this->type;
		this->type = new char[strlen(temp.type) + 1];
		memcpy(this->type, temp.type, strlen(temp.type) + 1);
	}
	return *this;
}


Motorcycle::~Motorcycle()
{
	delete[] this->type;
}

void Motorcycle::details() const
{
	cout << "This car was made by : " << getMake() << "." << endl;
	cout << "It is a " << getColor() << " " << this->type << " " << " " << getModel() << "." << endl;
	cout << "It is made in " << getYear() << " and its mileage is currently at "
		<< getMileage() << " miles" << endl;
}
