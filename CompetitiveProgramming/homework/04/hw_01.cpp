// https://www.hackerrank.com/contests/usp2019-week-4/challenges
#include <bits/stdc++.h>
using namespace std;
#define null NULL
#define mp make_pair
#define pb(a) push_back(a)
#define sz(a) ((int)(a).size())
#define all(a) a.begin(), a.end()
#define fi first
#define se second
#define relaxMin(a, b) (a) = min((a), (b))
#define relaxMax(a, b) (a) = max((a), (b))
#define SQR(a) ((a) * (a))
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef long long ll;

namespace SA
{

const int MAXN = 1000010;

int n;
string s;

int Left(int pos, int len)
{
    return pos - len >= 0 ? pos - len : pos - len + n;
}

int Right(int pos, int len)
{
    return pos + len < n ? pos + len : pos + len - n;
}

int sa[MAXN], id[MAXN];

int key[MAXN], val[MAXN];
int count[MAXN];
void StableSort(int *to)
{
    int max_key = *max_element(key, key + n);
    fill(count, count + max_key + 1, 0);
    for (int i = 0; i < n; ++i)
        ++count[key[i]];
    for (int i = 1; i <= max_key; ++i)
        count[i] += count[i - 1];
    for (int i = n - 1; i >= 0; --i)
        to[--count[key[i]]] = val[i];
}

void Group(int len)
{
    copy(id, id + n, val);
    id[sa[0]] = 0;
    for (int i = 1; i < n; ++i)
    {
        id[sa[i]] = id[sa[i - 1]];
        if (val[sa[i]] != val[sa[i - 1]] ||
            val[Right(sa[i], len)] != val[Right(sa[i - 1], len)])
            ++id[sa[i]];
    }
}

vi BuildSA(const string &in)
{
    s = in + '\0';
    n = sz(s);

    for (int i = 0; i < n; ++i)
        id[i] = s[i], key[i] = s[i], val[i] = i;
    StableSort(sa);
    Group(0);

    for (int len = 1; id[sa[n - 1]] < n - 1; len *= 2)
    {
        for (int i = 0; i < n; ++i)
            val[i] = Left(sa[i], len),
            key[i] = id[val[i]];
        StableSort(sa);
        Group(len);
    }

    return vi(sa, sa + n);
}

vi BuildLCP(const string &in, const vi &sa)
{
    vi lcp(sz(in));
    for (int i = 0; i < sz(in); ++i)
        key[sa[i]] = i;
    int len = 0;
    for (int i = 0; i < sz(in); ++i)
    {
        len = max(0, len - 1);
        int me = key[i], next = me + 1;
        if (next >= sz(in))
            len = 0;
        else
        {
            while (in[sa[me] + len] == in[sa[next] + len])
                ++len;
            lcp[me] = len;
        }
    }
    return lcp;
}

} // namespace SA

int main()
{
    string in;
    cin >> in;

    auto sa = SA::BuildSA(in);
    auto lcp = SA::BuildLCP(in + '\0', sa);

    long long sum_sa = 0;
    for (int i = 0; i < sz(sa); i++)
    {
        sum_sa += sa[i];
    }

    long long sum_lcp = 0;
    for (int i = 0; i < sz(lcp); i++)
    {
        sum_lcp += lcp[i];
    }

    long long result = sum_sa - sum_lcp;

    cout << result << endl;

    return 0;
}
