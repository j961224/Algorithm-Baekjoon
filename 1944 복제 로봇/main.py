import sys
from collections import deque


def bfs(x,y,edges,start,key):
    visit = [[0 for i in range(N)] for j in range(N)]
    visit[x][y]=1
    q=deque()
    q.append((x,y,0))
    dx = [-1,1,0,0]
    dy = [0,0,1,-1]

    while q:
        xx,yy,d = q.popleft()
        
        for i in range(4):
            tmpx = xx+dx[i]
            tmpy = yy+dy[i]
            if tmpx>=0 and tmpx<N and tmpy>=0 and tmpy<N and visit[tmpx][tmpy]==0:
                if arr[tmpx][tmpy]>=2:
                    edges.append((d+1,start,arr[tmpx][tmpy]))
                    q.append((tmpx,tmpy,d+1))
                    key-=1
                elif arr[tmpx][tmpy]==0:
                    q.append((tmpx,tmpy,d+1))
                visit[tmpx][tmpy]=True
    
    if key:
        return False
    else:
        return True

def find_parent(x,parent):
    if parent[x]!=x:
        parent[x]=find_parent(parent[x],parent)
    return parent[x]

def union_parent(x,y,parent):
    x=find_parent(x,parent)
    y=find_parent(y,parent)
    if x>=y:
        parent[y]=x
    else:
        parent[x]=y

def kruskal(edges):
    parent = [i for i in range(M+3)]
    #rank = [0]*(M+3)
    edges.sort()
    cost=0
    for d,x,y in edges:
        if find_parent(x,parent)!=find_parent(y,parent):
            union_parent(x,y,parent)
            cost+=d
    
    return cost

def Solution(N,M,arr):
    edges=[]
    index=2 #빈칸이 0이고 못 가는 곳이 1이므로
    #start=0
    
    for i in range(N):
        for j in range(N):
            if arr[i][j]=='S' or arr[i][j]=='K':
                # if arr[i][j]=='S':
                #     start=index
                arr[i][j]=index
                index+=1
            else:
                arr[i][j]=int(arr[i][j])
    
    #bfs로 점검 고
    for i in range(N):
        for j in range(N):
            if arr[i][j]>=2:
                if not bfs(i,j,edges,arr[i][j],M):
                    print(-1)
                    return
            
    print(kruskal(edges))



if __name__=="__main__":
    N,M=map(int,input().split())
    arr = [list(input()) for i in range(N)]
    Solution(N,M,arr)