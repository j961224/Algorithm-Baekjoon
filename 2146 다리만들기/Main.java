import java.util.*;

public class Main{
    static class Dot{
        int x;
        int y;
        Dot(int x, int y){
            this.x=x;
            this.y=y;
        }
    }// 처음에 area 넣어서 배열 하나 줄이려고 했더니 생각해보니 처음에 초기화 시키기 힘들고
     // 이것을 바로 비교해서 쓰기가 힘든거 같아서 area는 따로 쓰기로 결정
    
    //주변 좌표 확인하기 위해서
    static int[] xx={-1,1,0,0};
    static int[] yy={0,0,-1,1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int boundary=0; // 각 섬 안에 있는 area 저장을 위한 변수
        int di=-2; // 최종 거리 구하는데 쓰이는 변수
        
        int[][] original = new int[n][n]; //처음에 1과 0을 받는 배열
        int[][] distance = new int[n][n]; //각 자리마다 1에서 멀어진 거리 저장 배열
        int[][] area = new int[n][n]; //각 1이 있는 구역에 boundary 저장 배열
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                original[i][j]=sc.nextInt();
            }
        }
        Queue<Dot> q1 = new LinkedList<>();
        //섬의 각 구역마다 숫자 매기기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(original[i][j]==1 && area[i][j]==0){
                    //bfs를 이용해서 각 뭉쳐있는 섬에 구역을 정해준다.
                    Queue<Dot> q = new LinkedList<>();
                    boundary=boundary+1;
                    area[i][j]=boundary;
                    q.offer(new Dot(i,j));
                    q1.offer(new Dot(i,j));
                    while(!q.isEmpty()){
                        Dot d = q.poll();
                        int x=d.x;
                        int y=d.y;
                        for(int r=0; r<4; r++){
                            int nxx = x+xx[r];
                            int nyy = y+yy[r];
                            if(0<=nxx && nxx<n && 0<=nyy && nyy<n){
                                if(original[nxx][nyy]==1 && area[nxx][nyy]==0){
                                    q.offer(new Dot(nxx,nyy));
                                    q1.offer(new Dot(nxx,nyy));
                                    area[nxx][nyy]=boundary;
                                }
                            }
                        }
                    }
                }
            }
        }
        //거리 측정
        while(!q1.isEmpty()){
            Dot d = q1.poll();
            int x = d.x;
            int y = d.y;
            for(int r=0; r<4; r++){
                int nxx = x+xx[r];
                int nyy = y+yy[r];
                if(0<=nxx && nxx<n && 0<=nyy && nyy<n){
                    if(area[nxx][nyy]==0){
                        distance[nxx][nyy] = distance[x][y]+1;
                        
                        area[nxx][nyy]=area[x][y];
                        q1.offer(new Dot(nxx,nyy));
                    }
                }
            }
        }
        //최소값 찾기!
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int r=0; r<4; r++){
                    int x = i+xx[r];
                    int y = j+yy[r];
                    if(0<=x && x<n && 0<=y && y<n){
                        if(area[x][y] != area[i][j]){
                          if(di<0 || di>distance[x][y]+distance[i][j]){
                              di=distance[x][y]+distance[i][j];
                          }  
                        }
                    }
                }
            }
        }
        System.out.println(di);
    }
}
