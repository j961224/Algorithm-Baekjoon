import java.util.*;

class Main{
    static int maxbenefit;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int[][] array = new int[N][2];
        for(int i=0; i<N; i++){
            array[i][0]=sc.nextInt();
            array[i][1]=sc.nextInt();
        }
        int[] dp = new int[N+1];
        maxbenefit=0;
        for(int i=N-1; i>-1; i--){
            int time = array[i][0]+i;
            if(time<=N){
                dp[i]=Math.max(dp[time]+array[i][1],maxbenefit);
                maxbenefit=Math.max(dp[i],maxbenefit);
            }
            else{
                dp[i]=maxbenefit;
            }
        }
        System.out.println(maxbenefit);
    }
    
}