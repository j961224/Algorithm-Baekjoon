import sys

input=sys.stdin.readline

N=int(input())
data=[0]*N

for i in range(N):
    a=int(input())
    data[i]=a
    
for i in data:
    answer=[0]*2
    answer[0]=1
    tmp=0
    for _ in range(i):
        tmp=answer[1]
        answer[1]=answer[0]+answer[1]
        answer[0]=tmp
    print(answer[0],answer[1])
    