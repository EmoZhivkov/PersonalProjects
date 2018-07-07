#ifndef SAVINGS_ACCOUNT_H
#define SAVINGS_ACCOUNT_H

#include "Account.h"

class SavingsAccount :
	public Account
{
private:
	double interestRate;

	void setInterestRate(double interestRate);
public:
	SavingsAccount(const String& iban, int ownerId, double amount);
	SavingsAccount(const String& iban, int ownerId, double amount, double interestRate);

	double getInterestRate() const { return interestRate; }

	virtual void deposit(double amount);
	virtual bool withdraw(double amount);
	virtual void display() const;
};

#endif // !SAVINGS_ACCOUNT_H
