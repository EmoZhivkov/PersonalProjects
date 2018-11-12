#include "House.h"

House::House()
{
	this->ownerName = nullptr;
	this->numberOfRooms = 0;
	this->setHeight(0);
	this->setArea(0);
	this->setFloors(0);

}

House::House(int height, int area, int numberOfFloors, int numberOfRooms, const char * ownerName)
{
	this->setHeight(height);
	this->setArea(area);
	this->setFloors(numberOfFloors);
	this->numberOfRooms = numberOfRooms;
	this->setOwnerName(ownerName);
}

House::House(const House & house)
{
	this->copyHouse(house);
}

void House::operator=(const House & house)
{
	this->clearHouse();
	this->copyHouse(house);
}


House::~House()
{
	this->clearHouse();
}

bool House::operator<(const House & house)
{
	bool b = true;
	if (this->numberOfRooms >= house.numberOfRooms)
	{
		b = false;
	}
	return b;
}

ostream & operator<<(ostream & os, const House & house)
{
	os << "Height: " << house.getHeight() << "\n";
	os << "Area: " << house.getArea() << "\n";
	os << "Floors: " << house.getFloors() << "\n";
	os << "Number of rooms: " << house.numberOfRooms << "\n";
	os << "Owner name: " << house.ownerName << "\n";
	return os;
}

void House::setOwnerName(const char * ownerName)
{
	delete[] this->ownerName;
	int lenght = strlen(ownerName) + 1;
	this->ownerName = new char[lenght];
	memcpy(this->ownerName, ownerName, lenght);
}

char * House::getOwnerName() const
{
	return this->ownerName;
}

void House::setNumberOfRooms(int numberOfRooms)
{
	this->numberOfRooms = numberOfRooms;
}

int House::getNumberOfRooms() const
{
	return this->numberOfRooms;
}

void House::copyHouse(const House & house)
{
	this->setOwnerName(house.ownerName);
	this->setNumberOfRooms(house.numberOfRooms);
	this->setHeight(house.getHeight());
	this->setArea(house.getArea());
	this->setFloors(house.getFloors());
}

void House::clearHouse()
{
	delete[] this->ownerName;
}


