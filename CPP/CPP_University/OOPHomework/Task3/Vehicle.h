#pragma once
#include <iostream>

class Vehicle
{
private:
	char* make;
	char* model;
	char* color;
	int year;
	double mileage;

	void clearVehicle();
	void copyVehicle(const Vehicle& temp);
public:
	Vehicle();
	Vehicle(const char* make, const char* model, const char* color,
		int year, double mileage);
	Vehicle(const Vehicle& temp);
	Vehicle& operator=(const Vehicle& temp);
	virtual ~Vehicle();

	void setMake(const char* make);
	char* getMake() const;


	void setModel(const char* model);
	char* getModel() const;

	void setColor(const char* color);
	char* getColor() const;

	void setYear(int year);
	int getYear() const;

	void setMileage(double mileage);
	double getMileage() const;

	virtual void details() const = 0;
};

