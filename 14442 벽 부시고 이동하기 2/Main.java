import java.util.*;
import java.io.*;



public class Main{
    static class Dot{
        int x;
        int y;
        int cost;
        int possible;
        Dot(int x, int y, int cost, int possible){
            this.x=x;
            this.y=y;
            this.cost=cost;
            this.possible=possible;
        }
    }
    
    static int[][] arr;
    static int N,M,K;
    static boolean[][][] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        
        arr = new int[N][M];
        check = new boolean[N][M][K+1];
        
        
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j]=str.charAt(j) - '0';
            }
        }
        
        
        bw.write(bfs() + "\n");
		bw.flush();
    }
    
    public static int bfs(){
        int[] xx = {-1,1,0,0};
        int[] yy = {0,0,1,-1};
        Queue<Dot> qu = new LinkedList<>();
        qu.add(new Dot(0,0,1,0));
        check[0][0][0]=true;
        
        while(!qu.isEmpty()){
            Dot temp = qu.poll();
            if(temp.x==N-1 && temp.y==M-1){
                return temp.cost;
            }
            
            for(int i=0; i<4; i++){
                int tmpx = temp.x+xx[i];
                int tmpy = temp.y+yy[i];
                if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<M){
                    if(arr[tmpx][tmpy]==1 && temp.possible<K && !check[tmpx][tmpy][temp.possible+1]){
                        check[tmpx][tmpy][temp.possible+1]=true;
                        qu.add(new Dot(tmpx,tmpy,temp.cost+1,temp.possible+1));
                    }
                        
                    else if(arr[tmpx][tmpy]==0 && !check[tmpx][tmpy][temp.possible]){
                        check[tmpx][tmpy][temp.possible]=true;
                        qu.add(new Dot(tmpx,tmpy,temp.cost+1,temp.possible));
                    }
                }
            }
        }
        return -1;
    }
}