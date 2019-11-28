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

typedef long double ld;
typedef vector<vector<ld>> matrix;

matrix solve(matrix sys){
    int32 varSize = sz(sys[0])-1;
    int32 rows = sz(sys);
    for(int32 i = 0; i < rows; i++){
        int32 ind = i;
        // Find the index of the row which has the largest element on the current column
        for(int32 j = i+1; j < rows; j++)
            if(fabs(sys[j][i])>fabs(sys[ind][i]))
                ind = j;
        // Swap the row with the current one
        swap(sys[i],sys[ind]);
        ld denominator = sys[i][i];
        // Normalize the row 
        for_each(all(sys[i]),[denominator](ld &n){n/=denominator;});
        // Perform the Gauss-Jordan elimination
        for(int32 j = 0; j < rows; j++){
            if(i == j) continue; // Skip the current row
            ld numerator = sys[j][i];
            for(int32 k = i; k <= varSize; k++)
                sys[j][k]-=sys[i][k]*numerator;
        }
        
    }
    return sys;
}

int main(){
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    
    int32 N, M; // Number of verices; Number of edges
    cin >> N >> M;

    matrix adj(N,vector<ld>(N)); // Adj. Matrix 
    matrix sys(N,vector<ld>(N+1)); // Matrix with N rows and N+1 columns

    for(int32 i = 0; i < M; i++){
        int32 A, B, prob;
        cin >> A >> B >> prob;
        adj[A-1][B-1]=adj[B-1][A-1]=prob;
    }
    int32 start,finish;
    cin >> start >> finish;

    /*
        We represent the expected path length from s to v_i with g(i);
        We represent the probability that the edge i->j is chosen with p(i,j); If edge i->j doesn't exist than p(i,j) = 0
        g(s) = 0, because we start on it.
        For the general formula we have: 
        g(i) = p(i,1)*g(0) + p(i,2)*g(1) + ... + p(i,i-1)*g(i-1) + p(i,i+1)*g(i+1) + ... + p(i,N)*g(N) + 1
        The 1 at the end is added because we have to travel one edge from the previous vertex to get to node i.
        After some linear transformations we get this:
        |0*g(0) + 0*g(1) + ... + 0*g(s-1) + 1*g(s) + 0*g(s+1) ... + 0*g(N) = 0
        |.
        |.
        |.
        |- p(i,1)*g(0) - p(i,2)*g(1) - ... - p(i,i-1)*g(i-1) + 1*g(i) - p(i,i+1)*g(i+1) - ... - p(i,N)*g(N) = 1
        |.
        |.
        |.
        |- p(N,1)*g(0) - p(N,2)*g(1) - ... - p(N,N-1)*g(N-1) + 1*g(N) = 1
        Since we know each p(i,j), we can solve this linear system with Gauss-Jordan.
    */

    for(int32 i = 0; i < N; i++){
        sys[i].back() = sys[i][i] = 1;
        if(i==start-1){
            sys[i].back()=0;
            continue;
        } 
        ld sum = accumulate(all(adj[i]),0);
        for(int32 j = 0; j < N; j++)if(j!=i)sys[i][j] = -adj[i][j]/sum;
    }
    sys = solve(sys);
    cout << sys[finish-1].back() << endl;
}
