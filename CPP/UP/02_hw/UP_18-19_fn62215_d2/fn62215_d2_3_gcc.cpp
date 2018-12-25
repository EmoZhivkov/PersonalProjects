/**
*
* Solution to homework assignment 2
* Introduction to programming course
* Faculty of Mathematics and Informatics of Sofia University
* Winter semester 2018/2019
*
* @author Emil Zhivkov
* @idnumber 62215
* @task 3
* @compiler GCC
*
*/


#include <iostream>
using namespace std;

int getNumOfDigits(int num){
    int cnt = 0;

    while (num != 0) {
        num /= 10;
        cnt++;
    }

    return cnt;
}

int* getArrFromNum(int num) {
    int size = getNumOfDigits(num);
    int *arr = new int[size];

    for (int i = size - 1; i >= 0; i--) {
        arr[i] = num % 10;
        num /= 10;
    }

    return arr;
}

bool checkIfMatrixIsPrime(int matrix[6][6]) {
    bool flag = true;
    for (int i = 0; i < 6; ++i) {
        for (int j = 0; j < 6; ++j) {
            if (matrix[i][j] < 0 || matrix[i][j] > 9) {
                flag = false;
                break;
            }
        }

        if (!flag) {
            break;
        }
    }

    return flag;
}

int checkOccurencies(int matrix[6][6], int num) {
    if (!checkIfMatrixIsPrime(matrix)) {
        return 0;
    }

    int cnt = 0;
    int sizeOfNum = getNumOfDigits(num);
    int *numArr = getArrFromNum(num);

    for (int i = 0; i < 6; ++i) {
        for (int j = 0; j < 6; ++j) {

            int cntOfDigits = 0;
            int helper = j;
            for (int k = 0; k < sizeOfNum; ++k) {
                if (numArr[k] == matrix[i][helper]) {
                    cntOfDigits++;
                }
                helper++;
            }

            if (cntOfDigits == sizeOfNum) {
                cnt++;
            }
        }
    }

    for (int i = 0; i < 6; ++i) {
        for (int j = 0; j < 6; ++j) {

            int cntOfDigits = 0;
            int helper = j;
            for (int k = 0; k < sizeOfNum; ++k) {
                if (numArr[k] == matrix[helper][i]) {
                    cntOfDigits++;
                }
                helper++;
            }

            if (cntOfDigits == sizeOfNum) {
                cnt++;
            }
        }
    }


    for (int i = 5; i >= 0; i--) {
        for (int j = 5; j >= 0; j--) {

            int cntOfDigits = 0;
            int helper = j;
            for (int k = 0; k < sizeOfNum; ++k) {
                if (numArr[k] == matrix[i][helper]) {
                    cntOfDigits++;
                }
                helper--;
            }

            if (cntOfDigits == sizeOfNum) {
                cnt++;
            }
        }
    }

    for (int i = 5; i >= 0; i--) {
        for (int j = 5; j >= 0; j--) {

            int cntOfDigits = 0;
            int helper = j;
            for (int k = 0; k < sizeOfNum; ++k) {
                if (numArr[k] == matrix[helper][i]) {
                    cntOfDigits++;
                }
                helper--;
            }

            if (cntOfDigits == sizeOfNum) {
                cnt++;
            }
        }
    }
    return cnt;
}

int main() {
    int matrix[6][6] = {
            {5, 4, 3, 8, 0, 6},
            {9, 4, 5, 1, 0, 2},
            {8, 5, 8, 0, 6, 1},
            {0, 9, 6, 8, 4, 2},
            {6, 1, 0, 2, 6, 1},
            {2, 1, 8, 4, 2, 6}
    };

    int num;
    cin >> num;

    cout << checkOccurencies(matrix, num) << endl;

    return 0;
}

