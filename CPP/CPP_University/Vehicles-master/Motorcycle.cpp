# Vehicles

#include "Motorcycle.h"
#include<iostream>


Motorcycle::Motorcycle(const char* make, const char* model, const char* color
	, int year, double mileage, const char* type) : Vehicle(make, model, color, year, mileage)
{
	m_type = new char[strlen(type) + 1];
	strcpy_s(m_type, strlen(type) + 1, type);
}


Motorcycle::~Motorcycle()
{
	delete[] m_type;
}

Motorcycle::Motorcycle(const Motorcycle& mc) : Vehicle(mc)
{
	m_type = new char[strlen(mc.m_type) + 1];
	strcpy_s(m_type, strlen(mc.m_type) + 1, mc.m_type);
}

Motorcycle& Motorcycle::operator=(const Motorcycle& mc)
{
	if (this != &mc) {
		Vehicle::operator=(mc);
		delete[] m_type;
		m_type = new char[strlen(mc.m_type) + 1];
		strcpy_s(m_type, strlen(mc.m_type) + 1, mc.m_type);
	}
	return *this;
}

void Motorcycle::details() const
{
	std::cout << "This motorcycle was made by : " << getMake()
		<< ". It is a " << getColor() << " "<< m_type<<" " << getModel()
		<< " made in " << getYear() << " and its mileage is currently at "
		<< getMileage() << " miles" << std::endl;
}
