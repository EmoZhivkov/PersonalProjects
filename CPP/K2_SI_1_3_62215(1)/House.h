#pragma once
#include "Building.h"

class House:public Building
{
private:
	int numberOfRooms;
	char* ownerName;
public:
	House();
	House(int height, int area, int numberOfFloors, int numberOfRooms, const char* ownerName);
	House(const House& house);
	void operator=(const House& house);
	~House();

	bool operator<(const House& house);
	friend ostream& operator<<(ostream& os, const House& house);

	void setOwnerName(const char* ownerName);
	char * getOwnerName() const;

	void setNumberOfRooms(int numberOfRooms);
	int getNumberOfRooms() const;

	void copyHouse(const House& house);
	void clearHouse();
};

