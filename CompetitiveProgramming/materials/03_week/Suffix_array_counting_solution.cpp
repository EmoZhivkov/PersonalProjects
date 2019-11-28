#include <bits/stdc++.h>
#define all(x) (x).begin(),(x).end()
#define sz(x) int((x).size())
#define mp make_pair

using namespace std;

typedef long long ll;
typedef pair<int,int> ii;
typedef vector<ii> vii;

template<class T, class U>
ostream& operator<<(ostream& out, pair<T,U> &P){
    out << "[" << P.first << ", " << P.second << "]";
    return out;
}

template<class T>
ostream& operator<<(ostream& out, vector<T> &V){
    cout << '[';
    for(int i(0); i < sz(V); i++)out << V[i] << (i+1==sz(V)?"]":", ");
    return out;
}

class SuffixArray{
    vector<int> keys, tmp, SAtemp;
    string str;
    int N,step;
    void init(){
        SA.resize(N);
        SAtemp.resize(N);
        keys.resize(N);
        tmp.resize(max(N,128));
        lcp.resize(N);
        for(int i = 0; i < N; i++)SA[i] = i, keys[i] = str[i];
    }
    bool cmp(int i, int j){
        if(keys[i]!=keys[j])return keys[i]<keys[j];
        i+=step;j+=step;
        return (i<N&&j<N?keys[i]<keys[j]:i>j);
    }
    void count_sort(int k){
        fill(all(tmp),0);
        for(int i = 0; i < N; i++)tmp[SA[i]+k<N?keys[SA[i]+k]:0]++; // Count elements
        for(int i = 1; i < sz(tmp); i++)tmp[i]+=tmp[i-1]; // Add up to ending position of current key
        for(int i = N-1; i >= 0; i--)SAtemp[--tmp[SA[i]+k<N?keys[SA[i]+k]:0]] = SA[i]; // Sort
        SA = SAtemp;
    }
    void setKeys(){
        for(int i = tmp[0] = 0; i+1 < N; i++)tmp[i+1] = tmp[i] + cmp(SA[i],SA[i+1]);
        for(int i = 0; i < N; i++)keys[SA[i]] = tmp[i]; 
    }
public:
    vector<int> lcp,SA;
    vector<int>& constructSA(string &s){ // O(N*logN)
        str = s;
        N = sz(str);
        init();
        count_sort(0);
        setKeys();
        for(step = 1; tmp[N-1]!=N-1 && step<N; step*=2){ 
            count_sort(step); // O(N)
            count_sort(0);    // O(N)
            setKeys();
        }
        return SA;
    }
    vector<int> &constructLCP(){
        for (int i = 0, k = 0; i < N; ++i) if (keys[i] != N - 1){ 
            for (int j = SA[keys[i] + 1]; str[i + k] == str[j + k]; ++k);
            lcp[keys[i]] = k;
            k-=(k!=0);
        }
        return lcp;
    }
};

int main(){
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    string str;
    cin >> str;  
    SuffixArray SA;
    cout << SA.constructSA(str) << endl;
    cout << SA.constructLCP() << endl;
}