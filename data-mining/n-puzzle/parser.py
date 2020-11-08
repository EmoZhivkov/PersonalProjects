import math
import sys
import fileinput

# mainly used to validate the negative number for the zero location
def is_digit(n):
    try:
        int(n)
        return True
    except ValueError:
        return  False

def is_valid_input(data):
    # Check size
    if len(data[0]) != 1:
        print('first line of input should be a single number (size)')
        return False
    size = data.pop(0)[0]

    # Check zero location
    if len(data[0]) != 1:
        print('second line of input should be a single number (where should be the zero be)')
        return False 
    zero_location = data.pop(0)[0]

    # Check if the size is too small 
    if size < 2:                      
        print('size is too small')
        return False
    
    # Check if the number of rows in the matrix matches the size
    if len(data) != size:             
        print('number of rows doesn\'t match puzzle size')
        return False

    # Check if the number of cols in the matrix matches the size
    for line in data:                  
        if len(line) != size:
            print('number of cols doesn\'t match puzzle size')
            return False
    
    expanded = [x for line in data for x in line]
    generated = [x for x in range(size**2)]

    # Check if the matrix given is a correct one
    difference = [x for x in generated if x not in expanded]
    if len(difference) != 0:
        print('puzzle tiles must be in range from 0 to SIZE')
        return False

    return True

def get_input():
    # file_name = sys.argv[1]
    # with open(file_name, 'r') as f:
    #     data = [line.strip() for line in f]

    data = []
    size = input()
    data.append(size)
    size = int(math.sqrt(int(size) + 1))

    zero_location = input()
    data.append(zero_location)

    for _ in range(size):
        data.append(input())

    puzzle = []
    for line in data:
        row = []
        for x in line.split(' '):
            if len(x) > 0:
                if not is_digit(x):
                    print('invalid input, must be all numeric')
                    return None
                row.append(int(x))
        puzzle.append(row)

    # Convert the size in a more usable format
    puzzle[0][0] = int(math.sqrt(puzzle[0][0] + 1))

    size = puzzle[0][0]
    zero_location = puzzle[1][0]

    # Check if the input is valid and pop the size and zero location
    if not is_valid_input(puzzle):
        print('invalid input')
        return None

    puzzle1d = []                   #convert 2d matrix into list
    for row in puzzle:
        for item in row:
            puzzle1d.append(item)
    return tuple(puzzle1d), size, zero_location
