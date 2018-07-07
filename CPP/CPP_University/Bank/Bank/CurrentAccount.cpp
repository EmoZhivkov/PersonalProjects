#include "CurrentAccount.h"
#include<iostream>


CurrentAccount::CurrentAccount(const String& iban, int ownerId, double amount)
	:Account(iban, ownerId, amount)
{
}

void CurrentAccount::deposit(double amount)
{
	Account::deposit(amount);
}

bool CurrentAccount::withdraw(double amount)
{
	return Account::withdraw(amount);
}

void CurrentAccount::display() const
{
	std::cout << "Current Account:" << std::endl;

	Account::display();
}
