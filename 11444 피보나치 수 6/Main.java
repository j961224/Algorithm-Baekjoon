import java.util.*;
//피보나치 수를 행렬로 생각하고 거듭제곱을 이용해 풀어야 한다!

// A^n = [[F(n+1) Fn][Fn F(n-1)]]
class Main{
    static long answer=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        
        if(n==1){
            answer=1;
        }
        else{
            long[][] res = fibo(n-1);
            answer = res[0][0]; // [0][0]은 F(n+1) 부분이니 fibo 함수에 n-1을 넣었으니 Fn부분을 뜻한다.
        }
        System.out.println(answer);
        
    }
    
    public static long[][] fibo(long n){
        long[][] tmp = new long[2][2];
        long[][] arr = {{1,1},{1,0}};
        if(n==1){
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    tmp[i][j]=arr[i][j];
                }
            }
            return tmp;
        }
        
        //분할정복 -> 지수 절반하여 재귀호출
        long[][] tmp1 = fibo(n/2);
        
        //행렬 곱!
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<2; k++){
                    tmp[i][j]+=tmp1[i][k]*tmp1[k][j];
                }
                tmp[i][j]%=1000000007;
            }
        }
        
        // 나머지가 1이면 아직 1번 더 곱할 것이 남았다는 증거이다.
        if(n%2==1){
            long[][] t = new long[2][2];
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    for(int k=0; k<2; k++){
                        t[i][j]+=tmp[i][k]*arr[k][j];
                    }
                    t[i][j]%=1000000007;
                }
            }
            return t;
        }
        //곱할 것이 없으면 그대로 tmp return
        else{
            return tmp;
        }
    }
}