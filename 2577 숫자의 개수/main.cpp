#include <stdio.h>

int main(){
    int a,b,c,x;
    char num[11]={0,};
    scanf("%d",&a);
    scanf("%d",&b);
    scanf("%d",&c);
    x=a*b*c;
    while(x>0){
        num[x%10]++;
        x=x/10;
    }
    for(int i=0; i<=9; i++){
        printf("%d\n",num[i]);
    }
}