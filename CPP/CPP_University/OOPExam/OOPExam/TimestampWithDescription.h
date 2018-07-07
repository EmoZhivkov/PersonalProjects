#pragma once
#include "Timestamp.h"
#include <iostream>

class TimestampWithDescription:public Timestamp
{
private:
	char* description;
	void copyTimestampWithDescription(const TimestampWithDescription&);
public:
	TimestampWithDescription();
	TimestampWithDescription(const TimestampWithDescription& timestampWithDescription);
	TimestampWithDescription& operator=(const TimestampWithDescription& timestampWithDescription);
	~TimestampWithDescription();

};

