#include <iostream>
using namespace std;

static int lenght = 0;

int getCharArrSize(char* arr) {
    int cnt = 0;

    int i = 0;
    while (arr[i] != 0) {
        cnt++;
        i++;
    }

    return cnt;
}

int lenghtLongestSubString(char* temp, char* smaller) {
    int sizeTemp = getCharArrSize(temp);
    int sizeSmaller = getCharArrSize(smaller);

    int maxIndex = -1;
    int maxCnt = 0;
    int cnt = 0;

    int helper = 0;
    for (int i = 0; i < sizeTemp; ++i) {

        helper = i;

        for (int j = 0; j < sizeSmaller; ++j) {

            if (temp[i] != smaller[j]) {

                break;
            }

            if (j == sizeSmaller - 1) {
                j = -1;
                cnt++;
            }

            i++;
        }

        if (cnt > maxCnt) {
            maxCnt = cnt;
            maxIndex = helper;
        }

        cnt = 0;
    }

    lenght = maxCnt * sizeSmaller;

    return maxIndex;
}

int main() {
    char temp[100];
    cin >> temp;

    char smaller[100];
    cin >> smaller;

    int index = lenghtLongestSubString(temp, smaller);

    cout << "Index: " << index << endl;
    cout << "Lenght: " << lenght << endl;

    return 0;
}

