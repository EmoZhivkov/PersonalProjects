#ifndef BANK_H
#define BANK_H

#include "Vector.h"
#include "String.h"
#include "Customer.h"
#include "Account.h"

enum AccountType{CURRENT_ACCOUNT = 1, SAVINGS_ACCOUNTS = 2, PRIVILEGE_ACCOUNT = 3};

class Bank
{
private:
	enum { NO_MATCH_FOUND = -1 };
	String name;
	String address;
	Vector<Customer> customers;
	Vector<Account*> accounts;

	Vector<Account*> accountsOwnedByCustomer(int customerId) const;
	int findAccount(const String& iban) const;
	bool customerExist(int id) const;
public:
	Bank(const String& name, const String& address);
	~Bank();

	const String& getName() const { return name; }
	const String& getAddres() const { return address; }

	void addCustomer(int customerId, const String& name, const String& address);
	void listCustomers() const;
	void deleteCustomer(int customerId);
	
	void addAccount(AccountType type, const String& iban, int ownerId, double amount);
	void deleteAccount(const String& iban);
	void listAccounts() const;

	void listCustomerAccount(int ownerId) const;
	void transfer(const String& sender, const String& receiver, double amount);
	void withdraw(const String& iban, double amount);
	void deposit(const String& iban, double amount);
	void display() const;
};

#endif // !BANK_H
