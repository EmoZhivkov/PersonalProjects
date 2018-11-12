//#include <iostream>
//
//using namespace std;
//
//int main() {
//    char symbol;
//    cin >> symbol;
//
//    int len;
//    cin >> len;
//
//    if (len > 12) {
//        cout << "The size of the square is too big for the screen" << endl;
//        return 0;
//    }
//
//    int emptyLines = (26 - 2*len)/2;
//
//    for (int k = 0; k < emptyLines; ++k) {
//        for (int j = 0; j < 80; ++j) {
//            cout << " ";
//        }
//        cout << endl;
//    }
//
//    int i;
//    for (i = 0; i < len; i++) {
//        for (int j = 0; j < (80/2) - 2*i - 1; ++j) {
//                cout << " ";
//        }
//
//        if (i == 0) {
//            cout << symbol;
//        } else {
//            cout << symbol;
//            for (int j = 0; j < 2*(2 * i) - 1; ++j) {
//                cout << symbol;
//            }
//            cout << symbol;
//        }
//
//        cout << endl;
//    }
//
//    for (i = len - 2; i >= 0; i--) {
//        for (int j = 0; j < (80/2) - 2*i - 1; ++j) {
//            cout << " ";
//        }
//
//        if (i == 0) {
//            cout << symbol;
//        } else {
//            cout << symbol;
//            for (int j = 0; j < 2*(2 * i) - 1; ++j) {
//                cout << symbol;
//            }
//            cout << symbol;
//        }
//
//        cout << endl;
//    }
//
//    for (int k = 0; k < emptyLines; ++k) {
//        for (int j = 0; j < 80; ++j) {
//            cout << " ";
//        }
//        cout << endl;
//    }
//
//    return 0;
//}