#include "stdafx.h"
#include <iostream>
using namespace std;

void CreateAndSortArray()
{

	int a;
	cin >> a;

	int *arr = new int[a];
	for (int i = 0; i < a; i++)
	{
		cin >> arr[i];
	}

	int *arrNew = new int[a];

	int helper = INT16_MAX;
	int cnt = 0;
	for(int i = 0; i < a; i++)
	{
		for (int j = 0; j < a; j++)
		{
			if (arr[j] < helper)
			{
				helper = arr[j];
				cnt = j;
			}
		}
		arrNew[i] = helper;
		arr[cnt] = INT16_MAX;
		helper = INT16_MAX;
	}

	for (int i = 0; i < a; i++)
	{
		cout << arrNew[i] << " ";
	}
	cout << endl;
}

int main()
{
	CreateAndSortArray();


	
    return 0;
}

