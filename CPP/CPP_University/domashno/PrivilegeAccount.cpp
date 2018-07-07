#include "PrivilegeAccount.h"

PrivilegeAccount::PrivilegeAccount(const String& iban, int ownerId, double amount) :
	PrivilegeAccount(iban, ownerId, amount, 2000)
{
}

PrivilegeAccount::PrivilegeAccount(const String& iban, int ownerId, double amount, double overdraft) :
	Account(iban, ownerId, amount),
	overdraft(overdraft)
{
}

void PrivilegeAccount::deposit(double amount)
{
	Account::deposit(amount);
}

bool PrivilegeAccount::withdraw(double amount)
{
	return Account::withdraw(amount, overdraft);
}

void PrivilegeAccount::display() const
{
	std::cout << "Privilege Account with an overdraft: " << overdraft << std::endl;

	Account::display();
}

void PrivilegeAccount::setOverdragt(double overdraft)
{
	if (overdraft < 0)
		throw std::exception("An account could not be created with negative overdraft.");

	this->overdraft = overdraft;
}
