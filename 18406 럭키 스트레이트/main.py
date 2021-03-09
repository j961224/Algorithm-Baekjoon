import sys
input=sys.stdin.readline

data=input()

half=len(data)//2

left=0
right=0
for i in range(half):
    left+=int(data[i])
    right+=int(data[half+i])
if left==right:
    print("LUCKY")
else:
    print("READY")