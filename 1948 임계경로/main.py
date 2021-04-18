import sys
from collections import deque

n=int(input())
m=int(input())

check=[0]*(n+1)
result=[0]*(n+1)
graph=[[]*(n+1) for i in range(n+1)]
backing_graph = [[]*(n+1) for i in range(n+1)]
indegree=[0]*(n+1)

q=deque()
for _ in range(m):
    a,b,c = map(int,input().split())
    indegree[b]+=1
    graph[a].append((b,c))
    backing_graph[b].append((a,c))

start,end = map(int,input().split())
q.append(start)

#도착 도시까지 걸리는 최대 시간 구하기
while q:
    now=q.popleft()
    for a,b in graph[now]:
        indegree[a]-=1 
        result[a]=max(result[a],result[now]+b)
        if indegree[a]==0:
            q.append(a)

#최대 시간을 구하는데 지나가는 도시 수 count(backtracking사용)
count=0
q.append(end)
while q:
    now=q.popleft()
    for a,b in backing_graph[now]:
        if result[now]-result[a]==b:
            count+=1
            if check[a]==0:
                check[a]=1
                q.append(a)

print(result[end])
print(count)