/**
*
* Solution to homework assignment 3
* Introduction to programming course
* Faculty of Mathematics and Informatics of Sofia University
* Winter semester 2018/2019
*
* @author Emil Zhivkov
* @idnumber 62215
* @task 1
* @compiler GCC
*
*/

#include <stdlib.h>
#include <thread>
#include <iostream>
using namespace std;

int main()
{
    char matrix[5][40] = {
            "H   H   EEEEE   L       L          O   ",
            "H   H   E       L       L        O   O ",
            "HHHHH   EEEEE   L       L       O     O",
            "H   H   E       L       L        O   O ",
            "H   H   EEEEE   LLLLL   LLLLL      O   "
    };

    for (int j = 39; j >= 0; j--) {
        for (int k = 0; k < 10; ++k) {
            cout << endl;
        }

        for (int l = j; l < 40; ++l) {
            cout << matrix[0][l];
        }
        cout << endl;

        for (int l = j; l < 40; ++l) {
            cout << matrix[1][l];
        }
        cout << endl;

        for (int l = j; l < 40; ++l) {
            cout << matrix[2][l];
        }
        cout << endl;

        for (int l = j; l < 40; ++l) {
            cout << matrix[3][l];
        }
        cout << endl;

        for (int l = j; l < 40; ++l) {
            cout << matrix[4][l];
        }
        cout << endl;

        std::this_thread::sleep_for(chrono::milliseconds(50));

        system("CLS");
    }

    for (int j = 0; j <= 39; j++) {
        for (int k = 0; k < 10; ++k) {
            cout << endl;
        }

        for (int i = 0; i < j; i++)
        {
            cout << " ";
        }
        for (int l = 0; l < 39 - j; ++l) {

            cout << matrix[0][l];
        }
        cout << endl;

        for (int i = 0; i < j; i++)
        {
            cout << " ";
        }
        for (int l = 0; l < 39 - j; ++l) {

            cout << matrix[1][l];
        }
        cout << endl;

        for (int i = 0; i < j; i++)
        {
            cout << " ";
        }
        for (int l = 0; l < 39 - j; ++l) {

            cout << matrix[2][l];
        }
        cout << endl;

        for (int i = 0; i < j; i++)
        {
            cout << " ";
        }
        for (int l = 0; l < 39 - j; ++l) {

            cout << matrix[3][l];
        }
        cout << endl;

        for (int i = 0; i < j; i++)
        {
            cout << " ";
        }
        for (int l = 0; l < 39 - j; ++l) {

            cout << matrix[4][l];
        }
        cout << endl;

        std::this_thread::sleep_for(chrono::milliseconds(50));

        system("CLS");
    }

    return 0;
}

