import java.util.*;

class Dot{
    int x;
    int y;
    public Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
}

//고도가 1000000보다 작은 자연수이므로 크기 차이가 꽤 있을 것으로 보아
//이분탐색과 BFS를 함께 생각
class Main{
    static int answer = 1000000;
    static char[][] go;
    static int[][] high;
    static Dot here;
    static int house,N;
    static int[] xx = {-1,1,0,0,1,1,-1,-1};
    static int[] yy = {0,0,1,-1,-1,1,1,-1};
    static ArrayList<Integer> cost;
    static boolean[][] check;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        go = new char[N][N];
        high = new int[N][N];
        house=0;
        for(int i=0; i<N; i++){
            String tmp = sc.nextLine();
            for(int j=0; j<N; j++){
                go[i][j] = tmp.charAt(j);
                if(go[i][j]=='P'){
                    here = new Dot(i,j);
                }
                else if(go[i][j]=='K'){
                    house+=1;
                }
            }
        }
        
        cost = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                high[i][j]=sc.nextInt();
                if(!cost.contains(high[i][j])){
                    cost.add(high[i][j]);
                }
            }
        }
        
        Collections.sort(cost);
        BFS();
    }
    
    public static void BFS(){
        int low=0;
        int higher = 0;
        while(low<=higher && higher<cost.size()){
            check = new boolean[N][N];
            Queue<Dot> qu = new LinkedList<>();
            
            int c = high[here.x][here.y];
            if(cost.get(low)<=c && c<=cost.get(higher)){
                qu.add(here);
                check[here.x][here.y]=true;
            }
            int cc  = 0;
            while(!qu.isEmpty()){
                Dot tmp = qu.poll();
                if(go[tmp.x][tmp.y]=='K'){
                    cc+=1;
                }
                
                for(int i=0; i<8; i++){
                    int tmpx = tmp.x+xx[i];
                    int tmpy = tmp.y+yy[i];
                    if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<N){
                        if(!check[tmpx][tmpy]){
                            int co = high[tmpx][tmpy];
                            if(cost.get(low)<=co && co<=cost.get(higher)){
                                check[tmpx][tmpy]=true;
                                qu.add(new Dot(tmpx,tmpy));
                            }
                        }
                    }
                }
            }
            
            //모든 곳을 다 방문했다면 더 줄일 수 있는지 확인해보기 위해 low+1해준다.
            if(cc == house){
                answer = Math.min(answer,cost.get(higher)-cost.get(low));
                low+=1;
            }
            //다 방문을 하지 못 했다면 범위를 더 늘려 경우의 수를 더 주기 위해 high+1을 한다.
            else{
                //cost arraylist 안에서 찾으므로 넘어선 안 된다.
                if(higher+1<cost.size()){
                    higher+=1;
                }
                else{
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}