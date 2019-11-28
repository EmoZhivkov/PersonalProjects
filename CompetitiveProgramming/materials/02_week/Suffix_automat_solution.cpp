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

// The length of the string
int N, MOD=1e9+7;

vector<int> getSuffixVector(string str){
    vector<int> suffixArray{0};
    for(int i = 1; i < sz(str); i++){
        if(str[suffixArray.back()]==str[i]) 
            suffixArray.push_back(suffixArray.back()+1);
        else{ 
            if(suffixArray.back()==0)suffixArray.push_back(0);
            else{
                int j = sz(suffixArray)-2;
                while(j>=0 && str[suffixArray[j]]!=str[i])j--;
                if(j<0)suffixArray.push_back(0);
                else suffixArray.push_back(suffixArray[j]+1);
            }
        }
    }
    return suffixArray;
}

// The state we will be after we give it the i_th letter from the alphabet('a'-'z')
int states[10001][26];
void constructStates(const string &str){
    N = sz(str);
    auto sf = getSuffixVector(str);
    for(int i = 0; i < N; i++){
        for(int c=0; c<26; c++){
            if(i==0)
                states[0][c] = (str[0]==c+'a');
            else if(c+'a'==str[i]) states[i][c]=i+1;
            else states[i][c] = states[sf[i-1]][c];
        }
    }
}

// Returns which will be the state after we give it str[i]
int dpJump[10001][26];
int stateJump(int state, int i){
    if(!i) return states[state][0];
    if(dpJump[state][i]!=-1)return dpJump[state][i];
    return dpJump[state][i]=stateJump(states[stateJump(state,i-1)][i],i-1);
}

// Returns number of appearances of the string in the str[i] -> the answer will be getAppearances(0,n)
int dpGet[10001][26];
int getAppearances(int state, int i){
    if(!i) return states[state][0] == N;
    if(dpGet[state][i]!=-1)return dpGet[state][i];
    dpGet[state][i] = getAppearances(state,i-1);
    (dpGet[state][i] += states[stateJump(state,i-1)][i] == N)%=MOD;
    (dpGet[state][i] += getAppearances(states[stateJump(state,i-1)][i],i-1))%=MOD;
    return dpGet[state][i];
}

int main(){
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    string str;
    int i;
    cin >> str >> i;
    memset(dpJump,-1,sizeof dpJump);
    memset(dpGet,-1,sizeof dpGet);
    constructStates(str);
    cout << getAppearances(0,i) << endl;
}