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

vector<int> getSuffixVector(string needle, string haystack){
    needle = needle+'$'+haystack;
    vector<int> suffixArray{0};
    for(int i = 1; i < sz(needle); i++){
        if(needle[suffixArray.back()]==needle[i]) // The current suffix + curr char is also a prefix
            suffixArray.push_back(suffixArray.back()+1);
        else{ // The current char + suffix is not a prefix;
            if(suffixArray.back()==0)suffixArray.push_back(0); // The current suffix is 0 so this one is also 0
            else{
                int j = sz(suffixArray)-2; // we already checked for the current so we go to the previous best suffix
                while(j>=0 && needle[suffixArray[j]]!=needle[i])
                // do while j is non-negative and the letter after the current suffix is equal to the letter we are processing.
                    j--;
                if(j<0)suffixArray.push_back(0); // We didn't find a proper suffix so 0
                else suffixArray.push_back(suffixArray[j]+1); // We found a proper suffix so increase by one
            }
        }
    }
    return suffixArray;
}

int main(){
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    string needle = "aba";
    string haystack = "ababacabadaba";
    cout << needle+'$'+haystack << endl;
    cout << getSuffixVector(needle,haystack) << endl;
}