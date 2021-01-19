money=int(input())
money=1000-money
lst=[500,100,50,10,5,1]
count=0
for coin in lst:
    count+=money//coin
    money%=coin

print(count)