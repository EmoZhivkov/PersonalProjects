// https://www.hackerrank.com/contests/usp2019-week-3/challenges
#include<bits/stdc++.h>
using namespace std;

int lds( int arr[], int n )
{
    int lds[n];

    lds[0] = 1;

    for (int i = 1; i < n; i++ )
    {
        lds[i] = 1;
        for (int j = 0; j < i; j++ )
            if (lds[j] != 0 && arr[i] % arr[j] == 0)
                lds[i] = max(lds[i], lds[j] + 1);
    }

    return *max_element(lds, lds+n);
}

int main()
{
    int n;
    cin >> n;

    int arr[n];
    for (int i = 0; i < n;++i) {
        cin >> arr[i];
    }

    cout << lds(arr, n);
    return 0;
}