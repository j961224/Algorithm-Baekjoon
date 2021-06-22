import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                arr[i][j]=sc.nextInt();
                if(i==0){
                    dp[i][j]=arr[i][j];
                }
            }
        }
        
        for(int i=1; i<N; i++){
            dp[i][0]=Math.min(arr[i][0]+dp[i-1][1],arr[i][0]+dp[i-1][2]);
            dp[i][1]=Math.min(arr[i][1]+dp[i-1][0],arr[i][1]+dp[i-1][2]);
            dp[i][2]=Math.min(arr[i][2]+dp[i-1][0],arr[i][2]+dp[i-1][1]);
        }
        
        
        
        System.out.println(Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]));
    }
}