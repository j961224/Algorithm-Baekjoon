import java.util.*;

class Dot{
    int x;
    int y;
    public Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main
{
    static int[] xx = {-1,1,0,0,1,1,-1,-1};
    static int[] yy = {0,0,1,-1,1,-1,-1,1};
    static int[][] arr;
    static boolean[][] check;
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int M = sc.nextInt();
	    
	    arr = new int[N][M];
	    check = new boolean[N][M];
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            arr[i][j]=sc.nextInt();
	        }
	    }
	    int area=0;
		

		for(int i=0; i<N; i++){
		    for(int j=0; j<M; j++){
		        if(!check[i][j]){
		            Queue<Dot> qu = new LinkedList<>();
		            check[i][j]=true;
		            boolean real_check = true;
		            qu.add(new Dot(i,j));
		            int peak = arr[i][j];
		            while(!qu.isEmpty()){
		                Dot tmp = qu.poll();
		                for(int z=0; z<8; z++){
		                    int tmpx = tmp.x+xx[z];
		                    int tmpy = tmp.y+yy[z];
		                    if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<M){
		                        if(arr[tmpx][tmpy]>peak){
		                            real_check=false;
		                        }
		                        if(!check[tmpx][tmpy] && arr[tmpx][tmpy]==peak){
		                            check[tmpx][tmpy]=true;
		                            qu.add(new Dot(tmpx,tmpy));
		                        }
		                    }
		                }
		            }
		            if(real_check && peak>0){
		                area+=1;
		            }
		        }
		    }
		}
		
		System.out.println(area);
	}
}
