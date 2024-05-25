n, k = map(int, input().split())

    bags = list()
    mx = 0
    for i in range(n):
        a, b = map(int, input().split())
        bags.append((a,b))
        mx = max(mx, a)

    dp = [[0] * (k+1) for _ in range(n+1)]

    for i in range(1, n+1):
        for j in range(1, k+1):
            w, v = bags[i-1][0], bags[i-1][1]
            if j < w:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)

    # for i in dp:
    #     print(i)
    print(dp[n][k])
