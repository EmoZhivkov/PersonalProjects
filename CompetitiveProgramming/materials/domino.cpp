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

void AddTo(int& to, int w){
  to += w;
  if(to >= MOD) to -= MOD;
}

int Mult(int a, int b){
  return (a * 1LL * b) % MOD;
}

int height;
ll width;

struct Matrix {
  vector<vi> e;

  Matrix(int size){
    e.resize(size, vi(size, 0));
  }

  void One(){
    for(int i = 0;i < sz(e);++i)
      for(int j = 0;j < sz(e);++j)
        e[i][j] = (i == j ? 1 : 0);
  }

  Matrix MatMult(const Matrix& w){
    Matrix res(sz(e));
    for(int i = 0;i < sz(e);++i)
      for(int j = 0;j < sz(e);++j)
        for(int k = 0;k < sz(e);++k)
          AddTo(res.e[i][k], Mult(e[i][j], w.e[j][k]));
    return res;
  }
};

Matrix Pow(Matrix w, ll degree){
  Matrix res(sz(w.e));
  res.One();
  for(;degree > 0;degree >>= 1, w = w.MatMult(w))
    if(degree & 1)
      res = res.MatMult(w);
  return res;
}

bool CanFollow(int mask, int next_mask){
  if(mask & next_mask) return false;
  mask |= next_mask;
  for(int i = 0;i < height;++i)
    if(!(mask & (1 << i))){
      int start = i;
      while(i + 1 < height && !(mask & (1 << (i + 1))))
        ++i;
      if((i - start + 1) & 1) return false;
    }
  return true;
}

int main(){
  cin >> height >> width;
  assert(height < 8);

  Matrix transition(1 << height);
  for(int mask = 0;mask < (1 << height);++mask)
    for(int next_mask = 0;next_mask < (1 << height);++next_mask)
      transition.e[mask][next_mask] = (CanFollow(mask, next_mask) ? 1 : 0);

  cout << Pow(transition, width + 1).e.back()[0] << '\n';

  return 0;
}
