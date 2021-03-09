import sys
input=sys.stdin.readline

N=int(input())
data=list(map(int,input().split()))

data.sort()

answer=0

for i in range(N):
    answer+=(N-i)*data[i]
    
print(answer)