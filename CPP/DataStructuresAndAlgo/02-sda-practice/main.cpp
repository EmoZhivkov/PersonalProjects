#include <iostream>
using namespace std;

void bubbleSort(string* array, int lenght) {
    for(int i = 0; i < lenght; i++) {

        bool flag = false;
        for(int j = 0; j < lenght- i -1; j++) {

            string first = array[j] + array[j + 1];
            string second = array[j + 1] + array[j];
            int temp = first.compare(second);

            if (!(temp > 0)) {

                string temp = array[j + 1];
                array[j + 1] = array[j];
                array[j] = temp;

                flag = true;
            }

        }
        if (!flag) break;
    }
}

int main() {
    int lenght;
    cin >> lenght;

    bool b = true;

    string arr[lenght];
    for (int j = 0; j < lenght; ++j) {
        cin >> arr[j];
        if (arr[j] != "0") {
            b = false;
        }
    }

    bubbleSort(arr, lenght);

    if (!b) {
        for (int i = 0; i < lenght; ++i) {
            cout << arr[i];
        }
    } else  {
        cout << "0" << endl;
    }


    cout << endl;
    return 0;
}