import sys
from collections import deque
#재귀함수 호출 수 제한으로 다르게 구현 ->(dfs를 queue를 이용한 bfs로 구현)

input = sys.stdin.readline
N = int(input())
Length=21

d = [-1]*(N+1) # tree 깊이를 위해
graph = [[] for _ in range(N+1)]
check = [False]*(N+1)

result = [[[0,0,0] for _ in range(Length)] for _ in range(N+1)]
parent = [[0,0] for _ in range(N+1)]
for _ in range(N-1):
    a,b,c = map(int,input().split())
    graph[a].append([b,c])
    graph[b].append([a,c])

# def dfs(x,depth):
#     check[x]=True
#     d[x]=depth
    
#     for node,cost in graph[x]:
#         if check[node]==False:
#             parent[node][0]=x
#             parent[node][1]=cost
#             dfs(node,depth+1)


def set_parent():
    check[1]=True
    d[1]=0
    q=deque()
    q.append(1)
    while q:
        x=q.popleft()
        for node,cost in graph[x]:
            if check[node]==False:
                parent[node][0]=x
                parent[node][1]=cost
                d[node]=d[x]+1
                check[node]=True
                q.append(node)
    
    for i in range(N+1):
        result[i][0][0]=parent[i][0]
        result[i][0][1]=parent[i][1]
        result[i][0][2]=parent[i][1]
    #희소 테이블 생성
    for i in range(1,Length):
        for j in range(1,N+1):
            result[j][i][0] = result[result[j][i-1][0]][i-1][0]
            result[j][i][1] = min(result[result[j][i-1][0]][i-1][1], result[j][i-1][1])
            result[j][i][2] = max(result[result[j][i-1][0]][i-1][2], result[j][i-1][2])

def lca(a,b):
    if d[a]>d[b]:
        a,b=b,a
    
    shortest = int(1e9)
    longest = 0
    for i in range(Length):
        if (d[b]-d[a])&2**i:
            shortest=min(shortest,result[b][i][1])
            longest = max(longest,result[b][i][2])
            b=result[b][i][0]
    if a==b:
        print(shortest,longest)
        return
    
    for i in range(Length-1,-1,-1):
        if result[a][i][0]!=result[b][i][0]:
            shortest = min(shortest,result[a][i][1],result[b][i][1])
            longest = max(longest,result[a][i][2],result[b][i][2])
            b=result[b][i][0]
            a=result[a][i][0]
    shortest = min(shortest,result[a][0][1],result[b][0][1])
    longest = max(longest,result[a][0][2],result[b][0][2])
    print(shortest,longest)
    return

set_parent()

m = int(input())
for _ in range(m):
    a,b=map(int,input().split())
    lca(a,b)