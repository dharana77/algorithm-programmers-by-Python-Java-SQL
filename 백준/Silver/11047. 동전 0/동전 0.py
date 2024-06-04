import sys

input = sys.stdin.readline

if __name__ == '__main__':
    n, k = map(int, input().split())
    nums = list()

    for i in range(n):
        temp = int(input())
        nums.append(temp)

    ans = 0
    for i in range(n-1, -1, -1):
        if k == 0:
            break
        if k >= nums[i]:
            temp = k // nums[i]
            k -= temp * nums[i]
            ans += temp
    print(ans)