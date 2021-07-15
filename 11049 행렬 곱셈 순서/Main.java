import java.util.*;


class Main{
    static int[][] arr,dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        arr = new int[N][2];
        dp = new int[N][N];
        
        for(int i=0; i<N; i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        
        for(int i=1; i<N; i++){
            for(int j=0; j+i<N; j++){
                sum(j,j+i);
            }
        }
        System.out.println(dp[0][N-1]);
    }
    
    public static void sum(int start, int end){
        for(int i=start; i<end; i++){
            int cost = dp[start][i]+dp[i+1][end]+arr[start][0]*arr[i][1]*arr[end][1];
            dp[start][end]=Math.min(cost,dp[start][end]);
        }
    }
}