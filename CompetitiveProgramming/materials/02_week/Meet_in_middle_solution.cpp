/*--NO NAMESPACE STD EMPTY TEMPLATE--*/
#include <bits/stdc++.h>
#define all(x) (x).begin(),(x).end()
#define sz(x) int((x).size())
#define mp make_pair

typedef long long ll;
typedef std::pair<int,int> ii;
typedef std::vector<ii> vii;

template<class T>
std::ostream& operator<<(std::ostream& out, std::vector<T> V){
    for(auto &i:V)out << i << " ";
    return out;
}

std::vector<int> base;
std::vector<ii> leftHalf;

int MOD, N;

void printParticipants(ll p){
    for(int i = 0; p; i++, p>>=1)
        if(p&1)std::cout << base[i] << " ";
    std::cout << "\n";
}

int sumParticipants(int t, int offset){
    int sum(0);
    do{
        if(t&1)(sum+=base[offset])%=MOD;
        offset++;
    }while(t>>=1);
    return sum;
}

void solve(){
    int lim = 1<<(N/2), i, answer(0);
    ll participants;
    for(i = 0; i < lim; i++)
        leftHalf.push_back({sumParticipants(i,0),i});
    std::sort(all(leftHalf));
    lim = 1<<(N-N/2);
    for(i = 0; i < lim; i++){
        int sum = sumParticipants(i,N/2);
        if(answer<(sum+leftHalf.back().first)%MOD){
            answer = (sum+leftHalf.back().first)%MOD;
            participants = ll(leftHalf.back().second)|(ll(i)<<N/2);
        }
        auto it = lower_bound(all(leftHalf),std::mp(MOD-1-sum,0));
        if(it->first!=MOD-1-sum)it--;
        if(answer<(it->first+sum)%MOD){
            answer = (it->first+sum)%MOD;
            participants = ll(it->second)|(ll(i)<<N/2);
        }
    }
    printParticipants(participants);
    std::cout << answer << std::endl;
}

int main(){
    std::cin.tie(0);
    std::cout.tie(0);
    std::ios_base::sync_with_stdio(false);
    
    std::cin >> N >> MOD;
    for(int i = 0, a; i < N; i++){
        std::cin >> a;
        base.push_back(a);
    }

    solve();
}