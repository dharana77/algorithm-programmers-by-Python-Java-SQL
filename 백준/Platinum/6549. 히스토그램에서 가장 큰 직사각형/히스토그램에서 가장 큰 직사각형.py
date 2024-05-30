
import sys
from copy import deepcopy
from collections import deque

input = sys.stdin.readline

if __name__ == '__main__':

     while True:
          graph = list(map(int, input().split())) + [0]
          n, graph = graph[0], graph[1:]
          if n == 0:
               break

          left, ans = 0, 0
          stack = [(0, graph[0])]

          for right in range(1, len(graph)):
               left = right
               while stack and stack[-1][1] > graph[right]:
                    left, height = stack.pop()
                    ans = max(ans, height * (right - left))
               stack.append((left, graph[right]))
          print(ans)