from collections import defaultdict

NORTH, SOUTH, WEST, EAST = [2 ** i for i in range(4)]
OFFSETS = {
    NORTH: (0, -1),
    SOUTH: (0, 1),
    WEST: (-1, 0),
    EAST: (1, 0),
}
OPPOSITES = {
    NORTH: SOUTH,
    SOUTH: NORTH,
    WEST: EAST,
    EAST: WEST,
}
LEFTS = {
    NORTH: WEST,
    WEST: SOUTH,
    SOUTH: EAST,
    EAST: NORTH,
}
RIGHTS = {
    NORTH: EAST,
    EAST: SOUTH,
    SOUTH: WEST,
    WEST: NORTH,
}


def maze(entrance_to_exit, exit_to_entrance):
    maze = defaultdict(int)
    x, y = OFFSETS[NORTH]
    direction = SOUTH
    for path in [entrance_to_exit, exit_to_entrance]:
        print(maze)
        for c in path:
            if c == "W":
                dx, dy = OFFSETS[direction]
                x += dx
                y += dy
                maze[x, y] |= OPPOSITES[direction]
            elif c == "L":
                direction = LEFTS[direction]
            elif c == "R":
                direction = RIGHTS[direction]
            else:
                raise RuntimeError("unexpected char '%s' in input." % c)
        direction = OPPOSITES[direction]
        del maze[(x, y)]
    xs = sorted(set(x for x, _ in iter(maze)))

    print(f"xs {xs}")
    ys = sorted(set(y for _, y in iter(maze)))
    print(f"ys {ys}")

    print(maze)
    print(xs,ys,sep="\n\n")
    return "\n".join("".join(f"%x" % maze[x, y] for x in xs) for y in ys)


N = "WRWWLWWLWWLWLWRRWRWWWRWWRWLW WWRRWLWLWWLWWLWWRWWRWWLW".split()

print("Case #:")
print(maze(N[0], N[1]))

