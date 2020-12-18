#include <stdio.h>

int main(){
    int C;
    int N;
    int score;
    int total;
    double result;
    double out;
    int count;
    
    scanf("%d\n",&C);
    for(int i=0; i<C; i++){
        int A[1000];
        total=0;
        result=0.0;
        out=0.0;
        count=0;
        scanf("%d\t",&N);
        for(int k=0; k<N; k++){
            if(k==N-1){
                scanf("%d\n",&A[k]);
                total=total+A[k];
            }
            else if(k != N-1){
                scanf("%d\t",&A[k]);
                total=total+A[k];
            }
        }
        result=(double)total/N;
        
        for(int k=0; k<N; k++){
            if(result<A[k]){
                count=count+1;
            }
        }
        out=(double)count/N;
        printf("%.3lf%%\n",out*100);
    }
    
    return 0;
}