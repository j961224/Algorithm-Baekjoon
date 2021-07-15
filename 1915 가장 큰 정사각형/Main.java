import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];
        int maxsize = 0;
        sc.nextLine();
        for(int i=0; i<N; i++){
            String tmp = sc.nextLine();
            for(int j=0; j<M; j++){
                arr[i][j]=Integer.parseInt(tmp.substring(j,j+1));
                if(arr[i][j]==1){
                    dp[i][j]=1;
                    maxsize=1;
                }
            }
        }
        
        for(int i=N-2; i>=0; i--){
            for(int j=M-2; j>=0; j--){
                if(arr[i+1][j]==1 && arr[i][j+1]==1 && arr[i+1][j+1]==1){
                    dp[i][j]=Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i][j+1]))+1;
                }
                maxsize=Math.max(dp[i][j],maxsize);
            }
        }
        int aw = (int)Math.pow(maxsize,2);
        System.out.println(aw);
    }
}