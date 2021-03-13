import java.util.*;

class Fireball{
    int m;
    int s;
    int d;
    Fireball(int m, int s, int d){
        this.m=m;
        this.s=s;
        this.d=d;
    }
}

class Main{
    static int[] xx = {-1,-1,0,1,1,1,0,-1};
    static int[] yy = {0,1,1,1,0,-1,-1,-1};
    static ArrayList<Fireball> map[][];
    static int N;
    static int K;
    static long total=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N=sc.nextInt();
        int M=sc.nextInt();
        K=sc.nextInt();
        map = new ArrayList[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j]=new ArrayList<>();
            }
        }
        
        for(int i=0; i<M; i++){
            map[sc.nextInt()-1][sc.nextInt()-1].add(new Fireball(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        
        for(int z=0; z<K; z++){
            ArrayList<Fireball> map1[][] = new ArrayList[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map1[i][j]=new ArrayList<>();
                }
            }
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j].size()>0){
                        
                        for(Fireball tmp : map[i][j]){
                            int tmpx = i+xx[tmp.d]*tmp.s%N;
                            int tmpy = j+yy[tmp.d]*tmp.s%N;
                            
                            if(tmpx>=N){
                                tmpx-=N;
                            }
                            
                            if(tmpx<0){
                                tmpx+=N;
                            }
                            
                            if(tmpy>=N){
                                tmpy-=N;
                            }
                            
                            if(tmpy<0){
                                tmpy+=N;
                            }
                            
                            map1[tmpx][tmpy].add(new Fireball(tmp.m,tmp.s,tmp.d));
                        }
                    }
                }
            }
            
            map=map1;
            
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j].size()>=2){
                        int totalm=0;
                        int totals=0;
                        boolean even=false;
                        boolean odd=false;
                        for(Fireball tmp : map[i][j]){
                            totalm+=tmp.m;
                            totals+=tmp.s;
                            if(tmp.d%2==0){
                                even=true;
                            }
                            if(tmp.d%2==1){
                                odd=true;
                            }
                        }
                        
                        totalm/=5;
                        totals/=map[i][j].size();
                        map[i][j].clear();
                        if(totalm>0){
                            if(odd==false || even==false){
                                map[i][j].add(new Fireball(totalm,totals,0));
                                map[i][j].add(new Fireball(totalm,totals,2));
                                map[i][j].add(new Fireball(totalm,totals,4));
                                map[i][j].add(new Fireball(totalm,totals,6));
                            }
                            else{
                                map[i][j].add(new Fireball(totalm,totals,1));
                                map[i][j].add(new Fireball(totalm,totals,3));
                                map[i][j].add(new Fireball(totalm,totals,5));
                                map[i][j].add(new Fireball(totalm,totals,7));
                            }
                        }
                    }
                }
            }
            
            
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j].size()>0){
                    for(Fireball k : map[i][j]){
                        total+=k.m;
                    }
                }
            }
        }
        
        
        System.out.println(total);
    }
}