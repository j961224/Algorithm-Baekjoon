import java.util.*;

class Dot{
    int x;
    int y;
    public Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main{
    static int n, map[][], size, sum;
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int cnt = sc.nextInt();
        size = (int)Math.pow(2,n);
        map = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                map[i][j]=sc.nextInt();
            }
        }
        
        for(int i=0; i<cnt; i++){
            int k = sc.nextInt();
            rotate(k);
            meltdown();
        }
        
        boolean[][] check = new boolean[size][size];
        int maxice = 0;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(!check[i][j] && map[i][j]>0){
                    check[i][j]=true;
                    maxice = Math.max(maxice,sol(i,j,check));
                }
            }
        }
        
        System.out.println(sum);
        System.out.println(maxice);
    }
    
    public static void rotate(int k){
        int loop = size/(int)Math.pow(2,k);
        int[][] next = new int[size][size];
        
        int x=0;
        int z = (int)Math.pow(2,k);
        for(int i=0; i<loop; i++){
            int y=0;
            if(i!=0){
                x+=z;
            }
            for(int j=0; j<loop; j++){
                if(j!=0){
                    y+=z;
                }
                for(int a=0; a<z; a++){
                    for(int b=0; b<z; b++){
                        next[x+b][y-a+z-1]=map[x+a][y+b];
                    }
                }
            }
        }
        map=next;
    }
    
    public static void meltdown(){
        Queue<Dot> qu = new LinkedList<>();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                int cnt = 0;
                for(int k=0; k<4; k++){
                    int xx1 = i+xx[k];
                    int yy1 = j+yy[k];
                    if(xx1>=0 && xx1<size && yy1>=0 && yy1<size){
                        if(map[xx1][yy1]>0){
                            cnt++;
                        }
                    }
                }
                if(cnt<3){
                    qu.offer(new Dot(i,j));
                }
            }
        }
        
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            map[tmp.x][tmp.y]--;
        }
    }
    
    public static int sol(int i, int j, boolean[][] check){
        int count = 1;
        sum += map[i][j];
        
        for(int a=0; a<4; a++){
            int xx1 = xx[a]+i;
            int yy1 = yy[a]+j;
            if(xx1>=0 && xx1<size && yy1>=0 && yy1<size && map[xx1][yy1]>0 && !check[xx1][yy1]){
                check[xx1][yy1]=true;
                count+=sol(xx1,yy1,check);
            }
        }
        
        return count;
    }
}