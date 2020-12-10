
import java.util.*;

public class BJ11055{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        
        for(int i=0; i<n; i++){
            a[i]=sc.nextInt();
        }
        
        int max=0;
        for(int i=0; i<n; i++){
            dp[i]=a[i];
            for(int j=0; j<i; j++){
                if(a[j]<a[i] && dp[i]<a[i]+dp[j]){
                    dp[i]=a[i]+dp[j];
                }
            }
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
