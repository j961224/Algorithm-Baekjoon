#include <stdio.h>

int main(){
    int a,b,c;
    int d,e,f,g;
    scanf("%d %d %d",&a,&b,&c);
    
    d=a+b;
    d=d%c;
    
    e=a%c;
    e=e+b%c;
    e=e%c;
    
    f=a*b;
    f=f%c;
    
    g=a%c;
    g=g*b%c;
    g=g%c;
    
    printf("%d\n",d);
    printf("%d\n",e);
    printf("%d\n",f);
    printf("%d",g);
    
    
}