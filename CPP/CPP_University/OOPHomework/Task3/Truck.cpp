#include "Truck.h"



Truck::Truck()
{
	this->setYear(0);
	this->setMileage(0.0);
	this->setMake("");
	this->setModel("");
	this->setColor("");
	this->size = 0.0;
}

Truck::Truck(const char * make, const char * model, const char * color, int year, double mileage, double size)
{
	this->setYear(year);
	this->setMileage(mileage);
	this->setMake(make);
	this->setModel(model);
	this->setColor(color);
	this->size = size;
}

Truck::Truck(const Truck & temp) : Vehicle(temp)
{
	this->size = temp.size;
}

Truck & Truck::operator=(const Truck & temp)
{
	if (this != &temp)
	{
		Vehicle::operator=(temp);
		this->size = temp.size;
	}
	return *this;
}

void Truck::details() const
{
	cout << "This car was made by : " << getMake() << "." << endl;
	cout << "It is a " << this->size << " meters long, " << getColor() << " " << getModel() << "." << endl;
	cout << "It is made in " << getYear() << " and its mileage is currently at "
		<< getMileage() << " miles" << endl;
}


