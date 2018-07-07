# Vehicles

#pragma once
#include "Vehicle.h"
class Motorcycle :
	public Vehicle
{
public:
	Motorcycle(const char* make = "", const char* model = "", const char* color = ""
		, int year = 1990, double mileage = 0.0, const char* type = "");
	~Motorcycle();
	Motorcycle(const Motorcycle& mc);
	Motorcycle& operator=(const Motorcycle& mc);

	void details() const;
private:
	char* m_type;
};
