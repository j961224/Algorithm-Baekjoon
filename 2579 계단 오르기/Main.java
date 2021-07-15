import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] arr = new int[N+1];
        long[] dp = new long[N+1];
        
        for(int i=1; i<N+1; i++){
            arr[i]=sc.nextInt();
        }
        dp[1]=arr[1];
        if(N>=2){
            dp[2]=arr[1]+arr[2];
        }
        if(N>=3){
            dp[3]=Math.max(arr[1]+arr[3],arr[2]+arr[3]);
        }
        
        for(int i=4; i<N+1; i++){
            dp[i]=Math.max(dp[i-3]+arr[i-1]+arr[i],dp[i-2]+arr[i]);
        }
        
        System.out.println(dp[N]);
    }
}