import sys
#kruskal을 이용할 것이다.

def find_parent(parent,x):
    if parent[x]!=x:
        parent[x]=find_parent(parent,parent[x])
    return parent[x]

def union_parent(parent,a,b):
    a=find_parent(parent,a)
    b=find_parent(parent,b)
    if a<b:
        parent[b]=a
    else:
        parent[a]=b

V,E=map(int,input().split())

graph = []
parent = [0]*(V+1)
answer=0

for i in range(len(parent)):
    parent[i]=i

for i in range(E):
    a,b,cost = map(int,input().split())
    
    graph.append((cost,a,b))
graph.sort()

for i in graph:
    cost,a,b=i
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b)
        answer+=cost
    

print(answer)