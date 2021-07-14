import java.util.*;


class Ghost{
    int x;
    int y;
    int x1;
    int y1;
    int cost;
    public Ghost(int x, int y, int x1, int y1, int cost){
        this.x=x;
        this.y=y;
        this.x1=x1;
        this.y1=y1;
        this.cost=cost;
    }
}

class Main{
    static int W,H,G,E;
    static int[][] park; // 묘지 상태
    static ArrayList<Ghost> ar; //모든 이동 edge
    static long[][] dist; //각 egde distance
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    static boolean Never;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            W=sc.nextInt();
            H=sc.nextInt();
            if(W==0 && H==0){
                break;
            }
            Never=false;
            park = new int[W][H];
            ar = new ArrayList<>();
            dist = new long[W][H];
            
            G=sc.nextInt();
            for(int i=0; i<G; i++){
                park[sc.nextInt()][sc.nextInt()]=-1; //묘비는 -1로 표시
            }
            
            E=sc.nextInt();
            for(int i=0; i<E; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int cost = sc.nextInt();
                park[x][y]=1; //귀신 구멍인 1로 표시
                ar.add(new Ghost(x,y,x1,y1,cost));
            }
            
            //움직일 수 있는 경우 다 넣기
            for(int i=0; i<W; i++){
                for(int j=0; j<H; j++){
                    if(park[i][j]!=0){
                        continue;
                    }
                    if(i==W-1 && j==H-1){
                        continue;
                    }
                    for(int z=0; z<4; z++){
                        int tmpx = i+xx[z];
                        int tmpy = j+yy[z];
                        //묘비만 아니면 다 이동이 가능하므로 -1만 제외
                        if(tmpx>=0 && tmpx<W && tmpy>=0 && tmpy<H && park[tmpx][tmpy]!=-1){
                            ar.add(new Ghost(i,j,tmpx,tmpy,1));
                        }
                    }
                }
            }
            
            for(int i=0; i<W; i++){
                for(int j=0; j<H; j++){
                    //벨만포드 시작 전 거리 배열인 dist를 큰 값으로 초기화
                    dist[i][j]=Long.MAX_VALUE;
                }
            }
            
            bellmanFord(0,0);
            if(Never){
                System.out.println("Never");
            }
            else if(dist[W-1][H-1]==Long.MAX_VALUE){
                System.out.println("Impossible");
            }
            else{
                System.out.println(dist[W-1][H-1]);
            }
        }
    }
    
    public static void bellmanFord(int x, int y){
        dist[x][y]=0;
        
        //벨만포드 횟수는 묘지 크기인 H*W에 묘비는 제외시켜야 하므로 H*W-G로 설정한다.
        for(int i=0; i<=H*W-G; i++){
            for(Ghost z : ar){
                if(dist[z.x][z.y] != Long.MAX_VALUE && dist[z.x1][z.y1]>dist[z.x][z.y]+z.cost){
                    dist[z.x1][z.y1]=dist[z.x][z.y]+z.cost;
                    if(i==H*W-G){
                        Never=true;
                    }
                }
            }
        }
        
    }
}