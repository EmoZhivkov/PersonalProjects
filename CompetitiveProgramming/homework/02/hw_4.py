# https://www.hackerrank.com/contests/usp2019-week-2/challenges

from sys import stdin
from typing import *

memo: List[List[int]] = []

def min_dist(matrix, i, j, s):
    global memo
    if memo[i][j] != -1:
        return memo[i][j]

    if i == len(matrix) - 1:
        return s

    temp = []
    if j - 1 >= 0:
        temp.append(min_dist(matrix, i + 1, j - 1, s + matrix[i + 1][j - 1]))

    temp.append(min_dist(matrix, i + 1, j, s + matrix[i + 1][j]))

    if j + 1 < len(matrix[0]):
        temp.append(min_dist(matrix, i + 1, j + 1, s + matrix[i + 1][j + 1]))

    m = min(temp)
    memo[i][j] = m

    return m


def main():
    num = int(stdin.readline())
    global memo
    matrix = []
    for i in range(num):
        to_append =list(map(int, stdin.readline()[:-1]))
        matrix.append(to_append)
        memo.append([-1 for _ in to_append])

    # using another matrix to store the calculated indexes
    print(min(min_dist(matrix, 0,0,matrix[0][0]), min_dist(matrix, 0,1,matrix[0][1]), min_dist(matrix, 0,2,matrix[0][2])))
    for row in memo:
        print(row)

    # iterative approach
    # i = 1
    # while i < len(matrix):
    #     j = 0
    #     while j < len(matrix[0]):
    #         a = float('inf')
    #         if j - 1 >= 0:
    #             a = matrix[i - 1][j - 1]

    #         b = matrix[i - 1][j]

    #         c = float('inf')
    #         if j + 1 < len(matrix[0]):
    #             c = matrix[i - 1][j + 1]

    #         matrix[i][j] += min(a, b, c)
    #         j += 1
    #     i += 1

    # print(min(matrix[-1]))


if __name__ == "__main__":
    main()