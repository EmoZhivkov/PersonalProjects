# Vehicles

#include "Vehicle.h"
#include<iostream>


Vehicle::Vehicle(const char* make, const char* model, const char* color,
	int year, double mileage) : m_year(year), m_mileage(mileage)
{
	m_make = new char[strlen(make) + 1];
	strcpy_s(m_make, strlen(make) + 1, make);

	m_model = new char[strlen(model) + 1];
	strcpy_s(m_model, strlen(model) + 1, model);

	m_color = new char[strlen(color) + 1];
	strcpy_s(m_color, strlen(color) + 1, color);
}

Vehicle::Vehicle(const Vehicle& v)
{
	Copy(v);
}

Vehicle& Vehicle::operator=(const Vehicle& v)
{
	if (this != &v)
	{
		Destroy();
		Copy(v);
	}
	return *this;
}

Vehicle::~Vehicle()
{
	Destroy();
}

void Vehicle::Destroy() 
{
	delete[] m_color;
	delete[] m_make;
	delete[] m_model;
}

void Vehicle::Copy(const Vehicle& v) 
{
	m_year = v.m_year;
	m_mileage = v.m_mileage;
	m_make = new char[strlen(v.m_make) + 1];
	strcpy_s(m_make, strlen(v.m_make) + 1, v.m_make);

	m_model = new char[strlen(v.m_model) + 1];
	strcpy_s(m_model, strlen(v.m_model) + 1, v.m_model);

	m_color = new char[strlen(v.m_color) + 1];
	strcpy_s(m_color, strlen(v.m_color) + 1, v.m_color);
}

void Vehicle::setMake(const char* make)
{
	m_make = new char[strlen(make) + 1];
	strcpy_s(m_make, strlen(make) + 1, make);
}

void Vehicle::setModel(const char* model)
{
	m_model = new char[strlen(model) + 1];
	strcpy_s(m_model, strlen(model) + 1, model);
}

void Vehicle::setColor(const char* color)
{
	m_color = new char[strlen(color) + 1];
	strcpy_s(m_color, strlen(color) + 1, color);
}

