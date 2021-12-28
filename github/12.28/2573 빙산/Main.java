import java.util.*;
// 처음에 DFS(얼음 몇 덩이인지 확인) + 얼음 녹이기로 했지만 시간초과
// 두 번째, DFS(얼음 몇 덩이인지 확인) + BFS(얼음 녹이기) 시간초과
// 세 번째, 빙하가 아예 없는 경우를 확인 필요! -> 0 출력!

// 그냥 첫 번째 시도에 세 번째 시도를 추가했어도 시간초과가 나지 않았을 것 같다!

class Dot{
    int x;
    int y;
    public Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main{
    static int N,M;
    static int[][] board;
    static int answer;
    static boolean[][] check;
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N=sc.nextInt();
        M=sc.nextInt();
        board = new int[N][M];
        answer = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                board[i][j]=sc.nextInt();
            }
        }
        
        while(true){
            check = new boolean[N][M];
            int is_part = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(!check[i][j] && board[i][j]!=0){
                        dfs(i,j);
                        is_part+=1;
                    }
                }
                if(is_part>=2){
                    break;
                }
            }
            if(is_part>=2){
                break;
            }
            if(is_part==0){
                answer=0;
                break;
            }
            else{
                answer+=1;
            }
            Meltdown();
        }
        
        System.out.println(answer);
    }
    
    public static void dfs(int x, int y){
        check[x][y]=true;
        for(int i=0; i<4; i++){
            int tmpx = xx[i]+x;
            int tmpy = yy[i]+y;
            if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<M && !check[tmpx][tmpy] && board[tmpx][tmpy]!=0){
                dfs(tmpx,tmpy);
            }
        }
    }
    
    public static void Meltdown(){
        Queue<Dot> qu = new LinkedList<>();
        boolean[][] meltcheck = new boolean[N][M];
        
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]!=0){
                    meltcheck[i][j]=true;
                    qu.add(new Dot(i,j));
                }
            }
        }
        
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            int count = 0;
            for(int i=0; i<4; i++){
                int tmpx = tmp.x+xx[i];
                int tmpy = tmp.y+yy[i];
                if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<M && !meltcheck[tmpx][tmpy] && board[tmpx][tmpy]==0){
                    count+=1;
                }
            }
            
            if(board[tmp.x][tmp.y]-count>=0){
                board[tmp.x][tmp.y]-=count;
            }
            else{
                board[tmp.x][tmp.y]=0;
            }
        }
    }
}