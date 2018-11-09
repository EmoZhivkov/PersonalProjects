//#include <iostream>
//#include <map>
//using namespace std;
//
//int main(){
//    string s;
//    cin >> s;
//
//    bool b = true;
//    map<char, int> count;
//
//    for (int i = 0; i < s.length(); ++i) {
//
//        if (count.count(s[i])) {
//
//            count[s[i]] = count[s[i]] + 1;
//
//        } else  {
//
//            count[s[i]] = 1;
//
//        }
//
//        if (s.length() % 2 == 0) {
//            if (count[s[i]] == (s.length() / 2) + 1) {
//
//                b = false;
//                break;
//
//            }
//        } else {
//            if (count[s[i]] == (s.length() / 2) + 2) {
//
//                b = false;
//                break;
//
//            }
//        }
//    }
//
//    if (b) {
//        cout << "Yes" << endl;
//    } else {
//        cout << "No" << endl;
//    }
//
//    return 0;
//}