#include "stdafx.h"
#include <iostream>
using namespace std;

//Да се напише програма, която прочита от клавиатурата цяло неотрицателно число n≤100 
//и след това въвежда масив от n цели числа.Програмата да извежда текста “yes”,
//ако въведените числа образуват редица „трион“ и “no” — в противен случай.
//Редица „трион“ наричаме последователност, за която е вярно, 
//че a1 < a2 > a3 < a4 … или a1 > a2 < a3 > a4 … На екрана да не се извежда нищо друго освен текста “yes” или “no”.

//Вход 	        Изход

//6
//5 2 4 2 10 8 	Yes

//5
//1 3 2 7 6 	Yes

//4
//1 2 3 2 	    No



int main()
{
	int n;
	cin >> n;
	cout << endl;
	int *arr = new int[n];
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	bool h = true;

	for (int i = 1; i < n; i++)
	{
		if (arr[1] > arr[0])
		{
			if (i % 2 == 0)
			{
				if (arr[i] < arr[i - 1])
				{

				}
				else
				{
					h = false;
					break;
				}
			}
			else
			{
				if (arr[i] > arr[i - 1])
				{

				}
				else
				{
					h = false;
					break;
				}
			}
		}
		else if(arr[1] < arr[0])
		{
			if (i % 2 == 0)
			{
				if (arr[i] > arr[i - 1])
				{

				}
				else
				{
					h = false;
					break;
				}
			}
			else
			{
				if (arr[i] < arr[i - 1])
				{

				}
				else
				{
					h = false;
					break;
				}
			}
		}
	}

	if (h)
	{
		cout << "yes" << endl;
	}
	else
	{
		cout << "no" << endl;
	}
    return 0;
}

