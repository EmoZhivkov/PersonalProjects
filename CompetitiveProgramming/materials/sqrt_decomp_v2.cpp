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

const int MAXN = 200010;
const int BLOCK = 500;
const int MAX_BLOCKS = 4000;

int n, m;
int inp[MAXN];

ll Sum(const list<int> &of)
{
    ll sum = 0;
    for (int e : of)
        sum += inp[e];
    return sum;
}

// Blocks
int free_blocks[MAX_BLOCKS], free_idx;
int lo[MAX_BLOCKS], hi[MAX_BLOCKS];
list<int> in[MAX_BLOCKS];
ll sum[MAX_BLOCKS];

int NewBlock()
{
    int idx = free_blocks[--free_idx];
    in[idx].clear();
    return idx;
}

void DeleteBlock(int idx)
{
    free_blocks[free_idx++] = idx;
}

int Len(int idx)
{
    return hi[idx] - lo[idx] + 1;
}

vi Init()
{
    for (int i = 0; i < MAX_BLOCKS; ++i)
        free_blocks[free_idx++] = i;

    vi ds;
    for (int i = 0; i <= n; i += BLOCK)
    {
        int l = i, r = min(n, i + BLOCK - 1);
        int me = NewBlock();
        for (int j = l; j <= r; ++j)
            in[me].pb(j);
        sum[me] = Sum(in[me]);
        lo[me] = l;
        hi[me] = r;
        ds.pb(me);
    }
    return ds;
}

int Index(const vi &ds, int pos)
{
    for (int i = 0; i < sz(ds); ++i)
        if (pos <= hi[ds[i]])
            return i;
    return -1;
}

void Fix(vi &ds)
{
    int last = 1;
    for (int i = 1; i < sz(ds); ++i)
    {
        if (2 * Len(ds[i]) <= BLOCK &&
            2 * Len(ds[last - 1]) <= BLOCK)
        {
            hi[ds[last - 1]] = hi[ds[i]];
            sum[ds[last - 1]] += sum[ds[i]];
            in[ds[last - 1]].splice(in[ds[last - 1]].end(),
                                    in[ds[i]]);
            DeleteBlock(ds[i]);
        }
        else
        {
            ds[last++] = ds[i];
        }
    }
    ds.erase(ds.begin() + last, ds.end());
}

int Split(vi &ds, int pos)
{
    int idx = Index(ds, pos);
    if (lo[ds[idx]] == pos)
        return idx;

    int a = ds[idx];
    int b = NewBlock();
    lo[b] = lo[a];
    hi[b] = pos - 1;
    auto it = in[a].begin();
    int take = Len(b);
    while (take-- > 0)
        ++it;
    in[b].splice(in[b].end(), in[a], in[a].begin(), it);
    sum[b] = Sum(in[b]);
    lo[a] = pos;
    sum[a] -= sum[b];
    ds.insert(ds.begin() + idx, b);
    return idx + 1;
}

ll Sum(vi &ds, int l, int r)
{
    int beg = Split(ds, l);
    int end = Split(ds, r + 1);
    ll total = 0;
    for (int i = beg; i < end; ++i)
        total += sum[ds[i]];
    Fix(ds);
    return total;
}

void Reverse(vi &ds, int l, int r)
{
    
}

int main()
{
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; ++i)
        scanf("%d", &inp[i]);

    vi ds = Init();
    int cnt = 0;
    for (int i = 0; i < m; ++i)
    {
        int type;
        scanf("%d", &type);

        int l, r;
        scanf("%d%d", &l, &r);
        --l, --r;

        if (type == 0)
        {
            printf("%lld\n", Sum(ds, l, r));
        }
        else
        {
            int left = Split(ds, l);
            int right = Split(ds, r) - 1;

            Reverse(ds, left, right);

            cnt++;
            if (cnt == BLOCK)
            {
                Fix(ds);
            }
        }
    }

    return 0;
}
