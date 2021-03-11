import java.util.*;


class Main{
    static int answer=0;
    static int[][] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        arr = new int[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<i+1; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        answer=0;
        for(int i=1; i<N; i++){
            for(int j=0; j<i+1; j++){
                if(j==0){
                    arr[i][j]+=arr[i-1][j];
                }
                else if(j==i){
                    arr[i][j]+=arr[i-1][j-1];
                }
                else{
                    if(arr[i-1][j-1]>=arr[i-1][j]){
                        arr[i][j]+=arr[i-1][j-1];
                    }
                    if(arr[i-1][j-1]<arr[i-1][j]){
                        arr[i][j]+=arr[i-1][j];
                    }
                }
            }
        }
        
        for(int i=0; i<N; i++){
            answer=Math.max(answer,arr[N-1][i]);
        }
        System.out.println(answer);
    }
}