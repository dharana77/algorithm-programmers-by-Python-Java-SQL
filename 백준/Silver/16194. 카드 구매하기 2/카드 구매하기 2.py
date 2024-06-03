import sys

input = sys.stdin.readline

if __name__ == '__main__':
    t = int(input())
    nums = [1e9] + list(map(int, input().split()))

    dp = [0] * (t+1)
    for i in range(len(nums)):
        dp[i] = nums[i]

    for i in range(1, t+1):
        for j in range(1, i+1):
            # print(i, j, nums[i], dp[i-j] + dp[j])
            dp[i] = min(dp[i], min(nums[i], dp[i-j] + dp[j]))
            # print(dp[i])

    # print(dp)
    print(dp[-1])