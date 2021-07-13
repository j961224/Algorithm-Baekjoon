import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N+1)]
cost = [0]*(N+1)
indegree = [0]*(N+1)

for i in range(1,N+1):
    data = list(map(int,input().split()))[:-1]
    
    cost[i]=data[0]
    
    for j in data[1:]:
        graph[j].append(i)
        indegree[i]+=1

def topology_sort():
    result = [0]*(N+1)
    q=deque()
    
    for i in range(1,N+1):
        if indegree[i]==0:
            q.append(i)
    
    while q:
        z = q.popleft()
        
        result[z]+=cost[z]
        for i in graph[z]:
            indegree[i]-=1
            
            result[i]=max(result[i],result[z])
            if indegree[i]==0:
                q.append(i)
    
    for i in range(1,N+1):
        print(result[i])



topology_sort()