import sys

input=sys.stdin.readline

N=int(input())

l = list(map(int,input().split()))
dp = [1]*N

# 가장 긴 증가하는 부분 수열(LIS) 알고리즘 사용
for i in range(N-2,-1,-1):
    for j in range(N-1,i,-1):
       if l[j]<l[i]:
        dp[i]=max(dp[i],dp[j]+1)
print(N-max(dp))
