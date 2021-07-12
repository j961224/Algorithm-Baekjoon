import sys
input = sys.stdin.readline

v,e = map(int,input().split())

parent = [i for i in range(v+1)]

def find_parent(x):
    if parent[x]==x:
        return x
    parent[x]=find_parent(parent[x])
    return parent[x]

def union_parent(a,b):
    a=find_parent(a)
    b=find_parent(b)
    if not a==b:
        parent[b]=a

k= ""
for i in range(e):
    a,b,c = map(int,input().split())
    if a==0:
        union_parent(b,c)
    elif a==1:
        if find_parent(b)==find_parent(c):
            k+="YES"+"\n"
        else:
            k+="NO"+"\n"
print(k)