#pragma GCC optimize("O3")
#pragma GCC target("avx2")

#include <bits/stdc++.h>
using namespace std;

const int N = 100000;
int arr[N], sum = 0;

int main() {
  for (int i = 0; i < N; ++i)
    for (int j = 0; j < N; ++j)
      sum += arr[j];
  printf("Time: %.3f\n", (clock() - 0.0) / CLOCKS_PER_SEC);
  return 0;
}
