import java.util.*;
import java.io.*;
//BFS가 아닌 DFS로 해야한다!
//동시에 같은 레벨의 다른 접점을 접근하기 때문에 만약 2레벨의 같은 알파벳이 있으면 방문 여부를 파악하기가 힘들다. 

// class Dot{
//     int x;
//     int y;
//     int cost;
//     public Dot(int x, int y,int cost){
//         this.x=x;
//         this.y=y;
//         this.cost=cost;
//     }
// }

class Main{
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    static boolean[] check;
    static char[][] arr;
    static int answer,R,C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        answer=0;
        String a = br.readLine();
        R=Integer.parseInt(a.split(" ")[0]);
        C=Integer.parseInt(a.split(" ")[1]);
        
        arr = new char[R][C];
        //Queue<Dot> qu = new LinkedList<>();
        for(int i=0; i<R; i++){
            String tmp = br.readLine();
            String[] tmp1 = tmp.split("");
            for(int j=0; j<C; j++){
                arr[i][j]= tmp1[j].charAt(0);
            }
        }
        
        check = new boolean[26];
        check[arr[0][0] - 'A']=true;
        
        DFS(0,0,1);
        
        // while(!qu.isEmpty()){
        //     Dot tmp = qu.poll();
        //     for(int i=0; i<4; i++){
        //         int tmpx = tmp.x+xx[i];
        //         int tmpy = tmp.y+yy[i];
        //         if(tmpx>=0 && tmpx<R && tmpy>=0 && tmpy<C){
        //             if(!check[arr[tmpx][tmpy]-'A']){
        //                 check[arr[tmpx][tmpy]-'A']=true;
        //                 qu.add(new Dot(tmpx,tmpy,tmp.cost+1));
        //             }
        //         }
                
        //         answer=Math.max(answer,tmp.cost);
        //     }
        // }
        
        System.out.println(answer);
    }
    
    public static void DFS(int x, int y,int cost){
        check[arr[x][y]-'A']=true;
        for(int i=0; i<4; i++){
            int tmpx = x+xx[i];
            int tmpy = y+yy[i];
            if(tmpx>=0 && tmpx<R && tmpy>=0 && tmpy<C){
                if(!check[arr[tmpx][tmpy]-'A']){
                    DFS(tmpx,tmpy,cost+1);
                    check[arr[tmpx][tmpy]-'A']=false;
                }
            }
        }
        answer = Math.max(cost,answer);
    }
}