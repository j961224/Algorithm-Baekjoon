import java.util.*;

class Dot{
    int x;
    int y;
    int cost;
    public Dot(int x, int y, int cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }
}

public class Main
{
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
	public static void main(String[] args) {
	    int answer=-1;
	    Scanner sc = new Scanner(System.in);
	    
	    int N = sc.nextInt();
	    int M = sc.nextInt();
	    
	    int[][] arr = new int[M][N];
	    boolean[][] checker = new boolean[M][N];
	    Queue<Dot> qu = new LinkedList<>();
	    
	    for(int i=0; i<M; i++){
	        for(int j=0; j<N; j++){
	            arr[i][j]=sc.nextInt();
	            else if(arr[i][j]==1){
	                qu.add(new Dot(i,j,0));
	                checker[i][j]=true;
	            }
	        }
	    }
	    
	   
	    while(!qu.isEmpty()){
	        Dot tmp = qu.poll();
	        boolean check = false;
	        answer=tmp.cost;
	        
	        
	        for(int i=0; i<4; i++){
	            int tmpx = tmp.x+xx[i];
	            int tmpy = tmp.y+yy[i];
	            if(tmpx>=0 && tmpx<M && tmpy>=0 && tmpy<N){
	                if(!checker[tmpx][tmpy] && arr[tmpx][tmpy]!=-1){
	                    checker[tmpx][tmpy]=true;
	                    arr[tmpx][tmpy]=1;
	                    qu.add(new Dot(tmpx,tmpy,tmp.cost+1));
	                }
	            }
	        }
	    }
	    
	    for(int i=0; i<M; i++){
	        for(int j=0; j<N; j++){
	            if(arr[i][j]==0){
	                answer=-1;
	            }
	        }
	    }
	    System.out.println(answer);
	}
}