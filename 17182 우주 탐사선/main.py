import sys

def dfs(graph, n, start, dist, visited, ret, depth):
    if depth==n-1:
        ret[0] = min(ret[0],dist)
        return
    
    for i in range(n):
        if visited[i]==False:
            visited[i]=True
            dfs(graph,n,i,dist+graph[start][i],visited,ret,depth+1)
            visited[i]=False

def main():
    n,start = map(int,input().split())
    graph = []
    
    for _ in range(n):
        graph.append(list(map(int, input().split())))
        
    for k in range(n):
        for a in range(n):
            for b in range(n):
                if a==b: continue
                graph[a][b]=min(graph[a][b],graph[a][k]+graph[k][b])
                
    
    visited=[False]*(n)
    visited[start]=True
    ret = [int(1e9)]
    dfs(graph,n,start,0,visited,ret,0) # 그래프, 점 개수, 시작점, 거리합, 방문 유무, 역대 최대 합, 깊이
    print(ret[0])


    
main()