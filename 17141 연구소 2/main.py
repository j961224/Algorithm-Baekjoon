import sys
from collections import deque 
from itertools import combinations
input = sys.stdin.readline

N,M=map(int,input().split())

data=[]
temp=[]
zcount=0

for i in range(N):
    d = list(map(int,input().split()))
    for j in range(N):
        if(d[j]==2):
            temp.append((i,j))
            d[j]=0
            zcount+=1
        elif(d[j]==0):
            zcount+=1
    data.append(d)

xx=[-1,1,0,0]
yy=[0,0,1,-1]

def bfs(data,a,zcount):
    newdata=data
    check=[[-1]*N for _ in range(N)]
    qu=deque()
    for k in a:
        qu.append(k)
        check[k[0]][k[1]]=0
    maxtime=0
    space=zcount-M
    
    while len(qu)!=0:
        tmpx, tmpy = qu.popleft()
        
        for i in range(4):
            tmpxx=tmpx+xx[i]
            tmpyy=tmpy+yy[i]
            if(tmpxx>=0 and tmpxx<N and tmpyy>=0 and tmpyy<N):
                if(newdata[tmpxx][tmpyy]==0 and check[tmpxx][tmpyy]==-1):
                    qu.append((tmpxx,tmpyy))
                    check[tmpxx][tmpyy]=check[tmpx][tmpy]+1
                    maxtime=max(maxtime,check[tmpxx][tmpyy])
                    space-=1
                    if(space<=0):
                        return maxtime
    if(space<=0):
        return maxtime
    return -1
    

answer=int(1e9)
for a in combinations(temp,M):
    answertmp=bfs(data,a,zcount)
    if(answertmp!=-1):
        answer=min(answer,answertmp)
if answer==int(1e9):
    print(-1)
else:
    print(answer)
    