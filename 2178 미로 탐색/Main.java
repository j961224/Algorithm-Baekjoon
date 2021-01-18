import java.util.*;
class Dot{
    int x;
    int y;
    int cnt;
    public Dot(int x, int y, int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}

public class Main{
    public static int[] xx = {-1,1,0,0};
    public static int[] yy = {0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int answer=10000;
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrx = new int[row][col];
        boolean[][] check = new boolean[row][col];
        for(int i=0; i<row; i++){
            String temp = sc.next();
            for(int j=0; j<col; j++){
                matrx[i][j]=temp.charAt(j)-48;
            }
        }
        
        Queue<Dot> qu = new LinkedList<>();
        qu.add(new Dot(0,0,1));
        check[0][0]=true;
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            if(tmp.x==row-1 && tmp.y==col-1){
                if(answer>tmp.cnt){
                    answer=tmp.cnt;
                }
            }
            
            for(int i=0; i<4; i++){
                int tmpxx=tmp.x+xx[i];
                int tmpyy=tmp.y+yy[i];
                if(tmpxx>=0 && tmpxx<row && tmpyy>=0 && tmpyy<col){
                    if(matrx[tmpxx][tmpyy]==1 && !check[tmpxx][tmpyy]){
                        qu.add(new Dot(tmpxx,tmpyy,tmp.cnt+1));
                        check[tmpxx][tmpyy]=true;
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}