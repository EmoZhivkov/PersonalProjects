//#include <iostream>
//#include <cstdlib>
//#include <iomanip>
//using namespace std;
//
//void printmatrix(int rows, int cols, float** A);
//
//// function to reduce matrix to r.e.f.  Returns a value to
//// indicate whether matrix is singular or not
//int forwardElim(int rows, int cols, float **mat);
//
//// function to calculate the values of the unknowns
//void backSub(int rows, int cols, float **mat);
//
//// function to get matrix content
//void gaussianElimination(int rows, int cols, float **mat)
//{
//    /* get solution to system and print it using
//       backward substitution */
//    backSub(rows, cols, mat);
//}
//
//// function for elemntary operation of swapping two rows
//void swap_row(int rows, int cols, float **mat, int i, int j)
//{
//    //printf("Swapped rows %d and %d\n", i, j);
//
//    for (int k=0; k<=rows; k++)
//    {
//        float temp = mat[i][k];
//        mat[i][k] = mat[j][k];
//        mat[j][k] = temp;
//    }
//}
//
//// function to calculate the values of the unknowns
//void backSub(int rows, int cols, float **mat)
//{
//    float *x = new float[rows];  // An array to store solution
//
//    /* Start calculating from last equation up to the
//       first */
//    for (int i = rows-1; i >= 0; i--)
//    {
//        /* start with the RHS of the equation */
//        x[i] = mat[i][rows];
//
//        /* Initialize j to i+1 since matrix is upper
//           triangular*/
//        for (int j=i+1; j<rows; j++)
//        {
//            /* subtract all the lhs values
//             * except the coefficient of the variable
//             * whose value is being calculated */
//            x[i] -= mat[i][j]*x[j];
//        }
//
//        /* divide the RHS by the coefficient of the
//           unknown being calculated */
//        x[i] = x[i]/mat[i][i];
//    }
//
//    printf("\nSolution for the system:\n");
//    for (int i=0; i<rows; i++)
//        printf("%lf\n", x[i]);
//}
//
//float** getBasis (int n, int m, float** A, float** B) {
//    //gaussianElimination(n, n, A);
//    //gaussianElimination(m, n, B);
//
//    float **matrix = new float*[m + n];
//    for (int i = 0; i < m + n; ++i) {
//        matrix[i] = new float[n];
//    }
//
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; ++j) {
//            matrix[i][j] = A[i][j];
//        }
//    }
//
//    for (int i = n; i < n + m; ++i) {
//        for (int j = 0; j < n; ++j) {
//            matrix[i][j] = B[i][j];
//        }
//    }
//
//   // printmatrix(n+m, n, matrix);
//    gaussianElimination(m + n, n, matrix);
//
//    return matrix;
//}
//
//int main()
//{
//    int m = 2;
//    int n = 4;
//
//    float **A = new float*[n];
//    for (int i = 0; i < n; ++i) {
//        A[i] = new float[n];
//    }
//
//    A[0][0] = 2;
//    A[0][1] = 8;
//    A[0][2] = -3;
//    A[0][3] = 14;
//
//    A[1][0] = -1;
//    A[1][1] = 2;
//    A[1][2] = 3;
//    A[1][3] = 5;
//
//    A[2][0] = -1;
//    A[2][1] = 14;
//    A[2][2] = 6;
//    A[2][3] = 29;
//
//    A[3][0] = 0;
//    A[3][1] = 12;
//    A[3][2] = 3;
//    A[3][3] = 24;
//
//    float **B = new float*[m];
//    for (int j = 0; j < m; ++j) {
//        B[j] = new float[n];
//    }
//
//    B[0][0] = 0;
//    B[0][1] = 1;
//    B[0][2] = 1;
//    B[0][3] = 0;
//
//    B[1][0] = 10;
//    B[1][1] = 7;
//    B[1][2] = 0;
//    B[1][3] = -8;
//
//    float **matrix = getBasis(n, m, A, B);
//
//    printmatrix(m+n, n, matrix);
//}
//
//void printmatrix(int rows, int cols, float** A)
//{
//    for (int i=0; i < rows; i++) {
//        for (int j=0; j < cols; j++) {
//            if (A[i][j] == 0) {
//                cout << setw(5) << 0 << " ";
//                continue;
//            }
//
//            cout << setw(5) << A[i][j] << " ";
//        }
//        cout << endl;
//    }
//
//    cout << endl;
//}
//
