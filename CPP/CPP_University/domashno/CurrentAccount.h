#ifndef CURRENT_ACCOUNT_H
#define CURRENT_ACCOUNT_H

#include "Account.h"

class CurrentAccount :
	public Account
{
public:
	CurrentAccount(const String& iban, int ownerId, double amount);

	virtual void deposit(double amount);
	virtual bool withdraw(double amount);
	virtual void display() const;
};


#endif // !CURRENT_ACCOUNT_H

