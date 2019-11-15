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

typedef long double dbl;

vector<dbl> SolveSystem(vector<vector<dbl>> sys){
  int n = sz(sys);

  for(int i = 0;i < n;++i){
    for(int j = i + 1;j < n;++j)
      if(abs(sys[i][i]) < abs(sys[j][i]))
        sys[i].swap(sys[j]);
    for(int j = i + 1;j < n;++j){
      dbl koef = sys[j][i] / sys[i][i];
      for(int k = i;k <= n;++k)
        sys[j][k] -= sys[i][k] * koef;
    }
  }

  vector<dbl> res(n, 0);
  for(int j = n - 1;j >= 0;--j){
    res[j] = sys[j].back();
    for(int i = j + 1;i < n;++i)
      res[j] -= sys[j][i] * res[i];
    res[j] /= sys[j][j];
  }

  return res;
}

void Solve(){
  int n, s, f;
  scanf("%d%d%d", &n, &s, &f);
  --s, --f;

  vector<vector<pii>> fo(n);
  for(int i = 1;i < n;++i){
    int x, y, p;
    scanf("%d%d%d", &x, &y, &p);
    --x, --y;
    fo[x].pb(mp(y, p));
    fo[y].pb(mp(x, p));
  }

  vector<vector<dbl>> sys(n, vector<dbl>(n + 1, 0));
  for(int i = 0;i < n;++i){
    int tot = 0;
    for(const auto& e : fo[i])
      tot += e.se;
    sys[i][i] = 1;
    sys[i][n] = 1;
    for(const auto& e : fo[i])
      sys[i][e.fi] -= ((double) e.se) / tot;
  }

  fill(all(sys[f]), 0);
  sys[f][f] = 1;

  double ans = SolveSystem(sys)[s];
  printf("%.5f\n", ans);
}

int main(){
  int q;
  scanf("%d", &q);
  while(q-- > 0) Solve();
  return 0;
}
