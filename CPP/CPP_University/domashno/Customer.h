#ifndef CUSTOMER_H
#define CUSTOMER_H

#include "String.h"

class Customer
{
private:
	int id;
	String name;
	String address;

	void setId(int id);
public:
	Customer();
	Customer(int id, const String& name, const String& address);

	int getId() const { return id; }
	const String& getName() const { return name; }
	const String& getAddress() const { return address; }

	void display() const;
};

#endif // !CUSTOMER_H