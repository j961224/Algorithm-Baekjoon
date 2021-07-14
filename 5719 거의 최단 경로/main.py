import sys
import heapq
INF = int(1e9)
def back_tracking(distance, end):
    #바꿀 것은 global로 불러오기
    global removal
    
    tmp = distance[end]
    #끝지점에서 점점 돌아간다.
    for a in back[end]:
        if distance[a]>distance[end]:
            continue
        if distance[a]+graph[a][end]==tmp:
            if (a,end) not in removal:
                removal.add((a,end))
                back_tracking(distance,a)
    
while(True):
    N,M=map(int,input().split())
    if N==0 and M==0:
        break
    start,end=map(int,input().split())
    
    distance = [INF]*(N)
    graph = [{} for i in range(N)]
    back = [[] for i in range(N)]
    for _ in range(M):
        a,b,c=map(int,input().split())
        graph[a][b]=c
        #back은 b에서 a말고 여러 군데로 갈 수 있으므로 append
        back[b].append(a)
    distance[start]=0
    
    q=[]
    heapq.heappush(q,(start,0))
    while q:
        now,cost = heapq.heappop(q)
        if distance[now]<cost:
            continue
        for a in graph[now]:
            c = cost+graph[now][a]
            if c<distance[a]:
                distance[a]=c
                heapq.heappush(q,(a,c))
    
    if distance[end]>=INF:
        print(-1)
        continue

    #제일 최단 거리 구함!
    removal = set()
    back_tracking(distance,end)
    
    for z,z1 in removal:
        del graph[z][z1]
    
    distance = [INF]*(N)
    distance[start]=0
    q=[]
    heapq.heappush(q,(start,0))
    while q:
        now,cost = heapq.heappop(q)
        if distance[now]<cost:
            continue
        for a in graph[now]:
            c = cost+graph[now][a]
            if c<distance[a]:
                distance[a]=c
                heapq.heappush(q,(a,c))
    
    if distance[end]>=INF:
        print(-1)
    else:
        print(distance[end])
    