import math
import sys

def is_digit(n):
    try:
        int(n)
        return True
    except ValueError:
        return  False

def is_valid_input(data):
    if len(data[0]) != 1:
        return 'first line of input should be a single number (size)'
    size = data.pop(0)[0]

    if len(data[0]) != 1:
        return 'second line of input should be a single number (where should be the zero be)' 
    zero_location = data.pop(0)[0]

    if size < 2:                        # puzzle too small?
        return 'puzzle too small'
    if len(data) != size:               # data[] should be an array of size N lists[]
        return 'number of rows doesnt match puzzle size'

    for line in data:                   # each list[] must be of size N (data must be square matrix)
        if len(line) != size:
            return 'number of columns doesnt match puzzle size'
    
    expanded = []
    for line in data:
        for x in line:
            expanded.append(x)

    generated = [x for x in range(size**2)]
    difference = [x for x in generated if x not in expanded]
    if len(difference) != 0:
        return 'puzzle tiles must be in range from 0 to SIZE'
    return 'ok'

def get_input():
    file_name = sys.argv[1]
    with open(file_name, 'r') as f:
        data = [line.strip() for line in f]

    puzzle = []
    for line in data:
        row = []
        for x in line.split(' '):
            if len(x) > 0:
                if not is_digit(x):
                    print('parser: invalid input, must be all numeric')
                    return None
                row.append(int(x))
        puzzle.append(row)

    puzzle[0][0] = int(math.sqrt(puzzle[0][0] + 1))
    size = puzzle[0][0]
    zero_location = puzzle[1][0]

    v = is_valid_input(puzzle)
    if v is not 'ok':
        print('parser: invalid input,',v)
        return None

    puzzle1d = []                   #convert 2d matrix into list
    for row in puzzle:
        for item in row:
            puzzle1d.append(item)
    return tuple(puzzle1d), size, zero_location
