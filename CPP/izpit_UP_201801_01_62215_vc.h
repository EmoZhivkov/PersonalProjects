/*int* MatrixMull(int**, int**, int m, int n, int p, int q)
{
	int** newMatrix = new int*[];

}*/
#include <iostream>
using namespace std;
double sqrt_a(double a, double eps)
{
	double sqrt = 0.0;
	for (int i = 1; i <= a; i++)
	{
		//Xk = i;
		//Xk + 1 = helper
		
		sqrt = ((double)i + (a /(double)i))/2;
		
		if (sqrt > i)
		{
			double helper = sqrt - i;
			if (helper < eps)
			{
				break;
			}
		}
		if (sqrt < i)
		{
			double helper = i - sqrt;
			if (helper < eps)
			{
				break;
			}
		}
	}
	return sqrt;
}

void Revert(char text[])
{
	for (int i = 0; i < 10000; i++)
	{
		if ((int)text[i] >= 65 && (int)text[i] <= 90)
		{
			text[i] = text[i] + 32;
			cout << text[i];
		}
		else if ((int)text[i] >= 97 && (int)text[i] <= 122)
		{
			text[i] = text[i] - 32;
			cout << text[i];
		}
		if (text[i] == 0)
		{
			break;
		}

	}
	cout << endl;
	
}