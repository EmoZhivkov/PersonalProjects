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

int32 N, M;
ll dp[200][10][1100];

typedef uint_fast64_t uint32;

ll solve(int32 i, int32 j, uint32 mask, uint32 nextMask){
    if(j>=N){
        i++;
        j=0;
        mask = nextMask;
        nextMask = 0;
    }
    if(i>=M)
        return 1;
    if(mask>>j&1)
        return solve(i,j+1,mask,nextMask);
    uint32 currMask = nextMask&((1<<j)-1); // First j-1 bits from the next row
    currMask |= mask & ~((1<<j)-1);        // [j,32) bits from current row since we know that unused bits are 0
    if(dp[i][j][currMask]+1) // We have already explored this case
        return dp[i][j][currMask];
    dp[i][j][currMask] = 0;
    if(i<M-1)                   // Can place dominos horizontally
        dp[i][j][currMask] += solve(i,j+1,mask,nextMask|(1<<j));
    if(j<N-1 && !(mask&1<<j+1)) // Can place dominos vertically
        dp[i][j][currMask] += solve(i,j+2,mask,nextMask);
    return dp[i][j][currMask];
}

int main(){
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    memset(dp,-1,sizeof dp);
    while(cin >> N >> M && (N>10 || M>200))
        cout << "The maximum solvable with this algorithm is: NxM = 10x200" << endl; 
    cout << solve(0,0,0,0) << endl;
}
