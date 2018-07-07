#include "Timestamp.h"

Timestamp::Timestamp()
{
	this->time = 0;
}

Timestamp::Timestamp(unsigned long time)
{
	this->time = time;
}

Timestamp::Timestamp(const Timestamp & timestamp)
{
	this->copyTimestamp(timestamp);
}



void Timestamp::setValue(unsigned long time)
{
	this->time = time;
}

unsigned long Timestamp::getValue() const
{
	return this->time;
}

void Timestamp::operator+=(unsigned long time)
{
	this->time = this->time + time;
}

Timestamp & Timestamp::operator+(unsigned long time)
{
	Timestamp * newTime = new Timestamp(*this);
	newTime += time;
	return *newTime;
}


void Timestamp::copyTimestamp(const Timestamp & timestamp)
{
	this->time = timestamp.time;
}

istream & operator>>(istream & is, const Timestamp & timestamp)
{
	is >> timestamp.time;
	return is;
}

ostream & operator<<(ostream & os, const Timestamp & timestamp)
{
	os << timestamp.time;
	return os;
}
