#include <iostream>
using namespace std;

#pragma once
class Timestamp
{
private:
	unsigned long time;
	void copyTimestamp(const Timestamp& timestamp);
public:

	Timestamp();
	Timestamp(unsigned long time);
	Timestamp(const Timestamp& timestamp);

	void setValue(unsigned long time);
	unsigned long getValue() const;
	
	friend istream& operator>>(istream& is, const Timestamp& timestamp);
	friend ostream& operator<<(ostream& os, const Timestamp& timestamp);

	void operator+=(unsigned long time);
	Timestamp& operator+(unsigned long time);
};

