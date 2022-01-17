d = {(0, 0): 5, (-1, 0): 12, (-2, 0): 10, (-2, 1): 3, (-2, 2): 9, (-1, 2): 12, (0, 2): 7, (0, 1): 6, (-1, 1): 8,
     (0, 3): 3, (0, 4): 5, (-1, 4): 12, (-2, 4): 9, (-2, 3): 14, (-1, 3): 4}
d2 = {}
for i in sorted(d):
    d2[i] = d[i]
# print(d2)
xs = sorted(set(x for x, _ in iter(d)))
ys = sorted(set(y for _, y in iter(d)))
print(xs, ys)

# print("\n".join("".join(f"%x" % d[x, y] for x in xs) for y in ys))
for y in [0, 1, 2, 3, 4]:
    a = ""
    for x in [-2, -1, 0]:
        a += str(d[x, y])
    print(a)
print([2 ** i for i in range(4)])