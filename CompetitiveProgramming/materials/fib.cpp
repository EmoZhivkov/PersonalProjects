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

const int MOD = 1E9 + 7;

struct Matrix {
  int a, b,
      c, d;

  Matrix Mult(const Matrix& w) const {
    return Matrix {
      (a * 1LL * w.a + b * 1LL * w.c) % MOD,
      (a * 1LL * w.b + b * 1LL * w.d) % MOD,
      (c * 1LL * w.a + d * 1LL * w.c) % MOD,
      (c * 1LL * w.b + d * 1LL * w.d) % MOD,
    };
  }
};

Matrix Pow(Matrix w, ll degree){
  Matrix res{1, 0, 0, 1};
  for(; degree > 0; degree >>= 1, w = w.Mult(w))
    if(degree & 1)
      res = res.Mult(w);
  return res;
}

// 0, 1, 1, 2, 3, 5, 8, ...
int Fib(ll index){
  if(index == 0) return 0;
  Matrix mult = Pow(Matrix{1, 1, 1, 0}, index - 1);
  return mult.a;
}

int main() {
  cout << Fib(75) << endl;  // = 2111485077978050 % MOD
  return 0;
}
