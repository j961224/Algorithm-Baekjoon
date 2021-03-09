import sys

input=sys.stdin.readline

data=input()
count0=0
count1=0


for i in range(len(data)-1):
    if data[i]!=data[i+1]:
        if data[i]=='0':
            count1+=1
        if data[i]=='1':
            count0+=1

print(min(count0,count1))