// https://www.hackerrank.com/contests/usp2019-week-3/challenges
#include <bits/stdc++.h>
using namespace std;

 long long mod = 1000000007;


 long long **transpose_matrix( long long **matrix,  long long r,  long long c)
{
     long long **transpose = new  long long *[c];
    for ( long long i = 0; i < c; i++)
    {
        transpose[i] = new  long long[r];
    }

    for ( long long i = 0; i < r; ++i)
        for ( long long j = 0; j < c; ++j)
        {
            transpose[j][i] = matrix[i][j];
        }

    return transpose;
}

 long long multiply_row_by_col( long long *first,  long long *second,  long long len)
{
    long long sum = 0;
    for ( long long i = 0; i < len; i++)
    {
        sum = (sum + first[i] * second[i]) % mod;
    }
    return sum;
}

 long long **multiply_two_matrixes( long long **first,  long long r1,  long long c1,  long long **second,  long long r2,  long long c2)
{
    long long **vector = new  long long *[r1];
    for ( long long i = 0; i < r1; i++)
    {
        vector[i] = new  long long[c2];
    }

    second = transpose_matrix(second, r2, c2);

    for ( long long i = 0; i < r1; i++)
    {
        for ( long long j = 0; j < c2; j++)
        {
            vector[i][j] = multiply_row_by_col(first[i], second[j], r1);
        }
    }

    return vector;
}

 long long **matrix_to_the_power_of( long long **matrix,  long long r,  long long c,  long long degree)
{
    if (degree == 0){
         long long **temp_matrix = new  long long*[r];
        for ( long long i = 0; i < r; i++)
        {
            temp_matrix[i] = new  long long[c];
        }

        for ( long long i = 0; i < r; i++)
        {
            for ( long long j = 0; j < c; j++)
            {
                temp_matrix[i][j] = 0;
            }
        }


        for ( long long i = 0; i < r; i++)
        {
            for ( long long j = 0; j < c; j++)
            {
                if (j == i){
                    temp_matrix[i][j] = 1;
                }
            }
        }

        return temp_matrix;
    }

    if (degree % 2 == 0)
    {
         long long **matrix_temp = matrix_to_the_power_of(matrix, r, c, degree / 2);
        return multiply_two_matrixes(matrix_temp, r, c, matrix_temp, r, c);
    }
    else
    {
        return multiply_two_matrixes(matrix, r, c, matrix_to_the_power_of(matrix, r, c, degree - 1), r, c);
    }
}

int main()
{
     long long **matrix = new  long long *[5];
    matrix[0] = new  long long[5];
    matrix[1] = new  long long[5];
    matrix[2] = new  long long[5];
    matrix[3] = new  long long[5];
    matrix[4] = new  long long[5];


    matrix[0][0] = 4;
    matrix[0][1] = -3;
    matrix[0][2] = 1;
    matrix[0][3] = -1;
    matrix[0][4] = 1;

    matrix[1][0] = 1;
    matrix[1][1] = 0;
    matrix[1][2] = 0;
    matrix[1][3] = 0;
    matrix[1][4] = 0;

    matrix[2][0] = 0;
    matrix[2][1] = 1;
    matrix[2][2] = 0;
    matrix[2][3] = 0;
    matrix[2][4] = 0;

    matrix[3][0] = 0;
    matrix[3][1] = 0;
    matrix[3][2] = 1;
    matrix[3][3] = 0;
    matrix[3][4] = 0;

    matrix[4][0] = 0;
    matrix[4][1] = 0;
    matrix[4][2] = 0;
    matrix[4][3] = 0;
    matrix[4][4] = 1;


     long long **vector = new  long long *[5];
    vector[0] = new  long long[1];
    vector[1] = new  long long[1];
    vector[2] = new  long long[1];
    vector[3] = new  long long[1];
    vector[4] = new  long long[1];

    vector[0][0] = 3;
    vector[1][0] = 0;
    vector[2][0] = 0;
    vector[3][0] = 0;
    vector[4][0] = 1;

     long long num;
    cin >> num;

    if (num == 0){
        cout << 0;
        return 0;
    }
    else if (num == 1)
    {
        cout << 0;
        return 0;
    } else if (num == 2){
        cout << 0;
        return 0;
    }

    matrix = multiply_two_matrixes(matrix_to_the_power_of(matrix, 5, 5, num - 3), 5, 5, vector, 5, 1);
    cout << (matrix[0][0] + mod) % mod  << endl;


    return 0;
}
