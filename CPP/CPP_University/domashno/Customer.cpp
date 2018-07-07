#include "Customer.h"
#include<iostream>
#include<exception>

/*Customer::Customer() : Customer(0, "No_name", "No_address")
{
}*/

Customer::Customer() :
	name(""),
	address("")
{
	id = -1;
}

Customer::Customer(int id, const String& name, const String& address) :
	name(name),
	address(address)
{
	setId(id);
}

void Customer::display() const
{
	std::cout << "Custtomer: #" << getId() << "; Name: " << getName() << "; Address: " << getAddress() << std::endl;
}

void Customer::setId(int id)
{
	if (id >= 0)
	{
		this->id = id;
	}
	else
		throw std::exception("Id can not be negative number.");
}
