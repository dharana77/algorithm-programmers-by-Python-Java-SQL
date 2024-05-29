
import sys
from copy import deepcopy

input = sys.stdin.readline

if __name__ == '__main__':

     n, k = map(int, input().split())

     #n! / (n-k)! * k!

     #( (n-k)! (k)! )^ (p-1) = 1 (mod p)
     # -> ((n-k)!(k!)) ^ -1 =  ((n-k)! * (k)!) ^ p (mod p)

     # (n! % p) * ((n-k)!  * (k!)) ^ p % p
     mod = int(1e9 + 7)
     # print(mod)
     # # mod = 1000000007
     # print(mod)
     def pow(a, b):
          # print(a,b)
          if b == 0:
               return 1
          if b % 2:
               return (pow(a, int(b//2)) ** 2 * a) % mod
          else:
               return (pow(a, int(b//2)) ** 2) % mod

     fac = [1] * 4000001
     for i in range(1, n+1):
          fac[i] = fac[i-1] * i % mod

     a = fac[n]
     b = (fac[n-k] * fac[k]) % mod

     print((a % mod) * (pow(b, mod-2) % mod) % mod)
