import sys
input=sys.stdin.readline

dp=[0,1,2]
for i in range(3,1001):
    dp.append(dp[i-2]+dp[i-1])


N=int(input())
print(dp[N]%10007)