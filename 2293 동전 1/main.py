import sys

input=sys.stdin.readline

n,k=map(int,input().split())
dp=[0]*(k+1)
data=[0]*n
for i in range(n):
    data[i]=int(input())

dp[0]=1
# data[i]의 값 이상인 경우에 +해주기
for i in data:
    for j in range(i,k+1):
        dp[j]+=dp[j-i]
print(dp[k])