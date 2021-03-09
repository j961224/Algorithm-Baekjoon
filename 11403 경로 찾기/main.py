import sys

input=sys.stdin.readline

N=int(input())
graph=[]
for _ in range(N):
    graph.append(list(map(int, input().split())))
def dfs(start):
    for i in range(N):
        if check[i]==0 and graph[start][i]==1:
            check[i]=1
            dfs(i)
            
for i in range(N):
    check=[0]*N
    dfs(i)
    for j in range(N):
        if check[j]==1:
            print(1,end=" ")
        else:
            print(0,end=" ")
    print()
    
