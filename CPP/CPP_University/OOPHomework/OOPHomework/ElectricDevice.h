#pragma once
class ElectricDevice
{
private:
	int power;
	char * name;
public:
	ElectricDevice();
	ElectricDevice(int power, const char* name);
	ElectricDevice(const ElectricDevice& temp);
	~ElectricDevice();
	ElectricDevice& operator=(const ElectricDevice& temp);
	
	void copyElectricDevice(const ElectricDevice& device);
	void clearElectricDevice();
	
	void setPower(int power);
	int getPower() const;

	void setName(const char* name);
	char* getName() const;
};

