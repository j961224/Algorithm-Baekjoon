import java.util.*;
import java.io.*;
//맨 첫번째 문제의 아이디어와 유사하게 생각

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
    static boolean count; //마지막에 만약에 모두 .만 남으면 필요로 한다.
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
                break;//이제 터질 것이 없을 때 while 문 빠져 나오기
            }
            else{
                answer++;
                down();// 터진 것이 있으니 터지고 터진부분을 매꾸고 위에 것을 내리는 함수
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
    
    public static void down(){ //원래 터진 열 부분만 아래로 땡길려고 했지만 이렇게 일단 구현
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