#include <iostream>
#include <algorithm>
using namespace std;



int main() {
    int n;
    int k;

    cin >> n >> k;

    int arr[n];
    for (int i = 0; i < n; ++i) {

        cin >> arr[i];

    }

    sort(arr, arr + n, greater<int>());

    int cnt = 1;
    for (int j = 0; j < n; ++j) {

        if (cnt == k) {

            cnt = 0;

            arr[j] = 0;

        }

        cnt++;
    }

    int sum = 0;
    for (int l = 0; l < n; ++l) {

        sum += arr[l];

    }

    cout << sum << endl;

    return 0;
}
