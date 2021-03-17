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
    static int N;
    static int L;
    static int R;
    static int[] xx={-1,1,0,0};
    static int[] yy={0,0,1,-1};
    static int[][] arr;
    static boolean[][] check;
    static ArrayList<Dot> ar;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count=0;
        N=sc.nextInt();
        L=sc.nextInt();
        R=sc.nextInt();
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        
        while(true){
            check=new boolean[N][N];
            if(!isTrue()){
                count++;
            }
            else{
                break;
            }
        }
        
        System.out.println(count);
    }
    
    public static boolean isTrue(){
        boolean istrue=true;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!check[i][j]){
                    ar=new ArrayList<>();
                    ar.add(new Dot(i,j));
                    
                    int total = bfs(i,j);
                    if(ar.size()>1){
                        trans(total);
                        istrue=false;
                    }
                }
            }
        }
        
        return istrue;
    }
    
    public static int bfs(int i, int j){
        check[i][j]=true;
        int sum1 = arr[i][j];
        
        Queue<Dot> qu = new LinkedList<>();
        qu.add(new Dot(i,j));
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            //sum1=Math.max(tmp.sum,sum1);
            for(int z=0; z<4; z++){
                int tmpx=tmp.x+xx[z];
                int tmpy=tmp.y+yy[z];
                
                if(0<=tmpx && tmpx<N && tmpy>=0 && tmpy<N){
                    if(!check[tmpx][tmpy]){
                        if(L<=Math.abs(arr[tmpx][tmpy]-arr[tmp.x][tmp.y]) && Math.abs(arr[tmpx][tmpy]-arr[tmp.x][tmp.y])<=R)
                        {
                            ar.add(new Dot(tmpx,tmpy));
                            qu.add(new Dot(tmpx,tmpy));
                            sum1+=arr[tmpx][tmpy];
                            check[tmpx][tmpy]=true;
                        }
                    }
                }
            }
        }
        
        return sum1;
    }
    
    public static void trans(int sum){
        int average = sum/ar.size();
        for(Dot k : ar){
            arr[k.x][k.y]=average;
        }
    }
    
}