#include <iostream>
using namespace std;

int getNumOfDigits(int num) {
    if (num == 0) {
        return 1;
    }

    int cnt = 0;

    while (num > 0) {
        num /= 10;
        cnt++;
    }

    return cnt;
}

int sumOfDigits(int n) {
    int num = n;

    int cnt = 0;

    while (num > 0) {
        num /= 10;
        cnt++;
    }

    if (n == 0) {
        cnt = 1;
    }

    int sum = 0;
    for (int i = 0; i < cnt; ++i) {
        sum += n % 10;
        n /= 10;
    }

    return sum;
}



char toChar(int num) {
    if (num == 0) {
        return '0';
    } else if (num == 1) {
        return '1';
    } else if (num == 2) {
        return '2';
    } else if (num == 3) {
        return '3';
    } else if (num == 4) {
        return '4';
    } else if (num == 5) {
        return '5';
    } else if (num == 6) {
        return '6';
    } else if (num == 7) {
        return '7';
    } else if (num == 8) {
        return '8';
    } else if (num == 9) {
        return '9';
    }
}

char* getDate(int seconds) {
    char* date = new char[5];

    int minutesAll = seconds / 60;

    int hours = minutesAll / 60;
    int minutes = minutesAll % 60;

    if (hours < 10) {
        date[0] = '0';
        date[1] = toChar(hours);
    } else {
        int firstDigit = hours / 10;
        int secondDigit = hours % 10;

        date[0] = toChar(firstDigit);
        date[1] = toChar(secondDigit);
    }

    date[2] = ':';

    if (minutes < 10) {
        date[3] = '0';
        date[4] = toChar(minutes);
    } else {
        int firstDigit = minutes / 10;
        int secondDigit = minutes % 10;

        date[3] = toChar(firstDigit);
        date[4] = toChar(secondDigit);
    }

    return date;
}

int getBiggest(int arr[], int len) {
    int biggest = INT32_MIN;

    for (int i = 0; i < len; ++i) {
        if (arr[i] > biggest) {
            biggest = arr[i];
        }
    }

    return biggest;
}

int main() {
    int first[5] = {1,2,2398,4,5};
    int second[5] = {3298,23409283,2398,5,393};

    int biggest = INT32_MIN;
    int biggestIndex = 0;

    bool flag = true;
    while(flag) {
        for (int i = 0; i < 5; ++i) {
            if (first[i] > biggest) {
                biggest = first[i];
                biggestIndex = i;
            }
        }

        for (int j = 0; j < 5; ++j) {
            if (biggest == second[j]) {
                flag = false;
            }
        }

        if (flag) {
            first[biggestIndex] = INT32_MIN;
            biggest = INT32_MIN;
        }
    }

    cout << biggest << endl;

}