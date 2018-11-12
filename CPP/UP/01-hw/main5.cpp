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



    return 0;
}

