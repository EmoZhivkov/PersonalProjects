#pragma once
#include "Vehicle.h"

class Motorcycle : public Vehicle
{
private:
	char* type;
public:
	Motorcycle();
	Motorcycle(const char* make, const char* model, const char* color,
		int year, double mileage, const char* type);
	Motorcycle(const Motorcycle& temp);
	Motorcycle& operator=(const Motorcycle& temp);
	~Motorcycle();

	void details() const;
};

