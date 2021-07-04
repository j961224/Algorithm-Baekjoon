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
    
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int endx=0;
        int endy=0;
        Queue<Dot> qu = new LinkedList<>();
        Queue<Dot> water = new LinkedList<>();
        sc.nextLine();
        String[][] arr = new String[R][C];
        for(int i=0; i<R; i++){
            String tmp = sc.nextLine();
            for(int j=0; j<C; j++){
                arr[i][j]=tmp.substring(j,j+1);
                if(arr[i][j].equals("S")){
                    qu.add(new Dot(i,j));
                }
                else if(arr[i][j].equals("*")){
                    water.add(new Dot(i,j));
                }
                else if(arr[i][j].equals("D")){
                    endx=i;
                    endy=j;
                }
            }
        }
        
        int[][] distance = new int[R][C];
        
        
        while(!qu.isEmpty()){
            int size = water.size();
            while(true){
                if(size==0){
                    break;
                }
                Dot tmp = water.poll();
                for(int i=0; i<4; i++){
                    int tmpx = xx[i]+tmp.x;
                    int tmpy = yy[i]+tmp.y;
                    if(tmpx>=0 && tmpx<R && tmpy>=0 && tmpy<C){
                        if(arr[tmpx][tmpy].equals(".") || arr[tmpx][tmpy].equals("S")){
                            arr[tmpx][tmpy]="*";
                            water.add(new Dot(tmpx,tmpy));
                        }
                    }
                }
                size--;
            }
            
            size = qu.size();
            while(true){
                if(size==0){
                    break;
                }
                Dot tmp = qu.poll();
                
                for(int i=0; i<4; i++){
                    int tmpx = xx[i]+tmp.x;
                    int tmpy = yy[i]+tmp.y;
                    if(tmpx>=0 && tmpx<R && tmpy>=0 && tmpy<C){
                        if(!arr[tmpx][tmpy].equals("*") && !arr[tmpx][tmpy].equals("X")){
                            if(distance[tmpx][tmpy]==0){
                                distance[tmpx][tmpy]=distance[tmp.x][tmp.y]+1;
                                qu.add(new Dot(tmpx,tmpy));
                            }
                        }
                    }
                }
                size--;
            }
        }
        
        if(distance[endx][endy]!=0){
            System.out.println(Integer.toString(distance[endx][endy]));
        }
        else{
            System.out.println("KAKTUS");
        }
    }
}