k = int(input())

ans = 0
for i in range(1, k+1):
    temp = (k // i) * i
    ans += temp
print(ans)