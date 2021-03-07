import sys

n=int(input())
a=[]
b=[[1]*n for i in range(n)]
answer=0

for _ in range(n):
    a.append(list(map(int,input().split())))

for k in range(n):
    for c in range(n):
        for d in range(n):
            if k==c or c==d or k==d:
                continue
            if a[c][d]==a[c][k]+a[k][d]:
                b[c][d]=0
            if a[c][d]>a[c][k]+a[k][d]:
                answer=-1
                break;
        if answer==-1:
            break;
    if answer==-1:
        break;

if answer!=-1:
    for i in range(n):
        for j in range(i,n):
            if b[i][j]==1:
                answer+=a[i][j]
       
print(answer)