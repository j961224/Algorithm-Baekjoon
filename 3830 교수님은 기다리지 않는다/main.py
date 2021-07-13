import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)
#서로소 집합
def find_parent(x):
    if parent[x]!=x:
        #미리 parent 찾기
        r = find_parent(parent[x])
        distance[x]+=distance[parent[x]]
        parent[x]=r
    return parent[x]
    
def union_parent(x,y,cost):
    #여기서 1번더 find_parent하면 distance가 더 갱신되어버림
    xr=parent[x]
    yr=parent[y]
    # 처음에 if xr<yr과 else로 나누어 시도했는데 틀림
    # 이유는 거꾸로 진행되는 경우가 생김(이거는 y가 x보다 무조건 크므로)
    if xr!=yr:
        parent[yr]=xr
        distance[yr]=(distance[x]+cost)-distance[y]
    
while True:
    n,m = map(int,input().split())
    if n==0 and m==0:
        break
    parent = [0]*(n+1)
    distance = [0]*(n+1)
    
    for i in range(1,n+1):
        parent[i]=i
    
    for _ in range(m):
        data = list(map(str,input().split()))
        find_parent(int(data[1]))
        find_parent(int(data[2]))
        if data[0]=="!":
            union_parent(int(data[1]),int(data[2]),int(data[3]))
        else:
            if(parent[int(data[1])]==parent[int(data[2])]):
                print(distance[int(data[2])]-distance[int(data[1])])
            else:
                print("UNKNOWN")
            