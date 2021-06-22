import java.util.*;

class Dot{
    int x;
    int y;
    int h;
    int cost;
    public Dot(int x, int y, int h, int cost){
        this.x=x;
        this.y=y;
        this.h=h;
        this.cost=cost;
    }
}


class Main{
    static int[] xx = {-1,1,0,0,0,0};
    static int[] yy = {0,0,1,-1,0,0};
    static int[] hh = {0,0,0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int answer=0;
        int M = sc.nextInt();
        int N = sc.nextInt();
        int H = sc.nextInt();
        
        int[][][] arr = new int[N][M][H];
        boolean[][][] check = new boolean[N][M][H];
        Queue<Dot> qu = new LinkedList<>();
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    arr[j][k][i]=sc.nextInt();
                    if(arr[j][k][i]==1){
                        qu.add(new Dot(j,k,i,0));
                        check[j][k][i]=true;
                    }
                }
            }
        }
        
        
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            answer = tmp.cost;
            
            for(int i=0; i<6; i++){
                int tmpx = tmp.x+xx[i];
                int tmpy = tmp.y+yy[i];
                int tmph = tmp.h+hh[i];
                if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<M && tmph>=0 && tmph<H){
                    if(!check[tmpx][tmpy][tmph] && arr[tmpx][tmpy][tmph]!=-1){
                        check[tmpx][tmpy][tmph]=true;
                        arr[tmpx][tmpy][tmph]=1;
                        qu.add(new Dot(tmpx,tmpy,tmph,tmp.cost+1));
                    }
                }
            }
        }
        
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(arr[j][k][i]==0){
                        answer=-1;
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}