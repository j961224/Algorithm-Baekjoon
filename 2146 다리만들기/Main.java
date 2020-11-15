
import java.util.*;


public class Main{
    static class Dot{
        int x;
        int y;
        Dot(int x, int y){
            this.x=x;
            this.y=y;
        }
    }// ó���� area �־ �迭 �ϳ� ���̷��� �ߴ��� �����غ��� ó���� �ʱ�ȭ ��Ű�� �����
     // �̰��� �ٷ� ���ؼ� ���Ⱑ ����� ���Ƽ� area�� ���� ����� ����
    
    //�ֺ� ��ǥ Ȯ���ϱ� ���ؼ�
    static int[] xx={-1,1,0,0};
    static int[] yy={0,0,-1,1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int boundary=0; // �� �� �ȿ� �ִ� area ������ ���� ����
        int di=-2; // ���� �Ÿ� ���ϴµ� ���̴� ����
        
        int[][] original = new int[n][n]; //ó���� 1�� 0�� �޴� �迭
        int[][] distance = new int[n][n]; //�� �ڸ����� 1���� �־��� �Ÿ� ���� �迭
        int[][] area = new int[n][n]; //�� 1�� �ִ� ������ boundary ���� �迭
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                original[i][j]=sc.nextInt();
            }
        }
        Queue<Dot> q1 = new LinkedList<>();
        //���� �� �������� ���� �ű��
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(original[i][j]==1 && area[i][j]==0){
                    //bfs�� �̿��ؼ� �� �����ִ� ���� ������ �����ش�.
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
        //�Ÿ� ����
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
        //�ּҰ� ã��!
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
