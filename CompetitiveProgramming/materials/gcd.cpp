#include <bits/stdc++.h>
using namespace std;
#define null NULL
#define mp make_pair
#define pb(a) push_back(a)
#define sz(a) ((int)(a).size())
#define all(a) a.begin() , a.end()
#define fi first
#define se second
#define relaxMin(a , b) (a) = min((a),(b))
#define relaxMax(a , b) (a) = max((a),(b))
#define SQR(a) ((a)*(a))
typedef vector<int> vi;
typedef pair<int,int> pii;
typedef long long ll;

// a * x + b * y = Gcd(a, b)
int Gcd(int a, int b, int& x, int& y){
  if(b == 0) return x = 1, y = 0, a;
  int gcd = Gcd(b, a % b, x, y);
  x -= a / b * y;
  swap(x, y);
  return gcd;
}

int main() {
  int a = 89, b = 144;
  int x, y;
  cout << Gcd(a, b, x, y) << endl;
  cout << x << ' ' << y << endl;
  return 0;
}
