#include "Account.h"
#include<iostream>

Account::Account(const String& iban, int ownerId, double amount) :
	iban(iban) ,
	ownerId(ownerId)
{
	setAmount(amount);
}

void Account::deposit(double amount)
{
	this->amount += amount;
}

bool Account::withdraw(double amount)
{
	if (this->amount >= amount)
	{
		draw(amount);
		return true;
	}
	
	return false;
}

void Account::display() const
{
	std::cout << "	IBAN: " << iban << std::endl;
	std::cout << "	Owner's Id: " << ownerId << std::endl;
	std::cout << "	Balance: " << amount << std::endl;
}

bool Account::withdraw(double amount, double overdraft)
{
	if (amount <= this->amount + overdraft)
	{
		draw(amount);
		return true;
	}

	return false;
}

void Account::draw(double amount)
{ 
	this->amount -= amount;
}

void Account::setAmount(double amount)
{
	if (amount < 0)
		throw std::exception("An account could not be created with negative amount of money.");

	this->amount = amount;
}
