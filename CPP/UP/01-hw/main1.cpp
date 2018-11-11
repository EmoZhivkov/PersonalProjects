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