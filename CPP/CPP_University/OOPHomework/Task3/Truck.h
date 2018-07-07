#pragma once
#include "Vehicle.h"
using namespace std;

class Truck : public Vehicle
{
private:
	double size;
public:
	Truck();
	Truck(const char* make, const char* model, const char* color,
		int year, double mileage, double size);
	Truck(const Truck& temp);
	Truck& operator=(const Truck& temp);
	~Truck() {};

	void details() const;
};

