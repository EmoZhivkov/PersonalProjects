#include "ElectricDevice.h"
#include <cstring>


ElectricDevice::ElectricDevice()
{
	this->power = 0;
	this->name = nullptr;
}

ElectricDevice::ElectricDevice(int power, const char * name) : name(nullptr)
{
	this->setName(name);
	this->setPower(power);
}

ElectricDevice::ElectricDevice(const ElectricDevice & temp) : name(nullptr)
{
	this->copyElectricDevice(temp);
}


ElectricDevice::~ElectricDevice()
{
	this->clearElectricDevice();
}

ElectricDevice & ElectricDevice::operator=(const ElectricDevice & temp)
{
	if (this != &temp)
	{
		this->clearElectricDevice();
		this->copyElectricDevice(temp);
	}
	return *this;
	
}

void ElectricDevice::copyElectricDevice(const ElectricDevice & device)
{
	this->setPower(device.power);
	this->setName(device.name);
}

void ElectricDevice::clearElectricDevice()
{
	delete[] this->name;
	this->name = nullptr;
}

void ElectricDevice::setPower(int power)
{
	this->power = power;
}

int ElectricDevice::getPower() const
{
	return this->power;
}

void ElectricDevice::setName(const char * name)
{
	this->name = nullptr;
	if (name == nullptr)
	{
		this->name = nullptr;
		return;
	}

	int lenght = strlen(name);
	this->name = new char[lenght + 1];
	for (int i = 0; i < lenght; i++)
	{
		this->name[i] = name[i];
	}
	this->name[lenght] = '\0';
}

char * ElectricDevice::getName() const
{
	return this->name;
}
