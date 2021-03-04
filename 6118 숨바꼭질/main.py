import sys
import heapq

INF=int(1e9)
n,m = map(int, input().split())
graph=[[] for i in range(n+1)]
start=1
distance = [INF]*(n+1)

for _ in range(m):
    a,b = map(int, input().split())
    graph[a].append((b,1))
    graph[b].append((a,1))

def dijkstra(start):
    q=[]
    distance[start]=0
    heapq.heappush(q,(start,0))
    while q:
        now, dist = heapq.heappop(q)
        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost = dist+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(i[0],cost))

dijkstra(start)

countnode=0
startnode=0
mindist=0

for i in range(1,n+1):
    if i!=1:
        if mindist<distance[i]:
            mindist=distance[i]

for i in range(1,n+1):
    if distance[i]==mindist:
        if countnode==0:
            countnode+=1
            startnode=i
        else:
            countnode+=1

print(startnode,end=" ")
print(mindist,end=" ")
print(countnode,end=" ")