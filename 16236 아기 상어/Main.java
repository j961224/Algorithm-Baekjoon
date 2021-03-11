import java.util.*;

class fish{
    int x;
    int y;
    int distance;
    fish(int x, int y,int distance){
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
}

class Main{
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        
        int sx=0;
        int sy=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==9){
                    sx=i;
                    sy=j;
                    arr[i][j]=0;
                }
            }
        }
        
        int size=2;
        int cnt=0;
        int time=0;
        
        while(true){
            ArrayList<fish> eatfish = new ArrayList<>();
            Queue<fish> shark = new LinkedList<>();
            boolean[][] check = new boolean[N][N];
            
            shark.add(new fish(sx,sy,0));
            check[sx][sy]=true;
            
            while(!shark.isEmpty()){
                fish tmp = shark.poll();
                
                for(int i=0; i<4; i++){
                    int tmpx = xx[i]+tmp.x;
                    int tmpy = yy[i]+tmp.y;
                    if(0<=tmpx && tmpx<N && 0<=tmpy && tmpy<N){
                        if(!check[tmpx][tmpy]){
                            if(size>arr[tmpx][tmpy] && 0<arr[tmpx][tmpy]){
                                shark.add(new fish(tmpx,tmpy,tmp.distance+1));
                                eatfish.add(new fish(tmpx,tmpy,tmp.distance+1));
                                check[tmpx][tmpy]=true;
                            }
                            
                            else if(0==arr[tmpx][tmpy] || size==arr[tmpx][tmpy]){
                                shark.add(new fish(tmpx,tmpy,tmp.distance+1));
                                check[tmpx][tmpy]=true;
                            }
                        }
                    }
                }
            }
            
            if(eatfish.size()==0){
                break;
            }
            
            //어느 물고기를 먹을지 결정 -> 가까운 거리 -> 같다면 위->왼쪽
            fish finalfish = eatfish.get(0); //먹을 물고기 저장
            for(int i=1; i<eatfish.size(); i++){
                fish tmp2 = eatfish.get(i);
                if(finalfish.distance>tmp2.distance){
                    finalfish=tmp2;
                }
                else if(finalfish.distance==tmp2.distance){
                    if(finalfish.x>tmp2.x){
                        finalfish=tmp2;
                    }
                    else if(finalfish.x==tmp2.x){
                        if(finalfish.y>tmp2.y){
                            finalfish=tmp2;
                        }
                    }
                }
            }
            
            cnt++;
            time+=finalfish.distance;
            if(cnt==size){
                size++;
                cnt=0;
            }
            arr[finalfish.x][finalfish.y]=0;
            sx=finalfish.x;
            sy=finalfish.y;
        }
        
        
        System.out.println(time);
    }
}