// https://www.hackerrank.com/contests/usp2019-week-2/challenges
#include <bits/stdc++.h>
using namespace std;

int *positions;

int best_dist(int *arr, int i, int s, bool is_connected, int len) {
    if (i == len -2) {
        return s + arr[i + 1] - arr[i];
    }

    if (is_connected){
        return min(best_dist(arr, i + 1, s + arr[i + 1] - arr[i], true, len), best_dist(arr, i + 1, s, false, len));
    }
    else
    {
        return best_dist(arr, i + 1, s + arr[i + 1] - arr[i], true, len);
    }
}

int main()
{
    int num_of_nails;
    cin >> num_of_nails;

    int positions[num_of_nails];
    for (int i = 0; i < num_of_nails;++i) {
        cin >> positions[i];
    }

    sort(positions, positions+num_of_nails);

    int Solve(int idx){
        if(idx < 0) return 0;
        if(idx == 0) return 1E9;
        return min(Solve(idx - 2) + positions[idx] - positions[idx - 1], Solve(idx - 1) + positions[idx] - positions[idx - 1]);
    };

    cout << Solve(0) << endl;
    return 0;
}