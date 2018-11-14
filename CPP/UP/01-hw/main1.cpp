///**
//*
//* Solution to homework task 1
//* Introduction to programming course
//* Faculty of Mathematics and Informatics of Sofia University
//* Winter semester 2018/2019
//*
//* @author Emil Zhivkov
//* @idnumber 62215
//* @task 1
//* @compiler GCC
//*
//*/
//
//#include <iostream>
//using namespace std;
//
//int main() {
//    int num;
//    cin >> num;
//
//    int min = num;
//    int max = num;
//
//    int cnt = 1;
//
//    while (true) {
//        cin >> num;
//
//        if (num < 0) {
//            if (cnt < 2) {
//                cout << "Not enough numbers" << endl;
//                return 0;
//            }
//            break;
//        }
//
//        cnt++;
//
//        if (num > max) {
//            max = num;
//        } else if (num < min) {
//            min = num;
//        }
//    }
//
//    cout << max - min << endl;
//    return 0;
//}