#ifndef ACCOUNT_H
#define ACCOUNT_H

#include<iostream>
#include "String.h"

class Account
{
private:
	String iban;
	int ownerId;
	double amount;

	void draw(double amount);
	void setAmount(double amount);
public:
	Account(const String& iban, int ownerId, double amount);
	virtual ~Account() {};

	double getBalance() const { return amount; }
	bool isAccountWith(int ownerId) const { return ownerId == this->ownerId; }
	bool isAccountWith(const String& iban) const { return (iban == this->iban); }

	virtual void deposit(double amount) = 0;
	virtual bool withdraw(double amount) = 0;
	virtual void display() const = 0;

protected:
	bool withdraw(double amount, double overdraft);
};


#endif // !ACCOUNT_H

