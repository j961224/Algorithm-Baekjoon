
import java.util.*;
//처음에 dfs로 했으나 시간 초과! -> 연속된 숫자이니 DP에 LIS를 유사하게 생각

public class BJ1912{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] a = new int[cnt];
        int[] dp = new int[cnt];
        
        for(int i=0; i<cnt; i++){
            a[i]=sc.nextInt();
        }
        
        int max = a[0];
        dp[0]=a[0];
        for(int j=1; j<a.length; j++){
            dp[j]=Math.max(dp[j-1]+a[j],a[j]);
            
            max=Math.max(dp[j],max);
        }
        
        System.out.println(max);
    }
    

}
