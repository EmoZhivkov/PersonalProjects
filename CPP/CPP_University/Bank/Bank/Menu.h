#ifndef MENU_H
#define MENU_H

#include "Bank.h"

class Menu
{
private:
	Bank bank;

	void addCustomer();
	void deleteCustomer();
	void displayCutomers() const;

	void addAccount();
	void deleteAccount();
	void displayAccounts() const;

	void displayAccountOfACustomer() const;

	void transfer();
	void withdrawFromAccount();
	void depositToAccount();

	void displayBankInformation() const;

	void quit();

	AccountType returnType(int num) const;
public:
	Menu(const Bank& bank);

	void printMenu() const;
	void cleanMenu() const;
	void recogniseCommand(int command);
};

#endif // !MENU_H
