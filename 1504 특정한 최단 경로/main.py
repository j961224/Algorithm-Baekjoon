import heapq
import sys
input = sys.stdin.readline
INF= int(1e9)
N,E = map(int,input().split())
graph = [[] for i in range(N+1)]

for _ in range(E):
    a,b,c=map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
v1,v2 = map(int,input().split())

def dijkstra(start):
    distance = [INF] * (N+1)
    distance[start]=0
    q=[]
    heapq.heappush(q,(start,0))
    while q:
        now, dist = heapq.heappop(q)
        for i in graph[now]:
            cost=dist+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(i[0],cost))
    return distance

init = dijkstra(1)
v1cost = dijkstra(v1)
v2cost = dijkstra(v2)
answer=min(init[v1]+v1cost[v2]+v2cost[N],init[v2]+v2cost[v1]+v1cost[N])
if answer>=INF:
    print(-1)
else:
    print(answer)