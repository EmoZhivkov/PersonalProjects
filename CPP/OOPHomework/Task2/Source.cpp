#include <iostream>
#include "Pair.h"
#include "Settings.h"
using namespace std;

int main() {
	Settings<int> *pairs = new Settings<int>();
	Pair<int> first("Jorkata", 3);
	Pair<int> second("Ooopa", 2);

	cout << first.getKey() << endl;
	cout << first.getValue() << endl;

	first.setValue(5);
	

	cout << first.getKey() << endl;
	cout << first.getValue() << endl;

	first = second;

	cout << first.getKey() << endl;
	cout << first.getValue() << endl;



	return 0;
}