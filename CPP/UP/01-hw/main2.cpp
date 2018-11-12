/**
*
* Solution to homework task 2
* Introduction to programming course
* Faculty of Mathematics and Informatics of Sofia University
* Winter semester 2018/2019
*
* @author Emil Zhivkov
* @idnumber 62215
* @task 2
* @compiler GCC
*
*/

#include <iostream>
using namespace std;

int main() {
    long num;
    short digit;

    cin >> num;
    cin >> digit;

    short cnt = 0;
    while (num != 0) {
        short remainder = num % 10;

        if (remainder == digit) {
            cnt++;
        }

        num /= 10;
    }

    cout << cnt << endl;
    return 0;
}