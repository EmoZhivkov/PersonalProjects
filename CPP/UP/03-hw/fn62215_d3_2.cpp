///**
//*
//* Solution to homework assignment 3
//* Introduction to programming course
//* Faculty of Mathematics and Informatics of Sofia University
//* Winter semester 2018/2019
//*
//* @author Emil Zhivkov
//* @idnumber 62215
//* @task 2
//* @compiler GCC
//*
//*/
//
//#include<iostream>
//using namespace std;
//
//void copy(int original[3][3], int newMatrix[3][3]);
//void print(int m[3][3]);
//
//void transpose(int m[3][3]);
//void inverse(int m[3][3], int inversed[3][3]);
//
//void sumWithNumber(int m[3][3], int n);
//
//void multiplyByNumber(int m[3][3], int n);
//void multiplyByMatrix(int first[3][3], int second[3][3], int mult[3][3]);
//
//int determinant(int m[3][3]);
//
//int main() {
//    int A[3][3] = {
//            {-4, 1, 1},
//            {1, -3, 2},
//            {1, 2, -4}
//    };
//
//    int C[3][3] = {
//            {-1, -2, -2},
//            {-1, -3, -4},
//            {-1, -3, -5}
//    };
//
//    int transposedA[3][3];
//    int inversedA[3][3];
//    int mult[3][3];
//    int X[3][3];
//
//    copy(A, transposedA);
//    transpose(transposedA);
//
//    multiplyByNumber(transposedA, -3);
//
//    multiplyByMatrix(transposedA, C, mult);
//
//    sumWithNumber(A, 5);
//
//    inverse(A, inversedA);
//
//    multiplyByMatrix(mult, inversedA, X);
//
//    print(X);
//
//    return 0;
//}
//
//void copy(int original[3][3], int newMatrix[3][3]) {
//    for (int i = 0; i < 3; i++) {
//        for (int j = 0; j < 3; j++) {
//            newMatrix[i][j] = original[i][j];
//        }
//    }
//}
//
//void print(int m[3][3]) {
//    for (int i = 0; i < 3; i++) {
//        for (int j = 0; j < 3; j++) {
//            cout << m[i][j] << " ";
//        }
//        cout << endl;
//    }
//}
//
//void transpose(int m[3][3]) {
//    int transposedMatrix[3][3];
//    for (int i = 0; i < 3; i++) {
//        for (int j = 0; j < 3; j++) {
//            transposedMatrix[j][i] = m[i][j];
//        }
//    }
//
//    for (int i = 0; i < 3; i++) {
//        for (int j = 0; j < 3; j++) {
//            m[i][j] = transposedMatrix[i][j];
//        }
//    }
//}
//
//void inverse(int m[3][3], int inversed[3][3]) {
//    int det = determinant(m);
//    for (int i = 0; i < 3; i++) {
//        for (int j = 0; j < 3; j++) {
//            inversed[i][j] = ((m[(j + 1) % 3][(i + 1) % 3] * m[(j + 2) % 3][(i + 2) % 3]) - (m[(j + 1) % 3][(i + 2) % 3] * m[(j + 2) % 3][(i + 1) % 3])) / det;
//        }
//    }
//}
//
//void sumWithNumber(int m[3][3], int n) {
//    for (int i = 0; i < 3; i++) {
//        m[i][i] = m[i][i] + n;
//    }
//}
//
//void multiplyByNumber(int m[3][3], int n) {
//    for (int i = 0; i < 3; i++) {
//        for (int j = 0; j < 3; j++) {
//            m[i][j] = m[i][j]*n;
//        }
//    }
//}
//
//void multiplyByMatrix(int first[3][3], int second[3][3], int mult[3][3]) {
//    for (int i = 0; i < 3; i++) {
//        for (int j = 0; j < 3; j++) {
//            mult[i][j] = 0;
//        }
//    }
//    for (int i = 0; i < 3; ++i) {
//        for (int j = 0; j < 3; ++j) {
//            for (int k = 0; k < 3; ++k)
//            {
//                mult[i][j] += first[i][k] * second[k][j];
//            }
//        }
//    }
//}
//
//int determinant(int m[3][3]) {
//    int determinant = 0;
//    for (int i = 0; i < 3; i++) {
//        determinant = determinant + (m[0][i] * (m[1][(i + 1) % 3] * m[2][(i + 2) % 3] - m[1][(i + 2) % 3] * m[2][(i + 1) % 3]));
//    }
//    return determinant;
//}
//
