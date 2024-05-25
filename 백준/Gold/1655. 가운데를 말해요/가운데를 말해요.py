from heapq import heappop, heappush
import sys
input = sys.stdin.readline

n = int(input())

t = list()

minheap = list()
maxheap = list()

for i in range(n):
    k = int(input())

    if len(minheap) == len(maxheap):
        heappush(minheap, -k)
    else:
        heappush(maxheap, k)

    if maxheap and -minheap[0] > maxheap[0]:
        a = heappop(minheap)
        b = heappop(maxheap)
        heappush(maxheap, -a)
        heappush(minheap, -b)

    print(-minheap[0])