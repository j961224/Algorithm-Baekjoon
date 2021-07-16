import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] memorial = new int[N];
        int[] costs = new int[N];
        
        for(int i=0; i<N; i++){
            memorial[i]=sc.nextInt();
        }
        for(int i=0; i<N; i++){
            costs[i]=sc.nextInt();
        }
        
        //최대 100개에 앱 하나당 최대 100cost이므로 아무리 커도 10000이므로 설정
        int[] dp = new int[10001]; 
        Arrays.fill(dp,-1);
        
        for(int i=0; i<N; i++){
            int cost = costs[i];
            for(int j=10000; j>=cost; j--){
                if(dp[j-cost]!=-1){
                    //j-cost까지의 cost에서 최대 메모리가 
                    //현재 메모리를 추가한 것이 더 크다면 dp[j]에 추가
                    if(dp[j-cost]+memorial[i]>dp[j]){
                        dp[j]=dp[j-cost]+memorial[i];
                    }
                }
            }
            //dp[cost]의 메모리가 안 되어 있는 경우에, 메모리가 크다면 업데이트 
            if(dp[cost]<memorial[i]){
                dp[cost]=memorial[i];
            }
        }
        
        for(int i=0; i<=10000; i++){
            if(dp[i]>=M){
                System.out.println(i);
                break;
            }
        }
    }
}