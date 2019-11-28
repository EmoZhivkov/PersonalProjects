#include <bits/stdc++.h>
#define all(x) (x).begin(),(x).end()
#define sz(x) int((x).size())
#define mp make_pair

using namespace std;

typedef long long ll;
typedef pair<int,int> ii;
typedef vector<ii> vii;

template<class T>
ostream& operator<<(ostream& out, vector<T> V){
    for(auto &i:V)out << i << " ";
    return out;
}

inline ll fastPow(ll b, ll p, ll mod) {
    ll res(1);
    for(;p;p>>=1,(b*=b)%=mod)
        if(p&1)(res*=b)%=mod;
    return res;
}

ll BASE = 191;
pair<ll,ll> mod = {1e9+7,1e9+9}; 

vector<pair<ll,ll>> hashV;

void createHashVector(const string &str){
    hashV.resize(sz(str));
    hashV[0]={str[0],str[0]};
    for(int i = 1; i < sz(str); i++){
        auto [p1,p2] = hashV[i-1];
        (p1 += str[i]*fastPow(BASE,i,mod.first))%=mod.first;
        (p2 += str[i]*fastPow(BASE,i,mod.second))%=mod.second;
        hashV[i] = {p1,p2};
    }
}
bool cmp(ii a, ii b){
    if(a>b)swap(a,b);
    if(a.second-a.first != b.second-b.first)return false;
    ll dif = fastPow(BASE,b.first-a.first,mod.first);
    ll hash1 = ((mod.first+hashV[a.second].first-(a.first?hashV[a.first-1].first:0))*dif)%mod.first;
    ll hash2 = (mod.first+hashV[b.second].first-(b.first?hashV[b.first-1].first:0))%mod.first;
    if(hash1!=hash2)return false;
    dif = fastPow(BASE,b.first-a.first,mod.second);
    hash1 = ((mod.second+hashV[a.second].second-(a.first?hashV[a.first-1].second:0))*dif)%mod.second;
    hash2 = (mod.second+hashV[b.second].second-(b.first?hashV[b.first-1].second:0))%mod.second;
    if(hash1!=hash2)return false;
    return true;
}
bool cmp(int a1,int a2, int b1, int b2){return cmp({a1,a2},{b1,b2});}

int main(){
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    string s = "abacabaaba";
    createHashVector(s);

    ii a, b;

    auto showSub = [&s](ii a){ cout << s.substr(a.first,a.second-a.first+1) << endl; };

    while(cin >> a.first >> a.second >> b.first >> b.second){
        if(a.first > a.second)swap(a.first,a.second);
        if(b.first > b.second)swap(b.first,b.second);
        showSub(a);
        showSub(b);
        cout << boolalpha << cmp(a,b) << endl;
    }
}