import java.util.*;

class Main{
    static int N,M,D;
    static int[][] map;
    static int[][] copy;
    static int answer;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        D=sc.nextInt();
        ArrayList<Integer> archer = new ArrayList<>();
        map=new int[N+1][M+1];
        copy=new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                map[i][j]=sc.nextInt();
                copy[i][j]=map[i][j];
            }
        }
        answer=0;
        combination(3,1,M,archer);
        
        System.out.println(answer);
    }
    
    public static void combination(int archercnt, int start, int row, ArrayList<Integer> archer){
        if(archercnt==0){
            init();
            attack(archer);
            return;
        }
        else{
            for(int i=start; i<=row; i++){
                archer.add(i);
                combination(archercnt-1,i+1,row,archer);
                archer.remove(archer.size()-1);
            }
        }
    }
    
    public static void init(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                map[i][j]=copy[i][j];
            }
        }
    }
    
    public static int caldistance(int x, int y, int x1, int y1){
        return Math.abs(x-x1)+Math.abs(y-y1);
    }
    
    public static void attack(ArrayList<Integer> archer){
        int die=0;
        
        for(int i=1; i<=N; i++){
            boolean[][] check= new boolean[N+1][M+1];
            for(int j=0; j<archer.size(); j++){
                int archery=archer.get(j);
                int minD=Integer.MAX_VALUE;
                int minrow=Integer.MAX_VALUE;
                int mincol=Integer.MAX_VALUE;
                
                for(int x=1; x<=N; x++){
                    for(int y=1; y<=M; y++){
                        if(map[x][y]==1){
                            if(minD>caldistance(x,y,N+1,archery)){
                                minD=caldistance(x,y,N+1,archery);
                                mincol=y;
                                minrow=x;
                            }
                            if(minD==caldistance(x,y,N+1,archery)){
                                if(mincol>y){
                                    minrow=x;
                                    mincol=y;
                                }
                            }
                        }
                    }
                }
                
                if(minD<=D){
                    check[minrow][mincol]=true;
                }
            }
            
            for(int i1=1; i1<=N; i1++){ //공격 맞은 사람 카운트
                for(int j=1; j<=M; j++){
                    if(check[i1][j]){
                        die++;
                        map[i1][j]=0;
                    }
                }
            }
            
            for(int i1=1; i1<=M; i1++){
                map[N][i1]=0;
            }
            
            for(int i1=N; i1>=1; i1--){
                for(int j=1; j<=M; j++){
                    map[i1][j]=map[i1-1][j];
                }
            }
            
        }
        
        answer=Math.max(answer,die);
    }
    
}