import sys

input=sys.stdin.readline

N = int(input())

data=[0]*(N+1)
data[1]=1
data[2]=3
for i in range(3,N+1):
    data[i]=data[i-1]+data[i-2]*2
print(data[N]%10007)
