import sys
input = sys.stdin.readline
INF = int(1e9)
n=int(input())
m=int(input())
graph=[list(map(int,input().split())) for _ in range(n)]

travel=list(map(int,input().split()))

for i in range(n):
    for j in range(n):
        if graph[i][j]==0 and i !=j:
            graph[i][j]=INF

for k in range(n):
    for a in range(n):
        for b in range(n):
            graph[a][b]=min(graph[a][b],graph[a][k]+graph[k][b])

check=True
x=travel[0]-1
for i in range(1,m):
    if graph[x][travel[i]-1]>=INF:
        check=False
        break
    else:
        x=travel[i]-1

if check==True:
    print("YES")
else:
    print("NO")