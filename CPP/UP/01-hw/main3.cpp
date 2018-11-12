/**
*
* Solution to homework task 3
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

int main() {
    short first;
    short second;
    short op;
    cin >> first >> second >> op;

    if (first < 0 || first > 15) {
        cout << "Wrong input" << endl;
        return 0;
    } else if (second < 0 || second > 15) {
        cout << "Wrong input" << endl;
        return 0;
    }

    short answer = 0;
    if (op == 0) {
        answer = first + second;

        if (answer > 15) {
            answer -= 16;
        }
    } else if (op == 1) {
        answer = first - second;

        if (answer < 0) {
            answer += 16;
        }
    } else if (op == 2) {
        answer = first * second;

        while (answer > 15) {
            answer -= 16;
        }
    } else if (op == 3) {
        if (second == 0) {
            cout << "Wrong input" << endl;
            return 0;
        }

        answer = first / second;
    }

    cout << answer << endl;
    return 0;
}