#include <iostream>
#include <iomanip>
using namespace std;

struct Time {
    int hours;
    int minutes;
};

Time findDifference(Time start, Time stop) {

    Time diff;

    if(stop.hours < start.hours) {
        diff.hours = 24 - start.hours + stop.hours;
    } else {
        diff.hours = stop.hours - start.hours;
    }

    if (stop.minutes < start.minutes) {
        diff.minutes = 60 - start.minutes + stop.minutes;
        diff.hours--;
    } else {
        diff.minutes = stop.minutes - start.minutes;
    }

    return diff;
}

int main() {
    int first[4];
    for (int i = 0; i < 4; ++i) {
        cin >> first[i];
    }

    Time firstStart;
    firstStart.hours = first[0];
    firstStart.minutes = first[1];

    Time firstStop;
    firstStop.hours = first[2];
    firstStop.minutes = first[3];


    int second[4];
    for (int i = 0; i < 4; ++i) {
        cin >> second[i];
    }

    Time secondStart;
    secondStart.hours = second[0];
    secondStart.minutes = second[1];

    Time secondStop;
    secondStop.hours = second[2];
    secondStop.minutes = second[3];


    int third[4];
    for (int i = 0; i < 4; ++i) {
        cin >> third[i];
    }

    Time thirdStart;
    thirdStart.hours = third[0];
    thirdStart.minutes = third[1];

    Time thirdStop;
    thirdStop.hours = third[2];
    thirdStop.minutes = third[3];

    Time firstDiff = findDifference(firstStart, firstStop);
    Time secondDiff = findDifference(secondStart, secondStop);
    Time thirdDiff = findDifference(thirdStart, thirdStop);

    int firstMin = firstDiff.hours * 60 + firstDiff.minutes;
    int secondMin = secondDiff.hours * 60 + secondDiff.minutes;
    int thirdMin = thirdDiff.hours * 60 + thirdDiff.minutes;

    Time smallest;

    if (firstMin < secondMin) {
        if (firstMin < thirdMin) {
            smallest = firstDiff;
        } else {
            smallest = thirdDiff;
        }
    } else {
        if (secondMin < thirdMin) {
            smallest = secondDiff;
        } else {
            smallest = thirdDiff;
        }
    }

    Time biggest;

    if (firstMin > secondMin) {
        if (firstMin > thirdMin) {
            biggest = firstDiff;
        } else {
            biggest = thirdDiff;
        }
    } else {
        if (secondMin > thirdMin) {
            biggest = secondDiff;
        } else {
            biggest = thirdDiff;
        }
    }

    cout << smallest.hours << ":" << setfill('0') << setw(2) << smallest.minutes << endl;
    cout << biggest.hours << ":" << setfill('0') << setw(2) << biggest.minutes;

    return 0;
}