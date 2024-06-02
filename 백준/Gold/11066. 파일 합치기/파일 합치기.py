import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
  k = int(input()) 
  f = list(map(int, input().split()))
  
  d = [[0] * k for _ in range(k)]
    
  for i in range(k - 1):
    d[i][i + 1] = f[i] + f[i + 1]
    
    for j in range(i + 2, k):
      d[i][j] = d[i][j - 1] + f[j]

  for n in range(2, k):
    for i in range(k - n):
      j = i + n
      costs = [d[i][x] + d[x + 1][j] for x in range(i, j)]
      d[i][j] += min(costs)

  print(d[0][k - 1])