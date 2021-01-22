import java.util.*;

class Dot{
    int x;
    int y;
    public Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main{
    static int[] xx={-1,1,0,0};
    static int[] yy={0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M=sc.nextInt();
        int N=sc.nextInt();
        int K=sc.nextInt();
        //int count=0;
        int[][] map = new int[M][N];
        boolean[][] check = new boolean[M][N];
        for(int i=0; i<K; i++){
            int starty=sc.nextInt();
            int startx=sc.nextInt();
            int endy=sc.nextInt();
            int endx=sc.nextInt();
            for(int j=startx; j<endx; j++){
                for(int z=starty; z<endy; z++){
                    map[j][z]=1;
                }
            }
        }
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                int size=0;
                if(map[i][j]==0 && !check[i][j]){
                    Queue<Dot> qu = new LinkedList<>();
                    qu.add(new Dot(i,j));
                    check[i][j]=true;
                    while(!qu.isEmpty()){
                        Dot tmp = qu.poll();
                        size++;
                        for(int u=0; u<4; u++){
                            int tmpx = tmp.x+xx[u];
                            int tmpy = tmp.y+yy[u];
                            if(tmpx>=0 && tmpx<M && tmpy>=0 && tmpy<N){
                                if(!check[tmpx][tmpy] && map[tmpx][tmpy]==0){
                                    qu.add(new Dot(tmpx,tmpy));
                                    check[tmpx][tmpy]=true;
                                }
                            }
                        }
                    }
                    ar.add(size);
                }
            }
        }
        Collections.sort(ar);
        System.out.println(ar.size());
        for(int i=0; i<ar.size(); i++){
            System.out.printf("%d ",ar.get(i));
        }
    }
}