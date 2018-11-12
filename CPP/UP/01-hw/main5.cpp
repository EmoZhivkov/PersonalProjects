/**
*
* Solution to homework task 5
* Introduction to programming course
* Faculty of Mathematics and Informatics of Sofia University
* Winter semester 2018/2019
*
* @author Emil Zhivkov
* @idnumber 62215
* @task 5
* @compiler GCC
*
*/

#include <iostream>
#include <math.h>

using namespace std;

struct Point {
    double x;
    double y;
};

struct Circle {
    Point center;
    double radius;
};

double distance(Point a, Point b) {
    return sqrt(pow(abs(a.x - b.x), 2) + pow(abs(a.y - b.y), 2));
}

bool isPointInCircle(Point point, Circle circle) {
    return distance(point, circle.center) < circle.radius;
}

bool isPointOnTheEdge(Point point, Circle circle) {
    return distance(point, circle.center) == circle.radius;
}

bool isLeftSide(Point point) {
    return point.x <= 0;
}

int main() {
    double x,y;
    cin >> x >> y;

    Point current = Point{x, y};

    Point centerBigCircle = Point{0, 0};
    Circle bigCircle = Circle{centerBigCircle, 6};

    Point centerSmallBlackCircle = Point{0, 3};
    Circle smallBlackCircle = Circle{centerSmallBlackCircle, 1};

    Point centerSmallWhiteCircle = Point{0, -3};
    Circle smallWhiteCircle = Circle{centerSmallWhiteCircle, 1};

    Circle middleWhiteCircle = Circle{centerSmallBlackCircle, 1};

    Circle middleBlackCircle = Circle{centerSmallWhiteCircle, 1};

    if (isPointInCircle(current, bigCircle)) {
        if (isLeftSide(current)) {
            if (isPointInCircle(current, smallBlackCircle)) {
                cout << "Black" << endl;
            } else if (isPointOnTheEdge(current, smallBlackCircle)) {
                cout << "Undefined" << endl;
            } else if (isPointInCircle(current, middleWhiteCircle)) {
                cout << "White" << endl;
            } else if (isPointOnTheEdge(current, middleWhiteCircle)) {
                cout << "Undefined" << endl;
            }else if (isPointInCircle(current, smallWhiteCircle)) {
                cout << "White" << endl;
            } else if (isPointOnTheEdge(current, smallWhiteCircle)) {
                cout << "Undefined" << endl;
            } else if (isPointInCircle(current, middleBlackCircle)) {
                cout << "Black" << endl;
            } else if (isPointOnTheEdge(current, middleBlackCircle)) {
                cout << "Undefined" << endl;
            } else {
                cout << "White";
            }
        } else  {
            if (isPointInCircle(current, smallBlackCircle)) {
                cout << "Black" << endl;
            } else if (isPointOnTheEdge(current, smallBlackCircle)) {
                cout << "Undefined" << endl;
            } else if (isPointInCircle(current, middleWhiteCircle)) {
                cout << "White" << endl;
            } else if (isPointOnTheEdge(current, middleWhiteCircle)) {
                cout << "Undefined" << endl;
            }else if (isPointInCircle(current, smallWhiteCircle)) {
                cout << "White" << endl;
            } else if (isPointOnTheEdge(current, smallWhiteCircle)) {
                cout << "Undefined" << endl;
            } else if (isPointInCircle(current, middleBlackCircle)) {
                cout << "Black" << endl;
            } else if (isPointOnTheEdge(current, middleBlackCircle)) {
                cout << "Undefined" << endl;
            } else {
                cout << "Black";
            }
        }
    } else {
        if (isPointOnTheEdge(current, bigCircle)) {
            cout << "Undefined" << endl;
            return 0;
        }
        cout << "Outside" << endl;
    }

    return 0;
}

