import java.util.*;
class Dot{
    int x;
    int y;
    Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main{
    static int[] xx={0,0,1,1,1,-1,-1,-1};
    static int[] yy={1,-1,0,-1,1,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        
        boolean[][] check = new boolean[N][M];
        int[][] distance = new int[N][M];
        Queue<Dot> qu = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(sc.nextInt()==1){
                    check[i][j]=true;
                    qu.add(new Dot(i,j));
                }
                else{
                    distance[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        
        int max=0;
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            
            for(int i=0; i<8; i++){
                int tmpx=tmp.x+xx[i];
                int tmpy=tmp.y+yy[i];
                
                if(0<=tmpx && tmpx<N && 0<=tmpy && tmpy<M){
                    if(distance[tmpx][tmpy]>distance[tmp.x][tmp.y]+1){
                        distance[tmpx][tmpy]=distance[tmp.x][tmp.y]+1;
                        qu.add(new Dot(tmpx,tmpy));
                        max=Math.max(max,distance[tmpx][tmpy]);
                    }
                }
            }
        }
        
        System.out.println(max);
    }
}