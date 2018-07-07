# Vehicles

#pragma once
#include "Vehicle.h"
class Truck :
	public Vehicle
{
public:
	Truck(const char* make = "", const char* model = "",const char* color = "",
		int year = 1990, double mileage = 0.0, double size = 0.0);
	~Truck() {};
	Truck(const Truck& t);
	Truck& operator=(const Truck& t);

	void details() const;
private:
	double m_size;
};
