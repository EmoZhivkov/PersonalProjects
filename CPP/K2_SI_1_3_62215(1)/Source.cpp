#include <iostream>
#include "House.h"
using namespace std;

int main() {
	const char * ownerOfFirstHouse = "Gosho";
	const char* ownerOfSecondHouse = "Pencho";

	House * house1 = new House(6, 150, 2, 7, ownerOfFirstHouse);
	House * house2 = new House(8, 220, 3, 10, ownerOfSecondHouse);

	cout << *house1;
	cout << endl;

	cout << *house2;
	cout << endl;

	if (house1->getTotalArea() < house2->getTotalArea())
	{
		cout << "House1 has less area" << endl;
	}

	if (*house1 < *house2)
	{
		cout << "House2 has more rooms" << endl;
	}
	
	return 0;
}