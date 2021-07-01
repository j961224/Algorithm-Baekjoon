import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] arr = new long[N+1];
        long[] sum = new long[N+1];
        for(int i=1; i<=N; i++){
            arr[i]=sc.nextInt();
            if(i==1){
                sum[i]=arr[i];
            }
            else{
                sum[i]=sum[i-1]+arr[i];
            }
        }
        
        for(int i=0; i<M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            
            System.out.println(sum[end]-sum[start-1]);
        }
    }
}