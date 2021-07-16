import java.util.*;
import java.io.*;

public class Main{
    public static int N;
    public static int[] cards;
    public static int[][][] dp;
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int c=0; c<T; c++){
            N = Integer.parseInt(br.readLine());
            cards = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                cards[i]=Integer.parseInt(st.nextToken());
            }
            
            dp = new int[2][N][N];
            for(int i1=0; i1<2; i1++){
                for(int k=0; k<N; k++){
                    for(int k1=0; k1<N; k1++){
                        dp[i1][k][k1]=-1;
                    }
                }
            }
            System.out.println(solve(0,0,N-1));
        }
    }
    
    public static int solve(int turn, int start, int end){
        if(dp[turn][start][end]!=-1){
            return dp[turn][start][end];
        }
        
        if(start==end){
            if(turn==0){//근우차례
                return cards[start];
            }
            else{//명우차례
                return 0;
            }
        }
        
        dp[turn][start][end]=0;
        if(turn==0){
            dp[turn][start][end]=Math.max(solve(1,start+1,end)+cards[start],solve(1,start,end-1)+cards[end]);
        }
        else{
            dp[turn][start][end]=Math.min(solve(0,start+1,end),solve(0,start,end-1));
        }
        return dp[turn][start][end];
    }
}