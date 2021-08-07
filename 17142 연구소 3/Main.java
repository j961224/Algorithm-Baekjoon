import java.util.*;
class virus{
    int x;
    int y;
    int cost;
    public virus(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class virus1{
    int x;
    int y;
    int cost;
    public virus1(int x, int y, int cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }
}

class Main{
    static int[][] inst;
    static int N,M;
    static ArrayList<virus> arr;
    static virus[] realvirus;
    static int answer;
    static int spread;
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        spread = 0;
        inst = new int[N][N];
        arr = new ArrayList<>();
        realvirus = new virus[M];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int tmp = sc.nextInt();
                if(tmp==1){
                    inst[i][j]=1;
                }
                else if(tmp==2){
                    inst[i][j]=2;
                    arr.add(new virus(i,j));
                }
                else if(tmp==0){
                    spread++;
                }
            }
        }
        if(spread==0){
            System.out.println(0);
            return;
        }
        answer = 2501;
        combination(0,0);
        if(answer == 2501){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }
    
    public static void combination(int index, int c){
        if(c==M){
            int z = BFS();
            answer = Math.min(answer,z);
            return;
        }
        
        for(int i=index; i<arr.size(); i++){
            realvirus[c]=arr.get(i);
            combination(i+1,c+1);
        }
    }
    
    public static int BFS(){
        int realcount = spread; //0이 되야 바이러스 모두 전이 완료!
        boolean[][] check = new boolean[N][N];
        Queue<virus1> qu = new LinkedList<>();
        int cc = 2501;
        for(int i=0; i<M; i++){
            check[realvirus[i].x][realvirus[i].y]=true;
            qu.add(new virus1(realvirus[i].x,realvirus[i].y,0));
        }
        
        while(!qu.isEmpty()){
            virus1 tmp = qu.poll();
            
            if(realcount==0){
                cc=tmp.cost;
                break;
            }
            
            for(int i=0; i<4; i++){
                int tmpx = xx[i]+tmp.x;
                int tmpy = yy[i]+tmp.y;
                if(tmpx>=0 && tmpx<N && tmpy>=0 & tmpy<N){
                    if(!check[tmpx][tmpy] && inst[tmpx][tmpy]!=1){
                        if(inst[tmpx][tmpy]==0){
                            realcount--;
                        }
                        if(realcount==0){
                            cc=tmp.cost+1;
                            return cc;
                        }
                        check[tmpx][tmpy]=true;
                        qu.add(new virus1(tmpx,tmpy,tmp.cost+1));
                    }
                }
            }
        }
        
        if(realcount>0){
            return 2501;
        }
        else{
            return cc;
        }
    }
}