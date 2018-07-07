# Vehicles

#include<iostream>
#include "Car.h"
#include "Truck.h"
#include "Motorcycle.h"

using namespace std;

int main() 
{
	Vehicle* vehicles[3];

	vehicles[0] = new Car("BMW", "X6", "white", 2016, 0);
	vehicles[1] = new Truck("MAN", "TGX D38", "red", 2010, 58000, 30);
	vehicles[2] = new Motorcycle("Harley-Davidson", "500", "blue", 2018, 0, "chopper");

	for (int i = 0;i < 3;i++) {
		vehicles[i]->details();
	}
	system("pause");
}
