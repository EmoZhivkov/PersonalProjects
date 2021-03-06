/**
*
* Solution to homework task
* Introduction to programming course
* Faculty of Mathematics and Informatics of Sofia University
* Winter semester 2017/2018
*
* @author Emil Zhivkov
* @idnumber 62215
* @task 2
* @compiler VC
*
*/

#include "stdafx.h"
#include <iostream>
#include <algorithm>
using namespace std;


int fromMax;
int toMax;
int num;

int from;
int to;
int cnt = 1;
//the maximum ammount that can be poured
int temp;
//We have to cases, in case the first is bigger(function1) and in case that the second is bigger(function2)
void function(int fromMax, int toMax)
{
	//Pour "temp" litres from "from" => "to"
	from = from - temp;
	to = to + temp;
	cnt++;
	if (from == num || to == num)
	{
		cout << cnt << endl;
		return;
	}

	//If first bucket gets empty => fill it
	if (from == 0)
	{
		from = fromMax;
		cnt++;
	}

	//If second bucket gets full => empty it
	if (to == toMax)
	{
		temp = from;
		to = 0;
		
		cnt++;
	}
	return function(from, to);
}

void function1(int fromMax, int toMax)
{
	//Pour "temp" litres from "to" => "from"
	from = from + temp;
	to = to - temp;
	cnt++;
	if (from == num || to == num)
	{
		cout << cnt << endl;
		return;
	}

	//If first bucket gets empty => empty it
	if (from == fromMax)
	{
		from = 0;
		temp = to;
		cnt++;
	}

	//If second bucket gets full => fill it
	if (to == 0)
	{
		temp = from;
		to = toMax;

		cnt++;
	}
	cnt++;
	cnt++;
	return function(from, to);
}


int main()
{
	cin >> fromMax >> toMax;
	cin >> num;

	
	temp = min(fromMax, toMax);

	if (num > fromMax && num > toMax)
	{
		cout << -1 << endl;
	}


	if (fromMax >= toMax)
	{
		from = fromMax;
		to = 0;
		function(fromMax, toMax);
		
	}
	else 
	{
		from = 0;
		to = toMax;
		function1(fromMax, toMax);
		
	}
	
    return 0;
}

