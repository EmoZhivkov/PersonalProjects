#include <iostream>
#include <cstdlib>
#include <iomanip>
using namespace std;

void printmatrix(int rows, int cols, float **A) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (A[i][j] == 0) {
                cout << setw(5) << 0 << " ";
                continue;
            }

            cout << setw(7) << A[i][j] << " ";
        }
        cout << endl;
    }

    cout << endl;
}

void RowReduce(int rows, int cols, float **A) {

    int lead = 0;

    while (lead < rows) {
        float d, m;

        for (int r = 0; r < rows; r++) {
            d = A[lead][lead];
            m = A[r][lead] / A[lead][lead];

            for (int c = 0; c < cols; c++) {
                if (r == lead)
                    A[r][c] /= d;
                else
                    A[r][c] -= A[lead][c] * m;
            }
        }

        lead++;
    }
}


void getBasis(int n, int m, float **A, float **B, float **matrix) {
    //gaussianElimination(n, n, A);
    RowReduce(m, n, B);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; ++j) {
            matrix[i][j] = A[i][j];
        }
    }

    for (int i = n; i < n + m; ++i) {
        for (int j = 0; j < n; ++j) {
            matrix[i][j] = B[i][j];
        }
    }

    RowReduce(m + n, n, matrix);
}

int main() {
    int m = 2;
    int n = 4;

    float **A = new float *[n];
    for (int i = 0; i < n; ++i) {
        A[i] = new float[n];
    }

    A[0][0] = 2;
    A[0][1] = 8;
    A[0][2] = -3;
    A[0][3] = 14;

    A[1][0] = -1;
    A[1][1] = 2;
    A[1][2] = 3;
    A[1][3] = 5;

    A[2][0] = -1;
    A[2][1] = 14;
    A[2][2] = 6;
    A[2][3] = 29;

    A[3][0] = 0;
    A[3][1] = 12;
    A[3][2] = 3;
    A[3][3] = 24;

    float **B = new float *[m];
    for (int j = 0; j < m; ++j) {
        B[j] = new float[n];
    }

    B[0][0] = 0;
    B[0][1] = 1;
    B[0][2] = 1;
    B[0][3] = 0;

    B[1][0] = 10;
    B[1][1] = 7;
    B[1][2] = 0;
    B[1][3] = -8;

    float **matrix = new float *[m + n];
    for (int i = 0; i < m + n; ++i) {
        matrix[i] = new float[n];
    }

    getBasis(n, m, A, B, matrix);

    printmatrix(m + n, n, matrix);
}


