import java.util.*;
class Dot{
    int x;
    int y;
    public Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main{
    static int[] xx = {-1,1,0,0,1,-1,1,-1};
    static int[] yy = {0,0,1,-1,-1,-1,1,1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M=sc.nextInt();
        int N=sc.nextInt();
        
        while(N!=0 && M!=0){
        int[][] arr = new int[N][M];
        boolean[][] visited= new boolean[N][M]; 
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int boundary=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    if(arr[i][j]==1){
                        visited[i][j]=true;
                        Queue<Dot> qu = new LinkedList<>();
                        qu.add(new Dot(i,j));
                        while(!qu.isEmpty()){
                            Dot tmp = qu.poll();
                            for(int k=0; k<8; k++){
                                int x1=xx[k]+tmp.x;
                                int y1=yy[k]+tmp.y;
                                if(0<=x1 && x1<N && 0<=y1 && y1<M && arr[x1][y1]==1 && !visited[x1][y1]){
                                    qu.add(new Dot(x1,y1));
                                    visited[x1][y1]=true;
                                }
                            }
                        }
                        boundary++;
                    }
                }
            }
        }
        System.out.println(boundary);
        M=sc.nextInt();
        N=sc.nextInt();
        }
    }
}