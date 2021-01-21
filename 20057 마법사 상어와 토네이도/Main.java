import java.util.*;

class Main{
    static int[] xx = {0,1,0,-1};
    static int[] yy = {-1,0,1,0};
    static int[][] map;
    static int N, size;
    static int answer=0;
    static int count =0;
    static int position=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        map= new int[N+2][N+2]; // 크기 1 padding
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                map[i][j]=sc.nextInt();
            }
        }
        //count = 0; //크기 변하는거 체크 -> 끝나면 계속 플러스(straight에서)
        //position=0; //회전 4가 되면 다시 0으로 고쳐주기 위해서 -> 끝나면 계속 플러스(straight에서)
        size=0; // 토네이도 회전 안 하고 직진 크기
        rotate(N/2+1,N/2+1);
        
        for(int i=0; i<N+2; i++){
            answer+=map[0][i];
            answer+=map[N+1][i];
        }
        for(int i=1; i<N+1; i++){
            answer+=map[i][0];
            answer+=map[i][N+1];
        }
        System.out.println(answer);
    }
    
    //회전 체크
    public static void rotate(int x, int y){
        if(position==4){
            position=0;
        }
        if(count%2==0){
            size++;
        }
        straight(x,y);
    }
    
    //직진 횟수대로 직진(중간에 목표지 오면 멈춰야함)
    public static void straight(int x, int y){
        for(int i=0; i<size; i++){
            int tmpx = x+xx[position];
            int tmpy = y+yy[position];
            x=tmpx;
            y=tmpy;
            spliting(x,y);
            if(x==1 && y==1){
                return;
            }
        }
        position++;
        count++;
        rotate(x,y);
    }
    
    //퍼지는 확률로 모래알 카운트
    public static void spliting(int x, int y){
        int now = map[x][y];
        map[x][y]=0;
        if(position==0){
            map[x-1][y-1]+=(int)(now*0.1);
            map[x-1][y]+=(int)(now*0.07); 
            map[x-1][y+1]+=(int)(now*0.01);
            map[x][y-1]+=(now-2*((int)(now*0.01)+(int)(now*0.02)+(int)(now*0.07)+(int)(now*0.1))-(int)(now*0.05));
            map[x+1][y-1]+=(int)(now*0.1);
            map[x+1][y]+=(int)(now*0.07); 
            map[x+1][y+1]+=(int)(now*0.01);
            if(y-2<0){
                map[x][0]+=(int)(now*0.05);
            }
            if(y-2>=0){
                map[x][y-2]+=(int)(now*0.05);
            }
            if(x-2<0){
                map[0][y]+=(int)(now*0.02); 
            }
            if(x-2>=0){
                map[x-2][y]+=(int)(now*0.02);
            }
            if(x+2>N+1){
                map[N+1][y]+=(int)(now*0.02);
            }
            if(N+1>=x+2){
                map[x+2][y]+=(int)(now*0.02);
            }
        }
        if(position==1){
            map[x-1][y-1]+=(int)(now*0.01);
            map[x-1][y+1]+=(int)(now*0.01);
            map[x][y-1]+=(int)(now*0.07);
            map[x][y+1]+=(int)(now*0.07);
            map[x+1][y-1]+=(int)(now*0.1);
            map[x+1][y]+=(now-2*((int)(now*0.01)+(int)(now*0.02)+(int)(now*0.07)+(int)(now*0.1))-(int)(now*0.05));
            map[x+1][y+1]+=(int)(now*0.1);
            if(x+2>N+1){
                map[N+1][y]+=(int)(now*0.05);
            }
            if(N+1>=x+2){
                map[x+2][y]+=(int)(now*0.05);
            }
            if(y-2<0){
                map[x][0]+=(int)(now*0.02);
            }
            if(y-2>=0){
                map[x][y-2]+=(int)(now*0.02);
            }
            if(y+2>N+1){
                map[x][N+1]+=(int)(now*0.02);
            }
            if(N+1>=y+2){
                map[x][y+2]+=(int)(now*0.02);
            }
        }
        if(position==2){
            map[x][y+1]+=(now-2*((int)(now*0.01)+(int)(now*0.02)+(int)(now*0.07)+(int)(now*0.1))-(int)(now*0.05));
            map[x-1][y+1]+=(int)(now*0.1);
            map[x+1][y+1]+=(int)(now*0.1);
            map[x-1][y]+=(int)(now*0.07);
            map[x+1][y]+=(int)(now*0.07);
            map[x-1][y-1]+=(int)(now*0.01);
            map[x+1][y-1]+=(int)(now*0.01);
             if(y+2>N+1){
                map[x][N+1]+=(int)(now*0.05);
            }
            if(N+1>=y+2){
                map[x][y+2]+=(int)(now*0.05);
            }
            if(x+2>N+1){
                map[N+1][y]+=(int)(now*0.02);
            }
            if(N+1>=x+2){
                map[x+2][y]+=(int)(now*0.02);
            }
            if(x-2<0){
                map[0][y]+=(int)(now*0.02); 
            }
            if(x-2>=0){
                map[x-2][y]+=(int)(now*0.02);
            }
        }
        if(position==3){
            map[x-1][y]+=(now-2*((int)(now*0.01)+(int)(now*0.02)+(int)(now*0.07)+(int)(now*0.1))-(int)(now*0.05));
            map[x-1][y-1]+=(int)(now*0.1);
            map[x-1][y+1]+=(int)(now*0.1);
            map[x][y-1]+=(int)(now*0.07);
            map[x][y+1]+=(int)(now*0.07);
            map[x+1][y-1]+=(int)(now*0.01);
            map[x+1][y+1]+=(int)(now*0.01);
            if(x-2<0){
                map[0][y]+=(int)(now*0.05); 
            }
            if(x-2>=0){
                map[x-2][y]+=(int)(now*0.05);
            }
            if(y+2>N+1){
                map[x][N+1]+=(int)(now*0.02);
            }
            if(N+1>=y+2){
                map[x][y+2]+=(int)(now*0.02);
            }
            if(y-2<0){
                map[x][0]+=(int)(now*0.02); 
            }
            if(y-2>=0){
                map[x][y-2]+=(int)(now*0.02);
            }
        }
    }
}