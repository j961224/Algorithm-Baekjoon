#include <stdio.h>
void divide_sum(int N) {
    
    int i;
    int tmp = N;
    int sum = 0;
    int flag = 0;
    for (i = N-54;i < N;i++)
    {
        sum=tmp = i;
        while (tmp>0)
        {
            sum+= tmp % 10;
            tmp /= 10;
        }
        if (sum == N)
        {
            flag = 1;
            break;
        }
    }
    flag == 1 ? printf("%d",i) : printf("0");
}
int main()
{
    int N;
    scanf("%d", &N);
    divide_sum(N);
}
