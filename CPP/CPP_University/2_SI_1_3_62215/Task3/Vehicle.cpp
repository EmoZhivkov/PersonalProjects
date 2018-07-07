#include "Vehicle.h"

void Vehicle::clearVehicle()
{
	delete[] this->color;
	delete[] this->make;
	delete[] this->model;
}

void Vehicle::copyVehicle(const Vehicle & temp)
{
	this->year = temp.year;
	this->mileage = temp.mileage;
	this->setMake(temp.make);
	this->setModel(temp.model);
	this->setColor(temp.color);
}

Vehicle::Vehicle()
{
	this->year = 0;
	this->mileage = 0.0;
	this->setMake("");
	this->setModel("");
	this->setColor("");
}

Vehicle::Vehicle(const char * make, const char * model, const char * color, int year, double mileage)
{
	this->year = year;
	this->mileage = mileage;
	this->setMake(make);
	this->setModel(model);
	this->setColor(color);
}

Vehicle::Vehicle(const Vehicle & temp)
{
	this->copyVehicle(temp);
}


Vehicle & Vehicle::operator=(const Vehicle & temp)
{
	if (this != &temp)
	{
		this->clearVehicle();
		this->copyVehicle(temp);
	}
	return *this;
}

Vehicle::~Vehicle()
{
	this->clearVehicle();
}

void Vehicle::setMake(const char * make)
{
	int length = strlen(make) + 1;
	this->make = new char[length];
	memcpy(this->make, make, length);
}

char * Vehicle::getMake() const
{
	return this->make;
}

void Vehicle::setModel(const char * model)
{
	int length = strlen(model) + 1;
	this->model = new char[length];
	memcpy(this->model, model, length);
}

char * Vehicle::getModel() const
{
	return this->model;
}

void Vehicle::setColor(const char * color)
{
	int length = strlen(color) + 1;
	this->color = new char[length];
	memcpy(this->color, color, length);
}

char * Vehicle::getColor() const
{
	return this->color;
}

void Vehicle::setYear(int year)
{
	this->year = year;
}

int Vehicle::getYear() const
{
	return this->year;
}

void Vehicle::setMileage(double mileage)
{
	this->mileage = mileage;
}

double Vehicle::getMileage() const
{
	return this->mileage;
}
