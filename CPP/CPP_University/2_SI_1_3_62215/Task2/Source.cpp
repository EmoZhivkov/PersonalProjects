#include <iostream>
#include "Pair.h"
#include "Settings.h"
using namespace std;

int main() {
	Settings<int> pairs;
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

	int one = 1;
	cout << pairs.get("first", one) << endl;
	cout << endl;
	cout << pairs.count() << endl;
	cout << endl;

	cout << "Setting up four pairs" << endl;

	pairs.set("second", 2);
	pairs.set("third", 3);
	pairs.set("fourth", 4);
	pairs.set("fifth", 5);

	cout << "////////////////////" << endl;

	cout << "Printing count" << endl;
	cout << pairs.count() << endl;
	cout << endl;
	cout << "Testing once more the set command" << endl;
	pairs.set("oopa", 3);



	return 0;
}