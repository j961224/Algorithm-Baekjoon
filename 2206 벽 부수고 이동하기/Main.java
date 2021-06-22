import java.util.*;
//보통 이런 똑같은 위치 여러번 방문할 때, 최솟값만 가져가도록 한다.
//check를 boolean해주지 않고 int로 해준다. -> 갱신해나가는 방법

//똑같은 길에 벽을 부수고 온 쪽과 벽을 부수지 않고 온 쪽이 온다면 안 부수고 온 쪽을 기준으로 한다.
class Dot{
    int x;
    int y;
    int cost;
    int possible;
    public Dot(int x, int y, int cost, int possible){
        this.x=x;
        this.y=y;
        this.cost=cost;
        this.possible=possible;
    }
}


class Main{
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer=-1;
        int[][] arr = new int[N][M];
        int[][] check = new int[N][M];
        sc.nextLine();
        for(int i=0; i<N; i++){
            String k = sc.nextLine();
            String[] k1 = k.split("");
            for(int j=0; j<M; j++){
                arr[i][j]=Integer.parseInt(k1[j]);
                check[i][j]=Integer.MAX_VALUE;
            }
        }
        
        Queue<Dot> qu = new LinkedList<>();
        qu.add(new Dot(0,0,1,0));
        
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            if(tmp.x==N-1 && tmp.y==M-1){
                if(answer==-1){
                    answer=tmp.cost;
                }
                else{
                    answer = Math.min(answer,tmp.cost);
                }
                break;
            }
            
            for(int i=0; i<4; i++){
                int tmpx = tmp.x+xx[i];
                int tmpy = tmp.y+yy[i];
                if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<M){
                    if(check[tmpx][tmpy]>tmp.possible){
                        if(arr[tmpx][tmpy]==1){
                            if(tmp.possible==0){
                                check[tmpx][tmpy]=1;
                                qu.add(new Dot(tmpx,tmpy,tmp.cost+1,1));
                            }
                        }
                        
                        else if(arr[tmpx][tmpy]==0){
                            check[tmpx][tmpy]=tmp.possible;
                            qu.add(new Dot(tmpx,tmpy,tmp.cost+1,tmp.possible));
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}