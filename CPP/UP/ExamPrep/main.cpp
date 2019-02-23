#include <iostream>
using namespace std;

int lengthOfChar(char *arr) {
    int cnt = 0;
    while (arr[cnt] != 0) {
        cnt++;
    }

    return cnt;
}

bool doExist(char *symbols, char *word){
    int lenWord = lengthOfChar(word);
    int lenSymbols = lengthOfChar(symbols);

    if (lenWord > lenSymbols) {
        return false;
    }

    bool flag = true;
    for (int i = 0; i < lenSymbols; ++i) {
        if (lenSymbols - i < lenWord) {
            return false;
        }

        for (int j = 0; j < lenWord; ++j) {
            if (symbols[i] != word[j]) {
                flag = false;
            }
            i++;
        }

        i -= lenWord;
        if (flag) {
            return true;
        }
        flag = true;
    }
}

int lengthNum(long num) {
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

int digitPos(long num, int k){
    int len = lengthNum(num);

    if (len < k) {
        return -1;
    }

    int *digits = new int[len];
    for (int i = len - 1; i >= 0 ; i--) {
        digits[i] = num % 10;
        num /= 10;
    }

    return digits[k -1];
}

double sqrt_a(double a, double eps){
    double prev = a;
    double current = 0;
    double diff = 0;

    do {
        current = (1.0/2.0)*(prev + (a/prev));
        diff = current - prev;
        if (diff < 0) {
            diff = - diff;
        }

        prev = current;
    } while(diff >= eps);

    return current;
}

int *multVectors(int *first, int *second, int length){
    int *result = new int[length];

    for (int i = 0; i < length; ++i) {
        result[i] = first[i] * second[i];
    }

    return result;
}

bool isDigit(char a) {
    return (int)a >= 48 && int(a) <= 57;
}

bool isNumber(char *number) {
    int len = lengthOfChar(number);

    bool flag = true;

    for (int i = 0; i < len; ++i) {
        if (!isDigit(number[i])) {
            flag = false;
            break;
        }
    }

    return flag;
}

int parseInt(char *number){
    int len = lengthOfChar(number);

    int mult = 1;
    int sum = 0;
    for (int i = len - 1; i >= 0; i--) {
        sum += (number[i] - '0') * mult;
        mult *= 10;
    }

    return sum;
}

bool isCorrectMonthAndDate(int d, int m) {
    if (d < 1 || d > 31 || m < 1 || m > 12) {
        return false;
    }

    for (int i = 1; i <= 12; ++i) {
        if (m == i && i % 2 != 0) {
            '\0'
        }
    }
}

bool checkDate(char *date) {
    int lenOfDate = lengthOfChar(date);

    if (lenOfDate != 5) {
        return false;
    }

    bool flag = true;
    for (int i = 0; i < lenOfDate; ++i) {
        if (i == 2) {
            continue;
        }

        if (!isDigit(date[i])) {
            return false;
        }
    }

    char *dd = new char[2];
    dd[0] = date[0];
    dd[1] = date[1];

    int d = parseInt(dd);

    char *mm = new char[2];
    mm[0] = date[3];
    mm[1] = date[4];

    int m = parseInt(mm);



}

int main() {


    cout << parseInt("01") << endl;

    return 0;
}