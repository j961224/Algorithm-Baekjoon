import java.util.*;


class Main{
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    static int N,M;
    static String[][] arr;
    static boolean[][] check;
    static int[][] dp;
    static int answer;
    static boolean inf=false;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new String[N][M];
        check = new boolean[N][M];
        dp = new int[N][M];
        sc.nextLine();
        for(int i=0; i<N; i++){
            String tmp = sc.nextLine();
            for(int j=0; j<M; j++){
                arr[i][j]=tmp.substring(j,j+1);
            }
        }
        answer=0;
        
        DFS(0,0,1);
        
        if(inf){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }
    
    public static void DFS(int x, int y, int cost){
        answer = Math.max(answer,cost);
        check[x][y]=true;
        dp[x][y]=cost;
        for(int i=0; i<4; i++){
            int tmpx = x+xx[i]*Integer.parseInt(arr[x][y]);
            int tmpy = y+yy[i]*Integer.parseInt(arr[x][y]);
            if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<M && !inf){
                if(!arr[tmpx][tmpy].equals("H")){
                    if(check[tmpx][tmpy]){
                        inf=true;
                        return;
                    }
                    if(dp[tmpx][tmpy]<=cost){
                        DFS(tmpx,tmpy,cost+1);
                        check[tmpx][tmpy]=false;
                    }
                }
            }
        }
    }
}