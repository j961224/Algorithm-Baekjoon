import sys

input=sys.stdin.readline

N=int(input())

l = list(map(int,input().split()))
dp = [1]*N

for i in range(N-2,-1,-1):
    for j in range(N-1,i,-1):
       if l[j]<l[i]:
        dp[i]=max(dp[i],dp[j]+1)
print(N-max(dp))