import sys

input = sys.stdin.readline

N,M=map(int,input().split())

data=[]

temp = [[0]*M for _ in range(N)]

for _ in range(N):
    data.append(list(map(int,input().split())))

xx=[-1,1,0,0]
yy=[0,0,1,-1]
def parasite(x,y):
    for i in range(4):
        tmpx=xx[i]+x
        tmpy=yy[i]+y
        if(0<=tmpx and tmpx<N and 0<=tmpy and tmpy<M):
            if(temp[tmpx][tmpy]==0):
                temp[tmpx][tmpy]=2
                parasite(tmpx,tmpy)
        
        

def score():
    count=0
    for i in range(N):
        for j in range(M):
           if temp[i][j]==0:
               count+=1
    return count

answer=0
def dfs(i):
    global answer
    if i==3:
        for a in range(N):
            for b in range(M):
                temp[a][b]=data[a][b]
        
        for a in range(N):
            for b in range(M):
                if temp[a][b]==2:
                    parasite(a,b)
        answer=max(score(),answer)
        return
    
    for a in range(N):
        for b in range(M):
            if data[a][b]==0:
                data[a][b]=1
                dfs(i+1)
                data[a][b]=0

dfs(0)
print(answer)