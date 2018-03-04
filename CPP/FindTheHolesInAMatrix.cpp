#include "stdafx.h"
#include <iostream>
using namespace std;

//Нека е дадена правоъгълна матрица(a)MxN с елементи цели числа от тип int,
//където 1 ≤ M, N ≤ 100. Елемента ai, j наричаме “дупка”,
//ако стойността му е по - малка от стойностите на всички негови съседи в матрицата,
//като “съсед” е елемент, стоящ непосредствено до ai, j,
//включително и по диагонал(един елемент може да има до 8 съседа).
//Да се напише програма, която:
//Въвежда от стандартния вход числата M и N, последвани от MxN числа от тип int,
//преставляващи последователните елементи на матрицата(a)MxN по редове.Всички числа от входа са разделени с интервали,
//нови редове или табулации.Извежда на екрана единствено цяло число(без нов ред), 
//представляващо броя на всички дупки в матрицата(a)MxN.
//Решението на задачата трябва да е разделено по подходящ начин в няколко функции.

//Вход 	   Изход 

//3 4      3

//0 1 0 5
//3 5 4 3
//4 2 6 7 	


int** CreateMatrix(int m, int n)
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
	cout << endl;
	return matrix;
}

int main()
{
	int m, n;
	cin >> m >> n;

	int **matrix = CreateMatrix(m, n);
	int cnt = 0;
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (i == 0)
			{
				if (j == 0)
				{
					if (*(*(matrix + i) + j) < *(*(matrix + i) + j + 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j + 1))
					{
						cnt++;
					}
				}
				else if (j == n - 1)
				{
					if (*(*(matrix + i) + j) < *(*(matrix + i) + j - 1) && 
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j))
					{
						cnt++;
					}
				}
				else if (j > 0 && j < n - 1)
				{
					if (*(*(matrix + i) + j) < *(*(matrix + i) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i) + j + 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j + 1))
					{
						cnt++;
					}
				}
			}
			else if (i == m - 1)
			{
				if (j == 0)
				{
					if (*(*(matrix + i) + j) < *(*(matrix + i - 1) + j) &&
						*(*(matrix + i) + j) < *(*(matrix + i - 1) + j + 1) && 
						*(*(matrix + i) + j) < *(*(matrix + i) + j + 1))
					{
						cnt++;
					}
				}
				else if (j == n - 1)
				{
					if (*(*(matrix + i) + j) < *(*(matrix + i - 1) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i - 1) + j) &&
						*(*(matrix + i) + j) < *(*(matrix + i) + j - 1))
					{
						cnt++;
					}
				}
				else if (j > 0 && j < n - 1)
				{
					if (*(*(matrix + i) + j) < *(*(matrix + i - 1) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i - 1) + j) &&
						*(*(matrix + i) + j) < *(*(matrix + i - 1) + j + 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i) + j + 1))
					{
						cnt++;
					}
				}
			}
			else if (i > 0 && i < m - 1)
			{
				if (j == 0)
				{
					if (*(*(matrix + i) + j) < *(*(matrix + i - 1) + j) &&
						*(*(matrix + i) + j) < *(*(matrix + i - 1) + j + 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i) + j + 1) && 
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j + 1))
					{
						cnt++;
					}
				}
				else if (j == n - 1)
				{
					if (*(*(matrix + i) + j) < *(*(matrix + i - 1) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i - 1) + j) && 
						*(*(matrix + i) + j) < *(*(matrix + i) + j - 1) && 
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j))
					{
						cnt++;
					}
				}
				else if (j > 0 && j < n - 1)
				{
					if (*(*(matrix + i) + j) < *(*(matrix + i - 1) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i - 1) + j) &&
						*(*(matrix + i) + j) < *(*(matrix + i - 1) + j + 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i) + j + 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j - 1) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j) &&
						*(*(matrix + i) + j) < *(*(matrix + i + 1) + j + 1))
					{
						cnt++;
					}
				}
			}
		}
	}
	cout << cnt << endl;
    return 0;
}


   
