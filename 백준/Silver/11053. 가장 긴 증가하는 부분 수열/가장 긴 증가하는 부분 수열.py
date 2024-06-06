import sys
from collections import deque
from math import sqrt

input = sys.stdin.readline

if __name__ == '__main__':

    n = int(input())
    nums = list(map(int, input().split()))
    dp = [1] * (n+1)

    for i in range(0,n):
        for j in range(i):
            if nums[i] > nums[j]:
                dp[i] = max(dp[i], dp[j]+1)
            # print(i, j, dp[i])
    
    print(max(dp))
