import sys; input = sys.stdin.readline
from collections import deque

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# 2차원 좌표를 1차원 좌표로 변경
def coord(i, j):
    return i * C + j

# union-find
def find(u):
    if pa[u] != u:
        pa[u] = find(pa[u])
    return pa[u]

def union(u, v):
    u = find(u)
    v = find(v)
    if u < v:
        pa[v] = u
    elif v < u:
        pa[u] = v

R, C = map(int, input().split())
matrix = [input().strip() for _ in range(R)]

# 물과 백조가 있는 공간을 dq에 넣자.
dq = deque()
visited = [[False] * C for _ in range(R)]
swans = [] # 백조가 있는 위치
for i in range(R):
    for j in range(C):
        if matrix[i][j] != 'X':
            dq.append((i, j))
            visited[i][j] = True
            if matrix[i][j] == 'L': # 백조가 있는 공간은 따로 저장
                swans.append((i, j))

# 두 백조가 있는 영역이 합쳐지는 것은 분리 집합으로 판별할 수 있다.
pa = [i for i in range(R * C)]

# BFS & disjoint set
days = 0 # 걸리는 날
while dq:

    # 1. 현재 dq에 담겨있는 위치에서 인접한 위치 중 물인 공간과 union
    for i, j in dq:
        u = coord(i, j)
        for di, dj in dir:
            if 0 <= i + di < R and 0 <= j + dj < C and visited[i + di][j + dj]: # 방문됨은 즉, 물인 공간
                v = coord(i + di, j + dj)
                union(u, v)

    # 2. 두 백조가 같은 집합에 속하는 지 확인
    if find(coord(*swans[0])) == find(coord(*swans[1])):
        print(days)
        break
    days += 1 # 다음 단계에서 빙판이 녹으면서 하루가 지난다.

    # 3. 물과 인접해 있는 빙판을 녹이면서, 녹인 빙판의 위치를 dq에 담기
    for _ in range(len(dq)): # 현재 담겨져 있는 위치들만 BFS
        i, j = dq.popleft()
        for di, dj in dir:
            if 0 <= i + di < R and 0 <= j + dj < C and not visited[i + di][j + dj]:
                dq.append((i + di, j + dj))
                visited[i + di][j + dj] = True