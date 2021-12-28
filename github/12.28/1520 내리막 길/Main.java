import java.util.*;
// DFS로 할 시, 시간 초과
// DP로 풀어야 되는 된다!

// DP로 경로의 갯수를 저장!
// ex. (1,4) -> (4,5)의 경우: 2
// 그러면 (1,4)로 갔을 경우에 중복해서 경로를 갈 필요가 없음!
// 시작점 -> 끝점까지는 DFS로 탐색하지만, 1번 탐색된 것은 dp에 경로 갯수 저장! 

public class Main{
    static int N,M; 
    static int[][] board;
    static int[][] dp;
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    //static boolean[][] check;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        //check = new boolean[N][M];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                board[i][j]=sc.nextInt();
                dp[i][j]=-1;
            }
        }
        
        
        System.out.println(dfs(1,1));
    }
    
    public static int dfs(int x, int y){
        if(x==N && y==M){
            return 1;
        }
        
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        dp[x][y]=0;
        
        for(int i=0; i<4; i++){
            int tmpx = x+xx[i];
            int tmpy = y+yy[i];
            
            if(tmpx>=1 && tmpx<=N && tmpy>=1 && tmpy<=M){
                if(board[x][y]>board[tmpx][tmpy]){
                    dp[x][y]+=dfs(tmpx,tmpy);
                }
            }
        }
        
        return dp[x][y];
    }
}