// https://www.hackerrank.com/contests/usp2019-week-3/challenges
#include <bits/stdc++.h>
using namespace std;

map<pair<int, int>, int> temp;

int lps(string s, int i, int j){
    if (temp.count({i, j}) != 0) {
        return temp[{i, j}];
    }

    if (i == j)
    {
        return 1;
   }

   if (s[i] == s[j] && i + 1 == j) {
      return 2;
   }

   if (s[i] == s[j]) {
       int m = lps(s, i + 1, j - 1) + 2;
       temp[{i, j}] = m;

       return m;
   }

   int m = max(lps(s, i, j - 1), lps(s, i + 1, j));
   temp[{i, j}] = m;

   return m;
}

int minDeletion(string s){
   int n = s.size();
   int lpsSize = lps(s, 0, n);
   return (n - lpsSize);
}

int main(){
    string s;
    cin >> s;
    cout << s.length() - minDeletion(s) << endl;
    return 0;
}