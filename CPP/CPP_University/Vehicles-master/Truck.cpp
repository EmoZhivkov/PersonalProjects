# Vehicles

#include "Truck.h"
#include<iostream>


Truck::Truck(const char* make, const char* model, const char* color,
	int year, double mileage, double size) : Vehicle(make, model, color, year, mileage), m_size(size)
{
}

Truck::Truck(const Truck& t) : Vehicle(t)
{
	m_size = t.m_size;
}

Truck& Truck::operator=(const Truck& t)
{
	if (this != &t)
	{
		Vehicle::operator=(t);
		m_size = t.m_size;
	}
	return *this;
}

void Truck::details() const
{
	std::cout << "This truck was made by : " << getMake()
		<< ". It is a "<<m_size<<" meters long, " << getColor() << " " << getModel()
		<< " made in " << getYear() << " and its mileage is currently at "
		<< getMileage() << " miles" << std::endl;
}
