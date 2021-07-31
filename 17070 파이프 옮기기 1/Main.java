import java.util.*;


class Main{
    static int N;
    static int[][] pipe;
    static int count;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        pipe = new int[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                pipe[i][j]=sc.nextInt();
            }
        }
        
        dfs(0,1,0);
        
        System.out.println(count);
    }
    
    public static void dfs(int x, int y, int dir){
        if(x==N-1 && y==N-1 && pipe[x][y]==0){
            count+=1;
            return;
        }
        //가로인 경우!
        if(dir==0){
            //거기서 또 가로로 가는 경우
            if(x>=0 && y+1>=0 && x<N && y+1<N && pipe[x][y+1]==0){
                dfs(x,y+1,0);
            }
            //거기서 대각선으로 갈 경우
            if(x+1>=0 && y+1>=0 && x+1<N && y+1<N && pipe[x][y+1]==0 && pipe[x+1][y+1]==0 && pipe[x+1][y]==0){
                dfs(x+1,y+1,2);
            }
        }
        
        //세로인 경우
        else if(dir==1){
            //거기서 또 세로로 가는 경우
            if(x+1>=0 && y>=0 && x+1<N && y<N && pipe[x+1][y]==0){
                dfs(x+1,y,1);
            }
            //거기서 대각선으로 갈 경우
            if(x+1>=0 && y+1>=0 && x+1<N && y+1<N && pipe[x][y+1]==0 && pipe[x+1][y+1]==0 && pipe[x+1][y]==0){
                dfs(x+1,y+1,2);
            }
        }
        
        //대각선인 경우
        else if(dir==2){
            //거기서 또 대각선으로 갈 경우
            if(x+1>=0 && y+1>=0 && x+1<N && y+1<N && pipe[x][y+1]==0 && pipe[x+1][y+1]==0 && pipe[x+1][y]==0){
                dfs(x+1,y+1,2);
            }
            //거기서 가로로 가는 경우
            if(x>=0 && y+1>=0 && x<N && y+1<N && pipe[x][y+1]==0){
                dfs(x,y+1,0);
            }
            //거기서 세로로 가는 경우
            if(x+1>=0 && y>=0 && x+1<N && y<N && pipe[x+1][y]==0){
                dfs(x+1,y,1);
            }
        }
    }
}