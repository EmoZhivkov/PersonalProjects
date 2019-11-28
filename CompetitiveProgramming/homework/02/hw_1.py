# https://www.hackerrank.com/contests/usp2019-week-2/challenges
from sys import stdin
from typing import *

dist: Dict[Tuple[int, bool], int] = {}

def best_dist(arr, i, s, is_connected):
    if i == len(arr) - 2:
        return s + arr[i + 1] - arr[i]

    if (i, is_connected) in dist:
        return dist[(i, is_connected)]

    if is_connected:
        connected = best_dist(arr, i + 1, s + arr[i + 1] - arr[i], True)
        not_connected = best_dist(arr, i + 1, s, False)

        best = min(connected, not_connected)
    else:
        best = best_dist(arr, i + 1, s + arr[i + 1] - arr[i], True)

    dist[(i, is_connected)] = best
    return best

def main():
    num_of_nails = int(stdin.readline())
    nails = list(map(int, stdin.readline().split()))
    nails.sort()

    print(best_dist(nails, 0, 0, False))
    print(dist)


if __name__ == "__main__":
    main()
