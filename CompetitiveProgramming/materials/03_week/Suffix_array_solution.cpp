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

// This code is based on this compact solution: https://codeforces.com/blog/entry/4025
class SuffixArray{
    vector<int> SA, keys, tmp, lcp;// In this order: The suffix array(result), the key of each index,\
     a temporary array to hold the new sorted identitificators, the vector for the longest common prefix.
    string str;
    int N,step;
    void init(){
        SA.resize(N);
        keys.resize(N);
        tmp.resize(N);
        lcp.resize(N);
        for(int i = 0; i < N; i++)SA[i] = i, keys[i] = str[i]; // The initial keys are just the characters.
    }
public:
    vector<int>& constructSA(string &s){ // O(N*logN*logN)
        str = s;
        N = sz(str);
        init();
        auto cmp = [this](int i, int j){
                if(keys[i]!=keys[j])return keys[i]<keys[j]; // If the keys are different then compare them
                i+=step;j+=step; // Else get the 2x keys.
                return (i<N&&j<N?keys[i]<keys[j]:i>j); // If the indice leave the array then we return the smaller one(the right-er one)\
                else we return the smaller of the second keys.
            };
        for(step = 1; tmp[N-1]!=N-1; step*=2){ // If the last key is N-1 this means that every key is unique; So no need to continue.
            stable_sort(all(SA),cmp); // Stable_sort increases the complexity to N*logN*logN from N*logN but it is much easier to code.
            for(int i = 0; i < N-1; i++)tmp[i+1] = tmp[i]+cmp(SA[i],SA[i+1]);// If we find a difference we increase the id.
            for(int i = 0; i < N; i++)keys[SA[i]] = tmp[i]; // We give each of the ORIGINAL indice their assigned identificator.
        }
        return SA;
    }
    vector<int> &constructLCP(){
        for (int i = 0, k = 0; i < N; ++i) // Since k will only go up, the complexity is O(N).
            if (keys[i] != N - 1){ // We don't do the last element where lcp is undefined.
                for (int j = SA[keys[i] + 1]; str[i + k] == str[j + k]; ++k);// We continue from the last point.
                lcp[keys[i]] = k;
                k-=(k!=0); // If the indice has changed, then the last change has overjumped and must be remade.
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