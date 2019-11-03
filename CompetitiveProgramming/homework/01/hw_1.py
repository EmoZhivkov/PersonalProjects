# https://www.hackerrank.com/usp2019-week-1
if __name__ == "__main__":
    i = input().split(' ')
    n, f, t = map(int, i)

    nums = sorted([str(num) for num in range(1, n + 1)])[f - 1:t]

    for curr in nums:
        print(curr)