import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        long[][] arr = new long[N+1][N+1];
        long[][] sum = new long[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                sum[i][j]=sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+arr[i][j];
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int startx=sc.nextInt();
            int starty=sc.nextInt();
            int endx=sc.nextInt();
            int endy=sc.nextInt();
            sb.append((sum[endx][endy]-sum[startx-1][endy]-sum[endx][starty-1]+sum[startx-1][starty-1])+"\n");
        }
        
        
        System.out.println(sb);
    }
}