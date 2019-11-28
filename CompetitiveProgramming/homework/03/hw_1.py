# https://www.hackerrank.com/contests/usp2019-week-3/challenges
import time
from sys import stdin


def multiply_row_by_a_col(first, second):
    return sum([first[i]*second[i] for i in range(len(first))])


def multiply_two_matrixes(first, second) -> list:
    second = [[second[j][i] for j in range(len(second))] for i in range(len(second[0]))]

    matrix = []
    for row in first:
        temp = []
        for col in second:
            temp.append(multiply_row_by_a_col(row, col))
        matrix.append(temp.copy())

    return matrix


def matrix_to_the_power_of(matrix, degree):
    if degree == 0:
        temp_matrix = []
        for i in range(len(matrix[0])):
            to_append = []
            for j in range(len(matrix[0])):
                if j == i:
                    to_append.append(1)
                else:
                    to_append.append(0)
            temp_matrix.append(to_append.copy())

        return temp_matrix

    if degree % 2 == 0:
        matrix_temp = matrix_to_the_power_of(matrix, degree / 2)
        return multiply_two_matrixes(matrix_temp, matrix_temp)
    else:
        return multiply_two_matrixes(matrix, matrix_to_the_power_of(matrix, degree - 1))


def num_of_fib(num):
    return multiply_two_matrixes(matrix_to_the_power_of([[4,-3, 1,-1, 1],
                                                         [1, 0, 0, 0, 0],
                                                         [0, 1, 0, 0, 0],
                                                         [0, 0, 1, 0, 0],
                                                         [0, 0, 0, 0, 1]], num - 3),
                                                        [[3], [0], [0], [0], [1]])[0][0]

first_matrix = [[4, -3, 1, -1, 1], [1, 0, 0, 0, 0], [0, 1, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 1]]
second_matrix = [[3], [0], [0], [0], [1]]

def main():
    num = int(stdin.readline())
    mod = 1000000007

    if num == 0:
        print(0)
        return
    elif num == 1:
        print(0)
        return
    elif num == 2:
        print(0)
        return

    num = num_of_fib(num) // mod
    print(num)

if __name__ == "__main__":
    main()

