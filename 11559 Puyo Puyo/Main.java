import java.util.*;
import java.io.*;
//�� ù��° ������ ���̵��� �����ϰ� ����

public class Main{
    static class Dot{
        int x;
        int y;
        Dot(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static char[][] original;
    static boolean[][] check;
    //static boolean checkto;
    static boolean count; //�������� ���࿡ ��� .�� ������ �ʿ�� �Ѵ�.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        int answer=0;
        original = new char[12][6];
        
        for(int i=0; i<12; i++){
            char[] str = br.readLine().toCharArray();
            for(int j=0; j<6; j++){
//                original[i][j]=sc.next().charAt(0);
                original[i][j] = str[j];
            } 
        }
        
        while(true){
            check=new boolean[12][6];
            count =true;
            for(int i=11; i>=0; i--){
                for(int j=5; j>=0; j--){
                    if(original[i][j]!='.' && check[i][j]==false){
                        bfs(new Dot(i,j));
                    }
                }
            }
            
            if(count){
                break;//���� ���� ���� ���� �� while �� ���� ������
            }
            else{
                answer++;
                down();// ���� ���� ������ ������ �����κ��� �Ųٰ� ���� ���� ������ �Լ�
            }
            
        }
        System.out.println(answer);    
    }
    
    public static void bfs(Dot a){
        int duplic =0;
        Queue<Dot> q = new LinkedList<>();
        ArrayList<Dot> q1 = new ArrayList<>();
        int[] xx = {1,-1,0,0};
        int[] yy = {0,0,1,-1};
        check[a.x][a.y]=true;
        q.add(a);
        q1.add(a);

        while(!q.isEmpty()){
            Dot d = q.poll();
//            q1.add(d);
            duplic++;
            for(int k=0; k<4; k++){
                int x=d.x+xx[k];
                int y=d.y+yy[k];
                
                if(0<=x && x<12 && 0<=y && y<6 && original[d.x][d.y]==original[x][y] && check[x][y]==false){
                    check[x][y]=true;
                    q.add(new Dot(x,y));
                    q1.add(new Dot(x,y));
                }
            }
        }
        if(duplic>=4){
            count=false;
//            checkto=true;
            for(int i=0; i<q1.size(); i++){
                Dot k=q1.get(i);
                original[k.x][k.y]='.';
            }
        }
        
    }
    
    public static void down(){ //���� ���� �� �κи� �Ʒ��� ������� ������ �̷��� �ϴ� ����
        for(int i=11; i>=0; i--){
            for(int j=5; j>=0; j--){
                if(original[i][j] != '.'){
                    int o=-1;
                    for(int r=11; r>i; r--){
                        if(original[r][j]=='.'){
                            o=r;
                            break;
                        }
                    }
                    if(o!=-1){
                        char tmp = original[i][j];
                        original[i][j]=original[o][j];
                        original[o][j]=tmp;
                    }
                }
            }
        }
    }
    
}