from collections import deque
from math import inf
import parser


def get_zero_row_idx(puzzle):
    for idx, row in enumerate(puzzle):
        for col in puzzle:
            if col == 0:
                return idx


def is_solvable(puzzle, solved, size):
    # Count the number of inversions
    inversions = 0
    for i in range(size * size - 1):
        for j in range(i + 1, size * size):            
                vi = puzzle[i]
                vj = puzzle[j]
                if solved.index(vi) > solved.index(vj):
                    inversions += 1
    
    # if the size is odd, the number of inversions should be even
    if size % 2 == 1 and inversions % 2 == 0:
        return True
    
    # if the blank is on an even row(counting from the bottom) and the number of inversions is odd
    # if the blank is on an odd row(counting from the bottom) and the number of inversions is even
    zero_row_idx = get_zero_row_idx(puzzle)
    if (size - zero_row_idx) % 2 != inversions % 2:
        return True

    return False


def get_solved(size, zero_location):
    puzzle = [x for x in range(1,size*size)]
    if zero_location == -1:
        puzzle.append(0)
    elif 0 <= zero_location < size*size:
        puzzle.insert(zero_location, 0)
    
    return tuple(puzzle)


# compute the sum of the distances of each tile from where it belongs
def manhattan(puzzle, solved, size):
    res = 0
    for i in range(size*size):
        if puzzle[i] != 0 and puzzle[i] != solved[i]:
            ci = solved.index(puzzle[i])
            y = (i // size) - (ci // size)
            x = (i % size) - (ci % size)
            res += abs(y) + abs(x)
    return res


def clone_and_swap(data,y0,y1):
    clone = list(data)
    tmp = clone[y0]
    clone[y0] = clone[y1]
    clone[y1] = tmp
    return tuple(clone)


def possible_moves(data, size):
    res = []
    y = data.index(0)
    if y % size > 0:
        left = clone_and_swap(data,y,y-1)
        res.append(left)
    if y % size + 1 < size:
        right = clone_and_swap(data,y,y+1)
        res.append(right)
    if y - size >= 0:
        up = clone_and_swap(data,y,y-size)
        res.append(up)
    if y + size < len(data):
        down = clone_and_swap(data,y,y+size)
        res.append(down)
    return res


def ida_star_search(puzzle, solved, size):
    def search(path, g, bound, evaluated):
        evaluated += 1
        node = path[0]
        f = g + manhattan(node, solved, size)
        if f > bound:
            return f, evaluated
        if node == solved:
            return True, evaluated
        ret = inf
        moves = possible_moves(node, size)
        for m in moves:
            if m not in path:
                path.appendleft(m)
                t, evaluated = search(path, g + 1, bound, evaluated)
                if t is True:
                    return True, evaluated
                if t < ret:
                    ret = t
                path.popleft()
        return ret, evaluated

    bound = manhattan(puzzle, solved, size)
    path = deque([puzzle])
    evaluated = 0
    while path:
        t, evaluated = search(path, 0, bound, evaluated)
        if t is True:
            path.reverse()
            return (True, path, {'space':len(path), 'time':evaluated})
        elif t is inf:
            return (False, [], {'space':len(path), 'time':evaluated})
        else:
            bound = t


def main():
    data = parser.get_input()
    if not data:
        return       
    puzzle, size, zero_location = data

    solved = get_solved(size, zero_location)
    
    if not is_solvable(puzzle, solved, size):
        print('not solvable')
        return

    res = ida_star_search(puzzle, solved, size)

    success, steps, complexity = res
    if success:
        print(max(len(steps) - 1, 0))
        for s in steps:
            print(s)
    else:
        print('solution not found')


if __name__ == '__main__':
    main()
