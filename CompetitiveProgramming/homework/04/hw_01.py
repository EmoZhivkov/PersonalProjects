# https://www.hackerrank.com/contests/usp2019-week-4/challenges
from itertools import combinations

if __name__ == "__main__":
    test_str = input()
    print(len(set([test_str[x:y] for x, y in combinations(range(len(test_str) + 1), r = 2)])))