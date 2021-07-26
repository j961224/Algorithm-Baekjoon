import sys
from collections import deque

INF=int(1e9)
N = int(input())
graph = [[] for i in range(N+1)]


for _ in range(N):
    tmp = list(map(int,input().split()))
    for i in range(1,len(tmp),2):
        if tmp[i]==-1:
            break
        graph[tmp[0]].append((tmp[i],tmp[i+1]))
    

def bfs(start):
    visit = [-1]*(N+1)
    qu = deque()
    qu.append(start)
    visit[start]=0
    answer = [0,0] #가장 큰 노드와 거리 값을 저장할 list
    
    while qu:
        node = qu.popleft()
        for edge, cost in graph[node]:
            if visit[edge]==-1:
                visit[edge]=visit[node]+cost
                qu.append(edge)
                if visit[edge]>answer[0]:
                    answer[0]=visit[edge]
                    answer[1]=edge
    return answer
    
#트리의 지름을 구할 시, 가장 끝노드 끼리 거리가 되야 한다!
#임의 루트1에서 가장 먼 노드 구하기
#그 노드에서 가장 먼 거리 구하기 => 그 거리가 지름!
dis, node = bfs(1)
dis, node = bfs(node)
print(dis)