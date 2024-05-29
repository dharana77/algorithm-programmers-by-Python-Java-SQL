import sys
from math import sqrt

input = sys.stdin.readline

if __name__ == '__main__':

    n = int(input())
    nums = list(map(int, input().split()))

    primes = [False] * 1001
    for i in range(2, 1001):
        flag = True
        for j in range(2, int(sqrt(i)) + 1):
            if i % j == 0:
                flag = False
                break

        if flag:
            primes[i] = True

    answer = 0
    for num in nums:
        if primes[num]:
            answer += 1

    print(answer)