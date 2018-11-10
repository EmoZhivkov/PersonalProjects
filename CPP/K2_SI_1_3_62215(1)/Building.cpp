#include "Building.h"



Building::Building()
{
	this->height = 0;
	this->area = 0;
	this->floors = 0;
}

Building::Building(int height, int area, int floors)
{
	this->height = height;
	this->area = area;
	this->floors = floors;
}

int Building::getTotalArea()
{
	return this->area * this->floors;
}

bool Building::operator<(const Building & building)
{
	int firstBuildingArea = this->getTotalArea();
	int secondBuildingArea = building.area * building.floors;
	bool b = true;
	if (firstBuildingArea >= secondBuildingArea)
	{
		b = false;
	}
	return false;
}

void Building::setHeight(int height)
{
	this->height = height;
}

int Building::getHeight() const
{
	return this->height;
}

void Building::setArea(int area)
{
	this->area = area;
}

int Building::getArea() const
{
	return this->area;
}

void Building::setFloors(int floors)
{
	this->floors = floors;
}

int Building::getFloors() const
{
	return this->floors;
}

ostream & operator<<(ostream & os, const Building & building)
{
	os << "Height: " << building.height << "\n"; 
	os << "Area: " << building.area << "\n";
	os << "Floors: " << building.floors << "\n";
	return os;
}
