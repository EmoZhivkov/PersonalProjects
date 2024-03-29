/**
*
* Solution to homework task
* Introduction to programming course
* Faculty of Mathematics and Informatics of Sofia University
* Winter semester 2017/2018
*
* @author Emil Zhivkov
* @idnumber 62215
* @task 1
* @compiler VC
*
*/


#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

/*
	I am creating two counters so I can count the number of times the brackets are repeating
	Next I am creating a function that has two parameters - the inputed string and i(the index of the elements of the inputed string)
	I am creating a recursion that goes through the whole string and counts the opening and closing brackets
	If the counters are the same number then the output will be correct
	if not => incorrect
*/

int cntOpen = 0;
int cntClosed = 0;
void function(string input, int i = 0)
{
	if (input[i] == '(')
	{
		cntOpen++;
	}
	if (input[i] == ')')
	{
		cntClosed++;
	}

	if (i == input.size() - 1)
	{
		if (cntOpen == cntClosed)
		{
			cout << "correct" << endl;
			return;
		}
		else
		{
			cout << "incorrect" << endl;
			return;
		}
	}
	return function(input, i + 1);
}


int main()
{
	string input;
	getline(cin, input);

	function(input);

	return 0;
}

