import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][] distance=new boolean[N+1][N+1];
        int[][] result = new int[M][2];
        int[] results = new int[N+1];
        
        for(int i=0; i<M; i++){
            result[i][0]=sc.nextInt();
            result[i][1]=sc.nextInt();
        }
        
        for(int i=0; i<result.length; i++){
            distance[result[i][0]][result[i][1]]=true;
        }//현재로 존재하는 경로 true로
        
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                for(int k=1; k<N+1; k++){
                    if(distance[j][i] && distance[i][k]){
                        distance[j][k]=true;
                    }
                }
            }
        }
        
        for(int i=1; i<N+1; i++){
            int check=0;
            for(int j=1; j<N+1; j++){
                if(i==j) continue;
                if(!distance[i][j] && !distance[j][i]){
                    check++;
                }
            }
            results[i]=check;
        }
        
        for(int i=1; i<N+1; i++){
            System.out.println(results[i]);
        }
    }
}