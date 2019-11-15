#pragma GCC optimize("O3")
#pragma GCC target("avx2")

#include <bits/stdc++.h>

#define all(x) (x).begin(),(x).end()
#define sz(x) (int)((x).size())

using namespace std;

typedef int_fast64_t ll;
typedef uint_fast64_t ull;
typedef int_fast32_t int32;
typedef vector<int32> vi;
typedef pair<int32,int32> ii;
typedef vector<ii> vii;

template<class T>
ostream& operator<<(ostream& out, vector<T> V){
    for(auto &i:V)out << i << " ";
    return flush(out);
}

typedef vector<vector<ll>> matrix;

const ll mod = 1e9+7;

matrix MPow(matrix M, ll p){ // Fast iterative matrix power
    matrix res{{1,0},
               {0,1}}; // Multiplicative identity of the matrix' vector space
    auto mul = [](matrix M1, matrix M2)->matrix{ // Matrix modulo multiplication lambda
        matrix nM = M1;
        nM[0][0] = ((M1[0][0]*M2[0][0])%mod+(M1[0][1]*M2[1][0])%mod)%mod;
        nM[0][1] = ((M1[0][0]*M2[0][1])%mod+(M1[0][1]*M2[1][1])%mod)%mod;

        nM[1][0] = ((M1[1][0]*M2[0][0])%mod+(M1[1][1]*M2[1][0])%mod)%mod;
        nM[1][1] = ((M1[1][0]*M2[0][1])%mod+(M1[1][1]*M2[1][1])%mod)%mod;
        return nM;
    };
    for(;p;p>>=1){
        // M will always be the starting M^(2^i), where i is the current step starting from 0
        // That way it works a little like addition:
        // lets say we have the number 2 and power 11 -> ans = 2^11 = 2048
        // 2^11 = 2^(1011b) = 1*2^(1000b)*2(0010b)*2(0001b)
        // So if the bit is set we multiply our result res*M
        if(p&1)res = mul(res,M);
        M = mul(M,M);
    }
    return res;
}

int main(){
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    
    ll power;
    cin >> power;

    matrix M={{1,1},
              {1,0}};
    M = MPow(M,power-2);
    cout << (M[0][0]+M[0][1])%mod << endl;
}
