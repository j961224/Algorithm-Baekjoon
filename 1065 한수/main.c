#include <stdio.h>

int main(){
    int a,b,c,d;
    int count=0;
    scanf("%d",&a);
    if(a<100)
        printf("%d",a);
    else{
        for(int i=100; i<=a; i++){
            b=i/100;
            c=(i/10)%10;
            d=i%10;
            if((b-c)==(c-d)){
                count++;
            } 
        }
        count=99+count;
        printf("%d",count);
    }
}