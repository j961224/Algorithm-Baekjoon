import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Dot implements Comparable<Dot>{
    int x;
    int y;
    int cost;
    Dot(int x, int y, int cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }
    @Override
    public int compareTo(Dot o) {
        return cost - o.cost;
    }
}

class Main{
    static int[] xx={-1,1,0,0};
    static int[] yy={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size = br.readLine();
 
        StringTokenizer st = new StringTokenizer(size);
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N][M];
        boolean[][] check = new boolean[N][M];
        int answer=Integer.MAX_VALUE;
        
        for (int i = 0; i <N; i++) {
            String input = br.readLine();
            for (int j = 0; j <M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }
        
        PriorityQueue<Dot> qu = new PriorityQueue<>();
        qu.add(new Dot(0,0,0));
        check[0][0]=true;
        
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            if(tmp.x==N-1 && tmp.y==M-1){
                answer=tmp.cost;
                break;
            }
            
            for(int i=0; i<4; i++){
                int x1 = xx[i]+tmp.x;
                int y1 = yy[i]+tmp.y;
                if(0<=x1 && x1<N && 0<=y1 && y1<M){
                    if(!check[x1][y1]){
                        check[x1][y1]=true;
                        qu.add(new Dot(x1,y1,tmp.cost+board[x1][y1]));
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}