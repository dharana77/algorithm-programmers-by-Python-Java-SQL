import sys

input = sys.stdin.readline

t = int(input())

target = 1000000
g = [0] * (1000001 + 1)
for i in range(1, 1001):
    for j in range(1, int(target/i) + 1):
        if i <= j:
            g[i*j] += i
        if i < j:
            g[i*j] += j

for i in range(2, target+1):
    g[i] += g[i-1]

for i in range(t):
    n = int(input())
    print(g[n])