#include "SavingsAccount.h"

SavingsAccount::SavingsAccount(const String& iban, int ownerId, double amount)
	:SavingsAccount(iban, ownerId, amount, 2.3)
{
}

SavingsAccount::SavingsAccount(const String& iban, int ownerId, double amount, double interestRate)
	:Account(iban, ownerId, amount), interestRate(interestRate)
{
}

void SavingsAccount::deposit(double amount)
{
	Account::deposit(amount);
}

bool SavingsAccount::withdraw(double amount)
{
	return withdraw(amount);
}

void SavingsAccount::display() const
{
	std::cout << "Saving Account with an interest rate: " << interestRate << std::endl;

	Account::display();
}

void SavingsAccount::setInterestRate(double interestRate)
{
	if (interestRate < 0)
		throw std::exception("An account could not be created with negative interest rate.");

	this->interestRate = interestRate;
}
