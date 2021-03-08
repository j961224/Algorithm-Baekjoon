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
    static int[] xx={-1,1,0,0};
    static int[] yy={0,0,-1,1};
    static boolean[][] check;
    static char[][] array;
    static int N;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        sc.nextLine();
        array = new char[N][N];
        check = new boolean[N][N];
        for(int i=0;i<N;i++) {
            String s = sc.nextLine();
            for(int j=0;j<N;j++) {
                array[i][j]=s.charAt(j);
            }
        }
        
        int nodrug=0;
        int drug=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!check[i][j]){
                    nodrug++;
                    dfs(i,j,array[i][j]);
                }
            }
        }
        
        check=new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(array[i][j]=='R'){
                    array[i][j]='G';
                }
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!check[i][j]){
                    drug++;
                    dfs(i,j,array[i][j]);
                }
            }
        }
        
        System.out.printf("%d %d",nodrug,drug);
    }
    
    public static void dfs(int x, int y,char k){
        if(check[x][y]){
            return;
        }
        
        check[x][y]=true;
        for(int i=0; i<4; i++){
            int x1 = xx[i]+x;
            int y1 = yy[i]+y;
            if(0<=x1 && x1<N && 0<=y1 && y1<N){
                if(!check[x1][y1] && k==array[x1][y1]){
                    dfs(x1,y1,k);
                }
            }
        }
    }
    
}