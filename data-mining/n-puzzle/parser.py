import argparse
import sys

def is_valid_input(data):
    if len(data[0]) != 1:
        return 'first line of input should be a single number (size)'  # first list[] in data must be size of matrix
    size = data.pop(0)[0]
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
        return 'puzzle tiles must be in range from 0 to SIZE**2-1'
    return 'ok'

def get_input():
    file_name = sys.argv[1]
    with open(file_name, 'r') as f:
        data = [line.strip() for line in f]

    data = [line.split('#')[0] for line in data]      #remove comments
    data = [line for line in data if len(line) > 0]           #remove empty lines
    puzzle = []
    for line in data:
        row = []
        for x in line.split(' '):
            if len(x) > 0:
                if not x.isdigit():
                    print('parser: invalid input, must be all numeric')
                    return None
                row.append(int(x))
        puzzle.append(row)
    size = puzzle[0][0]
    v = is_valid_input(puzzle)
    if v is not 'ok':
        print('parser: invalid input,',v)
        return None
    puzzle1d = []                   #convert 2d matrix into list
    for row in puzzle:
        for item in row:
            puzzle1d.append(item)
    return tuple(puzzle1d), size
