import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 1000*1000;
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        //0->1->2 차례로 비교
        for(int i=0; i<3; i++){
            for(int k=0; k<3; k++){
                if(i==k){
                    dp[0][i]=arr[0][i];
                }
                else{
                    dp[0][k]=1000*1000; //Integer.MAX_VALUE를 못 쓰는 이유는 Integer.MAX_VALUE에서 뭘 더 더하려고 하므로 값이 이상하게 나옴
                }
            }
            
            for(int k=1; k<N; k++){
                dp[k][0]=Math.min(dp[k-1][1],dp[k-1][2])+arr[k][0];
                dp[k][1]=Math.min(dp[k-1][0],dp[k-1][2])+arr[k][1];
                dp[k][2]=Math.min(dp[k-1][1],dp[k-1][0])+arr[k][2];
            }
            
            for(int k=0; k<3; k++){
                if(i!=k){
                    answer=Math.min(answer,dp[N-1][k]);
                }
            }
        }
        
        System.out.println(answer);
    }
}