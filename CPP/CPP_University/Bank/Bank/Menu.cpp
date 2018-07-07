#include "Menu.h"

#include<iostream>
#include<exception>

#include "HelperFunctions.h"
#include "String.h"

Menu::Menu(const Bank & bank) : 
	bank(bank)
{
}

void Menu::printMenu() const
{
	std::cout << bank.getName() << " list of available options: " << std::endl;
	std::cout << "1. List customers" << std::endl;
	std::cout << "2. Add new customer" << std::endl;
	std::cout << "3. Delete customer" << std::endl;
	std::cout << "4. List all accounts" << std::endl;
	std::cout << "5. List customer account" << std::endl;
	std::cout << "6. Add new account" << std::endl;
	std::cout << "7. Delete account" << std::endl;
	std::cout << "8. Withdraw from account" << std::endl;
	std::cout << "9. Deposit to account" << std::endl;
	std::cout << "10. Transfer" << std::endl;
	std::cout << "11. Display info for the bank" << std::endl;
	std::cout << "12. Quit" << std::endl;
	std::cout << "Enter a number (from 1 to 12): ";
}

void Menu::cleanMenu() const
{
	system("cls");
}

void Menu::recogniseCommand(int command)
{
	switch (command)
	{
	case 1:
		displayCutomers();
		break;
	case 2:
		addCustomer();
		break;
	case 3:
		deleteCustomer();
		break;
	case 4:
		displayAccounts();
		break;
	case 5:
		displayAccountOfACustomer();
		break;
	case 6:
		addAccount();
		break;
	case 7:
		deleteAccount();
		break;
	case 8:
		withdrawFromAccount();
		break;
	case 9:
		depositToAccount();
		break;
	case 10:
		transfer();
		break;
	case 11:
		displayBankInformation();
		break;
	case 12:
		quit();
		break;
	default:
		throw std::exception("Command not recongnised.");
		break;
	}
}

void Menu::displayBankInformation() const
{
	bank.display();
}

void Menu::quit()
{
	std::exit(EXIT_SUCCESS);
}

AccountType Menu::returnType(int num) const
{
	switch (num)
	{
	case 1:
		return CURRENT_ACCOUNT;
		break;
	case 2:
		return SAVINGS_ACCOUNTS;
		break;
	case 3:
		return PRIVILEGE_ACCOUNT;
		break;
	default:
		throw std::exception("No such account type");
	}
}

void Menu::addCustomer()
{
	std::cout << "Enter customer information:" << std::endl;
	std::cout << "Enter customer id or -1 to exit: ";

	//Inputing the data
	int id = validIntegerInput();

	//Check if it is a return command
	if (id == -1)
		return;

	String name, address;

	std::cout << "Enter customer's name: ";
	std::cin >> name;
	std::cout << "Enter customer's address: ";
	std::cin >> address;

	//Calling the method
	bank.addCustomer(id, name, address);
}

void Menu::deleteCustomer()
{
	std::cout << "Enter customer id ot -1 to return to menu: ";

	int input = validIntegerInput();

	if (input == -1)
	{
		return;
	}
	
	bank.deleteCustomer(input);
}

void Menu::displayCutomers() const
{
	bank.listCustomers();
}

void Menu::addAccount()
{
	std::cout << "Enter Account information:" << std::endl;
	
	int typeNum;
	
	std::cout << "Enter type(1 - Current account, 2 - Savings Account, 3 - Privilege Account, 0 to go back): ";
	typeNum = validIntegerInput();
	

	if (typeNum == 0)
		return;

	AccountType type = returnType(typeNum);

	std::cout << "Enter IBAN: ";
	String iban;
	std::cin >> iban;

	std::cout << "Enter owner's id: ";

	int id = validIntegerInput();

	std::cout << "Enter amount: ";
	double amount = validDoubleInput();

	bank.addAccount(type, iban, id, amount);
}

void Menu::deleteAccount()
{
	std::cout << "Enter IBAN:";
	String iban;
	std::cin >> iban;

	bank.deleteAccount(iban);
}

void Menu::displayAccounts() const
{
	bank.listAccounts();
}

void Menu::displayAccountOfACustomer() const
{
	std::cout << "Enter customer id ot -1 to return to menu: ";

	int input = validIntegerInput();

	if (input == -1)
	{
		return;
	}

	bank.listCustomerAccount(input);
}

void Menu::transfer()
{
	String first, second;

	std::cout << "Enter first accoutn IBAN:";

	std::cin >> first;

	std::cout << "Enter second accoutn IBAN:";

	std::cin >> second;

	std::cout << "Enter amount to be transfared: ";

	double amount = validDoubleInput();

	bank.transfer(first, second, amount);
}

void Menu::withdrawFromAccount()
{
	String iban;
	std::cout << "Enter IBAN:";

	std::cin >> iban;

	std::cout << "Enter amount to be withdrown: ";

	double amount = validDoubleInput();

	bank.withdraw(iban, amount);
}

void Menu::depositToAccount()
{
	String iban;
	std::cout << "Enter IBAN:";

	std::cin >> iban;

	std::cout << "Enter amount to be withdrown: ";

	double amount = validDoubleInput();

	bank.deposit(iban, amount);
}