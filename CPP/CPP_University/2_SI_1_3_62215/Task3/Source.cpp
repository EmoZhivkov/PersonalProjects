#include<iostream>
#include "Vehicle.h"
#include "Car.h"
#include "Truck.h"
#include "Motorcycle.h"

int main()
{
	Vehicle *car = new Car("Toyota", "Corolla", "white", 205, 125000);
	Vehicle *truck = new Truck("MAN", "TIR", "black", 2010, 300000, 10);
	Vehicle *motorcycle = new Motorcycle("Yamaha", "CBR", "blue", 2018, 1000, "chopper");

	car->details();
	cout << endl;

	truck->details();
	cout << endl;

	motorcycle->details();
	cout << endl;
	return 0;
}