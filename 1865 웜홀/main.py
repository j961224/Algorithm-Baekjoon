import sys


input = sys.stdin.readline
INF = int(1e9)

TC = int(input())

for _ in range(TC):
    N,M,W = map(int,input().split())
    graph = [[] for i in range(N+1)]
    distance = [INF]*(N+1)
    
    for _ in range(M):
        a,b,cost = map(int,input().split())
        graph[a].append((b,cost))
        graph[b].append((a,cost))
    
    for _ in range(W):
        a,b,cost = map(int,input().split())
        graph[a].append((b,-cost))
    
    check = True
    #출발했을 때보다 시간이 되돌아가는 경우는, 음수로 계속 도는 경우므로 check는 false가 되야한다.
    for repeat in range(N):
        for i in range(1,N+1):
            for node,cost in graph[i]:
                if distance[node]>distance[i]+cost:
                    distance[node]=distance[i]+cost
                    if repeat == N-1:
                        check=False
    
    if check:
        print("NO")
    else:
        print("YES")
    
    
