#pragma once
#include <iostream>
using namespace std;

class Building
{
private:
	int height;
	int area;
	int floors;
public:
	Building();
	Building(int height, int area, int floors);
	int getTotalArea();
	bool operator<(const Building& building);
	friend ostream& operator<<(ostream& os, const Building& building);


	void setHeight(int height);
	int getHeight() const;

	void setArea(int area);
	int getArea() const;

	void setFloors(int floors);
	int getFloors() const;
};

