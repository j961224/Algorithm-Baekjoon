import java.util.*;
class Dot{
    int x;
    int y;
    int cnt;
    int count;
    Dot(int x, int y,int cnt,int count){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
        this.count=count;
    }
}

class Main{
    static int K,W,H;
    static int[] xx={-1,1,0,0,-2,-1,1,2,-2,-1,1,2};
    static int[] yy={0,0,1,-1,-1,-2,-2,-1,1,2,2,1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        K=sc.nextInt();
        W=sc.nextInt();
        H=sc.nextInt();
        int answer = Integer.MAX_VALUE;
        //3차원 배열 -> 말처럼 이동횟수(말 이동을 쓰면 새롭게 시작)
        boolean[][][] check = new boolean[K+1][H][W];
        int[][] board = new int[H][W];
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                board[i][j]=sc.nextInt();
            }
        }
        
        Queue<Dot> qu = new LinkedList<>();
        qu.add(new Dot(0,0,0,0));
        check[0][0][0]=true;
        
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            if(tmp.x==H-1 && tmp.y==W-1){
                answer=Math.min(answer,tmp.cnt);
                System.out.println(answer);
                return;
            }
            
            else{
            for(int i=0; i<12; i++){
                int tmpx=tmp.x+xx[i];
                int tmpy=tmp.y+yy[i];
                if(tmpx>=0 && tmpx<H && tmpy>=0 && tmpy<W){
                    if(i>=0 && i<=3){
                        if(!check[tmp.count][tmpx][tmpy] && board[tmpx][tmpy] !=1){
                            check[tmp.count][tmpx][tmpy]=true;
                            qu.add(new Dot(tmpx,tmpy,tmp.cnt+1,tmp.count));
                        }                     
                    }
                    if(i>3 && i<=11){
                        if(tmp.count!=K){
                            if(!check[tmp.count+1][tmpx][tmpy] && board[tmpx][tmpy] !=1){
                            check[tmp.count+1][tmpx][tmpy]=true;
                            qu.add(new Dot(tmpx,tmpy,tmp.cnt+1,tmp.count+1));
                            }
                        }
                    }
                }
            }
            }
        }
        
        // if(answer==Integer.MAX_VALUE){
        //     answer=-1;
        // }
        System.out.println(-1);
    }
}