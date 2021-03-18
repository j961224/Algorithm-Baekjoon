import sys
sys.setrecursionlimit(10000)

input=sys.stdin.readline

n,m=map(int,input().split())

graph=[[] for _ in range(n+1)]
check=[False]*(n+1)

def dfs(i):
    check[i]=True
    
    for k in graph[i]:
        if check[k]==False:
            dfs(k)

for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

answer=0

for i in range(1,n+1):
    if check[i]==False:
        dfs(i)
        answer+=1
print(answer)

