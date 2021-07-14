import sys
import heapq

N,M,K = map(int,input().split())
INF = int(1e9)
distance = [[INF]*K for _ in range(N+1)]
graph = [[] for _ in range(N+1)]

for _ in range(M):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))

#혹시나 돌아서 다시 자기 자신인 1로 가는 방법이 있을 수 있으므로 시작점 1 전체다 0으로 초기화 하지는 않는다.
distance[1][0]=0
q=[]
heapq.heappush(q,(1,0))
while q:
    now,cost = heapq.heappop(q)
    
    for a,b in graph[now]:
        c = b+cost
        if distance[a][K-1]>c:
            distance[a][K-1]=c
            distance[a]=sorted(distance[a])
            heapq.heappush(q,(a,c))

for i in range(1,N+1):
    if distance[i][K-1]>=INF:
        print(-1)
    else:
        print(distance[i][K-1])