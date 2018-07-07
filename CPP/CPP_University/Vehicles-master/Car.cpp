# Vehicles

#include "Car.h"
#include<iostream>

Car::Car(const char* make, const char* model, const char* color,
	int year, double mileage) : Vehicle(make, model, color, year, mileage)
{
}

Car& Car::operator=(const Car& c)
{
	if (this != &c)
	{
		Vehicle::operator=(c);
	}
	return *this;
}

void Car::details() const 
{
	std::cout << "This car was made by : " << getMake()
	<< ". It is a " << getColor() << " " << getModel()
	<< " made in " << getYear() << " and its mileage is currently at "
	<< getMileage() << " miles" << std::endl;
}
