#include "ElectricNet.h"


ElectricNet::ElectricNet()
{
	this->resizeCounter = 1;
	this->maxPower = 0;
	this->currConsumption = 0;
	this->currentDeviceCount = 0;
	this->allDevices = new ElectricDevice[31];
}

ElectricNet::~ElectricNet()
{
	this->clearElectricNet();
}

ElectricNet::ElectricNet(const ElectricNet &temp)
{
	this->copyElectricNet(temp);
}

ElectricNet& ElectricNet::operator=(const ElectricNet & temp)
{
	if (this != &temp)
	{
		this->clearElectricNet();
		this->copyElectricNet(temp);
	}
	return *this;
}

ElectricNet & ElectricNet::operator+(const ElectricDevice & temp)
{
	if (temp.getPower() + this->currConsumption > this->maxPower)
	{	
		cout << "You have exceeded the power capabilities!" << endl;
		return *this;
	}

	this->allDevices[this->currentDeviceCount] = temp;
	this->currConsumption = this->currConsumption + temp.getPower();
	this->currentDeviceCount++;

	if (this->currentDeviceCount % (30 * this->resizeCounter) == 1)
	{
		ElectricDevice *temporary = new ElectricDevice[(30 * this->resizeCounter) + 1];
		for (int i = 0; i < (30 * this->resizeCounter) + 1; i++)
		{
			temporary[i] = this->allDevices[i];
		}
		delete[] this->allDevices;
		
		this->allDevices = new ElectricDevice[(30 * ((currentDeviceCount / 30) + 1)) + 1];

		for (int i = 0; i < (30 * this->resizeCounter) + 1; i++)
		{
			this->allDevices[i] = temporary[i];
		}
		delete[] temporary;
		this->resizeCounter++;
	}
	return *this;
}

ElectricNet & ElectricNet::operator+=(const ElectricDevice & temp)
{
	if (temp.getPower() + this->currConsumption > this->maxPower)
	{
		cout << "You have exceeded the power capabilities!" << endl;
		return *this;
	}

	this->allDevices[this->currentDeviceCount] = temp;
	this->currConsumption = this->currConsumption + temp.getPower();
	this->currentDeviceCount++;

	if (this->currentDeviceCount % (30 * this->resizeCounter) == 1)
	{
		ElectricDevice *temporary = new ElectricDevice[(30 * this->resizeCounter) + 1];
		for (int i = 0; i < (30 * this->resizeCounter) + 1; i++)
		{
			temporary[i] = this->allDevices[i];
		}
		delete[] this->allDevices;

		this->allDevices = new ElectricDevice[(30 * ((currentDeviceCount / 30) + 1)) + 1];

		for (int i = 0; i < (30 * this->resizeCounter) + 1; i++)
		{
			this->allDevices[i] = temporary[i];
		}
		delete[] temporary;
		this->resizeCounter++;
	}
	return *this;
}

ElectricNet & ElectricNet::operator-(const ElectricDevice & temp)
{
	for (size_t i = 0; i < this->currentDeviceCount; i++)
	{
		ElectricDevice currentDevice = this->allDevices[currentDeviceCount - 1];
		if (strcmp(currentDevice.getName(), temp.getName()) == 0)
		{
			int indexToRemoveDevice = i;
			for (int j = indexToRemoveDevice; j < currentDeviceCount - 1; j++)
			{
				this->allDevices[j] = this->allDevices[j + 1];
			}
			this->currentDeviceCount--;
			this->currConsumption = this->currConsumption - currentDevice.getPower();
			break;
		}
	}
	return *this;
}

ElectricNet & ElectricNet::operator-=(const ElectricDevice & temp)
{
	for (size_t i = 0; i < this->currentDeviceCount; i++)
	{
		ElectricDevice currentDevice = this->allDevices[currentDeviceCount - 1];
		if (strcmp(currentDevice.getName(), temp.getName()) == 0)
		{
			int indexToRemoveDevice = i;
			for (int j = indexToRemoveDevice; j < currentDeviceCount - 1; j++)
			{
				this->allDevices[j] = this->allDevices[j + 1];
			}
			this->currentDeviceCount--;
			this->currConsumption = this->currConsumption - currentDevice.getPower();
			break;
		}
	}
	return *this;
}

void ElectricNet::operator++()
{
	this->maxPower = this->maxPower * 2;
}

void ElectricNet::operator--()
{
	if (this->maxPower / 2 < this->currConsumption)
	{
		cout << "The Electric Net will not be able to handle the power." << endl;
		return;
	}
	this->maxPower = this->maxPower / 2;
}

bool ElectricNet::operator!()
{
	bool b = true;
	if (this->currentDeviceCount == 0)
	{
		b = false;
	}
	return b;
}

ElectricDevice & ElectricNet::operator[](const char * name)
{
	for (int i = 0; i < this->currentDeviceCount; i++)
	{
		ElectricDevice currentDevice = this->allDevices[currentDeviceCount - 1];
		if (strcmp(currentDevice.getName(), name) == 0)
		{
			return currentDevice;
		}
	}
	cout << "There is no such device! Therefore the returned Device is empty" << endl;

	return *(new ElectricDevice());
}

void ElectricNet::setAllDevices(ElectricDevice *temp, int currentDeviceCount)
{
	delete[] this->allDevices;
	this->allDevices = new ElectricDevice[(30 * this->resizeCounter) + 1];
	for (int i = 0; i < currentDeviceCount; i++)
	{
		this->allDevices[i] = temp[i];
	}
}

void ElectricNet::copyElectricNet(const ElectricNet & temp)
{
	this->clearElectricNet();
	this->resizeCounter = temp.resizeCounter;
	this->maxPower = temp.maxPower;
	this->currConsumption = temp.currConsumption;
	this->currentDeviceCount = temp.currentDeviceCount;
	this->setAllDevices(temp.allDevices, temp.currentDeviceCount);
}

void ElectricNet::clearElectricNet()
{
	delete[] this->allDevices;
}
