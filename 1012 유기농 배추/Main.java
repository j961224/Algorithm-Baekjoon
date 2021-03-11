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
    static int[] xx={-1,1,0,0};
    static int[] yy={0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int[] answer = new int[T];
        for(int i=0; i<T; i++){
            int M=sc.nextInt();
            int N=sc.nextInt();
            int K=sc.nextInt();
            
            int[][] arr = new int[N][M];
            
            for(int j=0; j<K; j++){
                int Y=sc.nextInt();
                int X=sc.nextInt();
                arr[X][Y]=1;
            }
            
            
            boolean[][] check = new boolean[N][M];
            for(int a=0; a<N; a++){
                for(int b=0; b<M; b++){
                    if(!check[a][b] && arr[a][b]==1){
                        answer[i]++;
                        Queue<Dot> qu = new LinkedList<>();
                        qu.add(new Dot(a,b));
                        check[a][b]=true;
                        
                        while(!qu.isEmpty()){
                            Dot tmp = qu.poll();
                            
                            for(int c=0; c<4; c++){
                                int tmpx=xx[c]+tmp.x;
                                int tmpy=yy[c]+tmp.y;
                                if(0<=tmpx && tmpx<N && 0<=tmpy && tmpy<M){
                                    if(!check[tmpx][tmpy] && arr[tmpx][tmpy]==1){
                                        qu.add(new Dot(tmpx,tmpy));
                                        check[tmpx][tmpy]=true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        
        }
        
        for(int k : answer){
                System.out.println(k);
        }
    }
}