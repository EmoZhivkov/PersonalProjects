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
#define PI 3.14159265358979323846
typedef vector<int> vi;
typedef pair<int,int> pii;  // max, min
typedef long long ll;

const int ALPHABET = 26;

vi PreffixFunc(const string& s){
  vi pf(sz(s));
  for(int i = 1;i < sz(s);++i){
    int len = pf[i - 1];
    while(len > 0 && s[i] != s[len])
      len = pf[len - 1];
    pf[i] = len + (s[i] == s[len]);
  }
  return pf;
}

vector<vi> Automaton(string s){
  s += '\0';
  vi pf = PreffixFunc(s);
  vector<vi> aut(sz(s), vi(ALPHABET));
  for(int i = 0;i < sz(s);++i)
    for(char c = 'a';c <= 'z';++c){
      if(s[i] == c) aut[i][c - 'a'] = i + 1;
      else {
        if(i) aut[i][c - 'a'] = aut[pf[i - 1]][c - 'a'];
      }
    }
  return aut;
}

vector<vi> aut;

map<pii, int> consume_cache;
int Consume(int state, int str){
  if(str == 0) return aut[state][0];
  if(consume_cache.count({state, str}))
    return consume_cache[{state, str}];
  int s1 = Consume(state, str - 1);
  int s2 = aut[s1][str % ALPHABET];
  int s3 = Consume(s2, str - 1);
  return consume_cache[{state, str}] = s3;
}

map<pii, ll> count_cache;
ll Count(int state, int str){
  if(str == 0) return (Consume(state, 0) == sz(aut) - 1);
  if(count_cache.count({state, str}))
    return count_cache[{state, str}];
  ll c1 = Count(state, str - 1);
  int mid_state = aut[Consume(state, str - 1)][str % ALPHABET];
  ll c2 = (mid_state == sz(aut) - 1);
  ll c3 = Count(mid_state, str - 1);
  return count_cache[{state, str}] = c1 + c2 + c3;
}

int main(){
  string target;
  int idx;
  cin >> target >> idx;

  aut = Automaton(target);
  cout << Count(0, idx) << '\n';

  return 0;
}
