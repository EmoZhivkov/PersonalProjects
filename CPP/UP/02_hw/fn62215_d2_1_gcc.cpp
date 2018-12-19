#include <iostream>

using namespace std;

void rotate(int *arr, int length, int m) {
    if (m == 0) {
        return;
    }

    int *arrNew = new int[length];

    if (m > 0) {
        int startPos = length - m;

        int pos = 0;
        for (int i = startPos; i <= length; ++i) {
            if (pos == length) {
                break;
            }

            if (i == length) {
                i = 0;
            }

            arrNew[pos] = arr[i];
            pos++;
        }
    } else  {
        m = -m;

        int startPos = m - 1;


        int pos = length - 1;
        for (int i = startPos; i >= -1; i--) {
            if (pos == -1) {
                break;
            }

            if (i == -1) {
                i = length - 1;
            }

            arrNew[pos] = arr[i];
            pos--;
        }
    }

    for (int j = 0; j < length; ++j) {
        arr[j] = arrNew[j];
    }
}

int main() {
    int arr[] = {6, 5, 6, 0, 3};
    int l = 5;
    int m;
    cin >> m;

    if (m >= l || -m >= l) {
        cout << "Error!" << endl;
        return 0;
    }

    rotate(arr, l, m);

    cout << "Arr = {";
    for (int j = 0; j < l; ++j) {
        if (j == l - 1) {
            cout << arr[j];
            break;
        }
        cout << arr[j] << ", ";
    }
    cout << "}" << endl;

    return 0;
}