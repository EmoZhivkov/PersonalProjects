#pragma once
#include"ElectricDevice.h"
#include <iostream>
using namespace std;

class ElectricNet
{
private:
	int resizeCounter;
	int maxPower;
	int currConsumption;
	int currentDeviceCount;
	ElectricDevice *allDevices;

	void setAllDevices(ElectricDevice *temp, int currentDeviceCount);
	void copyElectricNet(const ElectricNet& temp);
	void clearElectricNet();
public:
	ElectricNet();
	~ElectricNet();
	ElectricNet(const ElectricNet&);
	ElectricNet& operator=(const ElectricNet& temp);

	ElectricNet& operator+(const ElectricDevice& temp);
	ElectricNet& operator+=(const ElectricDevice& temp);
	ElectricNet& operator-(const ElectricDevice& temp);
	ElectricNet& operator-=(const ElectricDevice& temp);
	void operator++();
	void operator--();
	bool operator!();
	ElectricDevice& operator[](const char * name);
};
