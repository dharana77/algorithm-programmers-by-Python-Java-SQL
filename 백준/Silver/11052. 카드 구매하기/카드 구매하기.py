import sys

input = sys.stdin.readline

if __name__ == '__main__':
    t = int(input())
    nums = [0] + list(map(int, input().split()))

    dp = [0] * (t+1)
    for i in range(1, t+1):
        for j in range(1, i+1):
            dp[i] = max(dp[i], dp[i-j] + nums[j])

    print(dp[-1])