#include<iostream>

#include "String.h"
#include "Bank.h"
#include "Menu.h"
#include "HelperFunctions.h"

using namespace std;

int main()
{
	String name, address;

	cout << "Enter bank's name: ";
	std::cin >> name;

	cout << "Enter bank's address: ";
	std::cin >> address;

	Bank bank(name, address);

	Menu menu(bank);

	bool active = true;
	int command;

	menu.printMenu();

	while (active)
	{
		command = validIntegerInput();

		try
		{
			menu.recogniseCommand(command);
		}
		catch (const std::exception& e)
		{
			cout << e.what() << endl;
		}

		system("pause");

		menu.cleanMenu();
		menu.printMenu();
	}
	
	return 0;
}



