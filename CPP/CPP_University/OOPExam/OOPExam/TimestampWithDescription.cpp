#include "TimestampWithDescription.h"



void TimestampWithDescription::copyTimestampWithDescription(const TimestampWithDescription & timestampWithDescription)
{
	this->setValue(timestampWithDescription.getValue());
	delete[] this->description;
	int lenght = strlen(timestampWithDescription.description) + 1;
	this->description = new char[lenght];
	memcpy(this->description, timestampWithDescription.description, lenght);

}



TimestampWithDescription::TimestampWithDescription()
{
	this->description = nullptr;
}

TimestampWithDescription::TimestampWithDescription(const TimestampWithDescription& timestampWithDescription)
{
	this->copyTimestampWithDescription(timestampWithDescription);
}

TimestampWithDescription::~TimestampWithDescription()
{
}
