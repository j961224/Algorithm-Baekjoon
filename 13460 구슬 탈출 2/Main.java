import java.util.*;
class Dot {
 
    int Rx;
    int Ry;
    int Bx;
    int By;
    int cost;
 
    Dot(int Rx, int Ry, int Bx, int By, int cost) {
        this.Rx = Rx;
        this.Ry = Ry;
        this.Bx = Bx;
        this.By = By;
        this.cost = cost;
    }
}
class Main {
 
    static int N, M;
    static char[][] arr;
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
 
        arr = new char[N][M];
        boolean[][][][] check = new boolean[10][10][10][10];
        int x=0;
        int y=0;
        int x1=0;
        int y1=0;
        for(int i=0; i<N; i++){
            String str = sc.next();
            for(int j=0; j<M; j++){
                arr[i][j]=str.charAt(j);
                if(arr[i][j]=='R'){
                    x=i;
                    y=j;
                }
                if(arr[i][j]=='B'){
                    x1=i;
                    y1=j;
                }
            }
        }
        
        Queue<Dot> qu = new LinkedList<>();
        qu.offer(new Dot(x,y,x1,y1,0));
        
        while (!qu.isEmpty()) {
 
            Dot tmp = qu.poll();
            check[tmp.Rx][tmp.Ry][tmp.Bx][tmp.By]=true;
            if (tmp.cost >= 10) {
                //System.out.println(-1);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int Bxx = tmp.Bx;
                int Byy = tmp.By;
                int Rxx = tmp.Rx;
                int Ryy = tmp.Ry;
                //먼저 굴리고 겹치게 되면 어느 공이 선인지 판단
                while(arr[Bxx+xx[i]][Byy+yy[i]]!='#'){
                    Bxx+=xx[i];
                    Byy+=yy[i];
                    if(arr[Bxx][Byy]=='O'){
                        break;
                    }
                }
                
                while(arr[Rxx+xx[i]][Ryy+yy[i]]!='#'){
                        Rxx+=xx[i];
                        Ryy+=yy[i];
                        if(arr[Rxx][Ryy]=='O'){
                            break;                            
                        }
                }
                
              
                
                if (arr[Bxx][Byy] == 'O')
                    continue;
                
                if (arr[Rxx][Ryy] == 'O') {
                    System.out.println(tmp.cost + 1);
                    return;
                }
                
                if (Rxx == Bxx && Ryy == Byy) {
 
                    if(i==0){
                        if(tmp.Rx>tmp.Bx){
                            Rxx++;
                        }
                        else{
                            Bxx++;
                        }
                    }
                    
                    if(i==1){
                        if(tmp.Rx>tmp.Bx){
                            Bxx--;
                        }
                        else{
                            Rxx--;
                        }
                    }
                    
                    if(i==2){
                        if(tmp.Ry>tmp.By){
                            Byy--;
                        }
                        else{
                            Ryy--;
                        }
                    }
                    
                    if(i==3){
                        if(tmp.Ry>tmp.By){
                            Ryy++;
                        }
                        else{
                            Byy++;
                        }
                    }
                }
                if (!check[Rxx][Ryy][Bxx][Byy]) {
                    qu.offer(new Dot(Rxx, Ryy, Bxx, Byy, tmp.cost + 1));
                }
            }
        }
        System.out.println(-1);
    }
}