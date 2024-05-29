import sys
from copy import deepcopy

input = sys.stdin.readline

if __name__ == '__main__':

     n, k = map(int, input().split())

     board = [[0] * n for _ in range(n)]
     for i in range(n):
          inputs = list(map(int, input().split()))
          for j in range(n):
               board[i][j] = inputs[j]

     matrix = deepcopy(board)


     def mul(first, second):
          ln = len(first)
          res = [[0] * ln for _ in range(ln)]

          for i in range(ln):
               for j in range(ln):
                    temp = 0
                    for k in range(ln):
                         temp += ((first[i][k] * second[k][j]) % 1000)
                    res[i][j] = temp % 1000

          return res


     # test = mul(board, board)
     # print(test)

     def div(target):
          ln = len(target)
          for i in range(ln):
               for j in range(ln):
                    target[i][j] %= 1000
          return target


     def square(x, n):
          if n == 1:
               return x
          temp = square(x, n // 2)
          if n % 2 == 0:
               return mul(temp, temp)
          else:
               return mul(mul(temp, temp), x)

     matrix = square(matrix, k)
     matrix = div(matrix)

     for i in range(n):
          print(" ".join(map(str, matrix[i])))