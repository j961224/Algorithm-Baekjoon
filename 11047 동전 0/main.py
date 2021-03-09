import sys
input=sys.stdin.readline

N, K =map(int,input().split())
data=[0]*(N)
for i in range(N):
    data[i]=int(input())
data.sort(reverse=True)
answer=0

for i in data:
    if i<=K:
        answer+=K//i
        K%=i
print(answer)