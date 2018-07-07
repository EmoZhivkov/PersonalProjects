#ifndef PRIVILEGE_ACCOUNT_H
#define PRIVILEGE_ACCOUNT_H

#include "Account.h"

class PrivilegeAccount :
	public Account
{
private:
	double overdraft;

	void setOverdragt(double overdraft);
public:
	PrivilegeAccount(const String& iban, int ownerId, double amount);
	PrivilegeAccount(const String& iban, int ownerId, double amount, double overdrafr);

	double getOverdraft() const { return overdraft; }

	virtual void deposit(double amount);
	virtual bool withdraw(double amount);
	virtual void display() const;
};

#endif // !PRIVILEGE_ACCOUNT_H

