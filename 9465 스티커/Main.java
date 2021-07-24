import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int M = sc.nextInt();
            int[][] arr = new int[2][M+1];
            int[][] dp = new int[2][M+1];
            for(int j=0; j<2; j++){
                for(int z=1; z<=M; z++){
                    arr[j][z]=sc.nextInt();
                }
            }
            
            dp[0][1]=arr[0][1];
            dp[1][1]=arr[1][1];
            for(int j=2; j<=M; j++){
                dp[0][j]=Math.max(dp[1][j-1],dp[1][j-2])+arr[0][j];
                dp[1][j]=Math.max(dp[0][j-1],dp[0][j-2])+arr[1][j];
            }
            sb.append(Math.max(dp[0][M],dp[1][M])+"\n");
        }
        System.out.println(sb);
    }
}