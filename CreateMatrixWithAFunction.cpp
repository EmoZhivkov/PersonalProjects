#include "stdafx.h"
#include <iostream>
using namespace std;

void CreateMatrix(int m, int n)
{
	cout << endl;
	int **matrix = new int*[m];

	for (int i = 0; i < m; i++)
	{
		matrix[i] = new int[n];
	}

	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> *(*(matrix + i) + j);
		}
	}

	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << *(*(matrix + i) + j) << " ";
		}
		cout << endl;
	}
	cout << endl;

}

int main()
{
	int a, b;
	cin >> a >> b;

	CreateMatrix(a, b);


	
    return 0;
}

