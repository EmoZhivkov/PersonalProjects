#pragma GCC optimize("O3")
#pragma GCC target("avx2")

#include <bits/stdc++.h>

#define all(x) (x).begin(),(x).end()
#define sz(x) (int)((x).size())

using namespace std;

typedef int_fast64_t ll;
typedef uint_fast64_t ull;
typedef int_fast32_t int32;
typedef vector<int32> vi;
typedef pair<int32,int32> ii;
typedef vector<ii> vii;

template<class T>
ostream& operator<<(ostream& out, vector<T> V){
    for(auto &i:V)out << i << " ";
    return flush(out);
}

int32 ExtendedGCD(int32 a, int32 b, int32 &x, int32 &y){
    if(b==0){
        x=1,y=0;
        return a;
    }
    int32 res = ExtendedGCD(b,a%b,x,y);
    int32 temp = y;
    /*  
        x*b+y*a%b = H --> Statement

        y*a+(x-(a/b)*y)*b = H --> Тъждество
        y*a+(x-((a-a%b)/b)*y)*b = H
        y*a+x*b-y*a+y*a%b = H
        x*b+y*a%b = H
    */
    y = x - (a/b)*y;
    x = temp;
    return res;
}

int32 solve(int32 a, int32 b, int32 minX, int32 maxX, int32 minY, int32 maxY){
    int32 x, y; 
    int32 g = ExtendedGCD(a,b,x,y);
    auto changeBy = [&x,&y,&a,&b](int32 k){
        x += k * b;
        y -= k * a;
    };
    cout << "base solution: " << x << " " << y << endl; 
// divide by g on both sides a*x+b*y=g -> a/g*x + b/g*y=1
// -> a'*x + b'*y = 1
// -> a'(x+b') + b'*(y-a') = a'*x + a'b' + b'*y - a'b' = a'*x + b'*y = 1;
// -> x+b' and y-a' are also solutions and so we get the formula
//    x+k*b' and y-k*a' for any k∈N are solutions to the linear equation
// Now we just need to find the minimum and maximum k which satisfy the range
    a /= g; 
    b /= g;
// Find sign of a and b
    int32 sa = a > 0 ? +1 : -1;
    int32 sb = b > 0 ? +1 : -1;

// Find the min x in the range which satisfies the equation
    changeBy((minX - x) / b);
    if (x < minX) changeBy(sb);
    int32 lx1 = x;

// Find the max x in the range which satisfies the equation
    changeBy((maxX - x) / b);
    if (x > maxX) changeBy(-sb);
    int32 rx1 = x;
    cout << "lx1, rx1: " << lx1 << " " << rx1 << endl;
// Similar for y
    changeBy(-(minY - y) / a);
    if (y < minY) changeBy(-sa);
    int32 lx2 = x; // The x for which the equation has minimal Y

    changeBy(-(maxY - y) / a);
    if (y > maxY) changeBy(sa);
    int32 rx2 = x; // The x for which the equation has maximal Y
    // Since the operations are for Y, it is possible that rx2 < lx2 even though it is for the max Y
    if(rx2 < lx2)swap(rx2,lx2);
    cout << "lx2, rx2: " << lx2 << " " << rx2 << endl;
    // [lx1,rx1] = [lx1,rx1]∩[lx2,rx2];
    lx1=max(lx1,lx2);
    rx1=min(rx1,rx2);
    cout << "lx, rx: " << lx1 << " " << rx1 << endl;

    if (lx1 > rx1) return 0;
    return (rx1 - lx1) / abs(b) + 1;
}

int main(){
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);

    int32 a, b;
    int32 minX,maxX,minY,maxY;

    cin >> a >> b;
    cin >> minX >> maxX >> minY >> maxY;
    
    cout << solve(a,b,minX,maxX,minY,maxY) << endl;
}
