#include <iostream>
#include "Pair.h"
#include "Settings.h"
using namespace std;

int main() {
	Settings<int> *pairs = new Settings<int>();
	Pair<int> first("Jorkata", 3);
	Pair<int> second("Ooopa", 2);


	cout << "First Pair: " << endl;
	cout << first.getKey() << endl;
	cout << first.getValue() << endl;

	cout << endl;
	cout << "First Pair after the setValue(): " << endl;

	first.setValue(5);
	cout << first.getKey() << endl;
	cout << first.getValue() << endl;

	cout << endl;
	cout << "First Pair after the operator=: " << endl;

	first = second;
	cout << first.getKey() << endl;
	cout << first.getValue() << endl;

	cout << endl;
	cout << "///////////////////////////////" << endl;
	cout << endl;

	pairs->set("first", 1);
	pairs->set("second", 2);

	return 0;
}