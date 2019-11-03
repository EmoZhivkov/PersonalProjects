# https://www.hackerrank.com/usp2019-week-1
def num_of_digits(num: int) -> int:
    return len(str(num))


if __name__ == "__main__":
    input()
    nums = [int(n) for n in input().split(' ')]

    for n in [1 * (10 ** (num_of_digits(num) - 1)) for num in nums[:-1]]:
        print(n, end=' ')

    print(1)