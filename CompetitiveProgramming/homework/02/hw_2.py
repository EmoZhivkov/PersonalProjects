# https://www.hackerrank.com/contests/usp2019-week-2/challenges

from collections import deque

if __name__ == "__main__":
    result = int(input())

    operations = [lambda x : x * 3, lambda x : x * 2, lambda x : x + 1]
    visited = set([1])

    queue = deque([(1, 1)])

    steps = 0
    while queue:
        num = queue.popleft()

        for op in operations:
            if op(num[0]) == result:
                steps = num[1]
                break

            if op(num[0]) < result and op(num[0]) not in visited:
                visited.add(op(num[0]))
                queue.append((op(num[0]), num[1] + 1))

        if steps != 0:
            break

    print(steps)
