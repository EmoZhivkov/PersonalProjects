#include <iostream>
#include <algorithm>
using namespace std;

struct SockPair {
    int small;
    int big;
    int diff;
};

bool sockPairSorter(SockPair &first, SockPair &second) {
    if (first.diff == second.diff) {
        return first.small < second.small;
    }

    return first.diff < second.diff;
}

int main() {
    int n;
    int k;

    cin >> n >> k;

    int arr[n];
    for (int i = 0; i < n; ++i) {

        cin >> arr[i];

    }

    int cntPairs = 0;
    SockPair pairs[(n*n)/2];
    for (int i = 0; i < n; ++i) {

        for (int j = i + 1; j < n; ++j) {

            SockPair temp;
            temp.small = arr[i];
            temp.big = arr[j];
            temp.diff = temp.big - temp.small;

            pairs[cntPairs] = temp;

            cntPairs++;
        }

    }

    sort(pairs, pairs + cntPairs, &sockPairSorter);

    for (int i = 0; i < cntPairs - 1; ++i) {

        if (pairs[i].diff == pairs[i + 1].diff) {
            if (pairs[i].small > pairs[i + 1].small) {

                SockPair temp = pairs[i];
                pairs[i] = pairs[i + 1];
                pairs[i + 1] = temp;

            }
        }
    }

    cout << pairs[k - 1].small << " " << pairs[k - 1].big << endl;

    return 0;
}