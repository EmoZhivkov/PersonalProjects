# Vehicles

#pragma once
#include "Vehicle.h"
class Car :
	public Vehicle
{
public:
	Car(const char* make = "", const char* model = "", const char* color = "",
		int year = 1990, double mileage = 0.0);
	Car(const Car& c) : Vehicle(c) {};
	Car& operator=(const Car& c);
	~Car() {};

	void details()const;
};
