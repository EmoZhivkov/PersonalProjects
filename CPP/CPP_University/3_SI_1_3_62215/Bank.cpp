#include "Bank.h"

#include<exception>

#include "HelperFunctions.h"
#include "CurrentAccount.h"
#include "SavingsAccount.h"
#include "PrivilegeAccount.h"

Bank::Bank(const String& name, const String& address) :
	name(name),
	address(address)
{
}

Bank::~Bank()
{
	for (int i = 0; i < accounts.getSize(); i++)
	{
		delete accounts[i];
	}
}

void Bank::addCustomer(int customerId, const String& name, const String& address)
{
	if (!customerExist(customerId))
	{
		customers.pushBack(Customer(customerId, name, address));
	}
	else
		throw std::exception("This id is already taken.");
}

void Bank::listCustomers() const
{
	for (int i = 0; i < customers.getSize(); i++)
	{
		customers[i].display();
	}
}

void Bank::deleteCustomer(int customerId)
{
	int index = -1;

	for (int i = 0; i < customers.getSize(); i++)
	{
		if (customers[i].getId() == customerId)
		{
			index = i;
			break;
		}
	}

	if (index >= 0)
	{
		customers.erase(index);

		for (int i = 0; i < accounts.getSize(); i++)
		{
			if (accounts[i]->isAccountWith(customerId))
			{
				accounts.erase(i);
			}
		}
	}
	else
		throw std::exception("There is no customer with this id.");
}

void Bank::addAccount(AccountType type, const String& iban, int ownerId, double amount)
{

	if (customerExist(ownerId) && findAccount(iban) == NO_MATCH_FOUND)
	{
		double interestRate = 0;
		double overdraft = 0;
		switch (type)
		{
		case CURRENT_ACCOUNT:
			accounts.pushBack(new CurrentAccount(iban, ownerId, amount));
			break;
		case SAVINGS_ACCOUNTS:

			std::cout << "Enter interest rate: ";
			interestRate = validDoubleInput();

			accounts.pushBack(new SavingsAccount(iban, ownerId, amount, interestRate));
			break;
		case PRIVILEGE_ACCOUNT:

			std::cout << "Enter overdraft: ";
			overdraft = validDoubleInput();

			accounts.pushBack(new PrivilegeAccount(iban, ownerId, amount, overdraft));
			break;
		default:
			throw std::exception("The type doesn't match the available ones.");
			break;
		}
	}
	else
	{
		throw std::exception("Account could not be added becouse there is no owner with this id or the IBAN is already taken.");
	}
}

void Bank::deleteAccount(const String& iban)
{
	int index = findAccount(iban);

	if (index != NO_MATCH_FOUND)
	{
		accounts.erase(index);
	}
	else
		throw std::exception("There is no account with this IBAN.");

}

void Bank::listAccounts() const
{
	for (int i = 0; i < accounts.getSize(); i++)
	{
		accounts[i]->display();
	}
}

void Bank::listCustomerAccount(int ownerId) const
{
	if (!customerExist(ownerId))
	{
		throw std::exception("No customer with this id.");
	}

	Vector<Account*> result = accountsOwnedByCustomer(ownerId);

	for (int i = 0; i < result.getSize(); i++)
	{
		result[i]->display();
	}
}

void Bank::transfer(const String& sender, const String& receiver, double amount)
{
	int senderIndex = findAccount(sender);
	int receiverIndex = findAccount(receiver);

	if (senderIndex == NO_MATCH_FOUND || receiverIndex == NO_MATCH_FOUND)
	{
		throw std::exception("One or both of the accounts could not be found.");
	}

	if (accounts[senderIndex]->withdraw(amount))
	{
		accounts[receiverIndex]->deposit(amount);
	}
	else
		throw std::exception("There was not enough money in the account to be transfered.");
}

void Bank::withdraw(const String& iban, double amount)
{
	int index = findAccount(iban);

	if (index != NO_MATCH_FOUND)
	{
		if (!accounts[index]->withdraw(amount))
			throw std::exception("Not enough money in the account.");
	}
	else
		throw std::exception("Account not found.");
}

void Bank::deposit(const String& iban, double amount)
{
	int index = findAccount(iban);

	if (index != NO_MATCH_FOUND)
	{
		accounts[index]->deposit(amount);
	}
	else
		throw std::exception("Account not found.");
}

void Bank::display() const
{
	std::cout << "Bank: " << name << std::endl;
	std::cout << "Address: " << address << std::endl;

	for (int i = 0; i < customers.getSize(); i++)
	{
		customers[i].display();
		listCustomerAccount(customers[i].getId());
		std::cout << std::endl;
	}
}

Vector<Account*> Bank::accountsOwnedByCustomer(int customerId) const
{
	Vector<Account*> result;

	for (int i = 0; i < accounts.getSize(); i++)
	{
		if (accounts[i]->isAccountWith(customerId))
			result.pushBack(accounts[i]);
	}

	return result;
}

int Bank::findAccount(const String& iban) const
{
	for (int i = 0; i < accounts.getSize(); i++)
	{
		if (accounts[i]->isAccountWith(iban))
			return i;
	}

	return NO_MATCH_FOUND;
}

bool Bank::customerExist(int id) const
{
	for (int i = 0; i < customers.getSize(); i++)
	{
		if (customers[i].getId() == id)
			return true;
	}

	return false;
}