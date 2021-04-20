import java.util.*;
import java.io.*;

class Dot{
    int x;
    int y;
    Dot(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class edge implements Comparable<edge>{
    int area1;
    int area2;
    int cost;
    
    edge(int area1, int area2, int cost){
        this.area1=area1;
        this.area2=area2;
        this.cost=cost;
    }
    
    @Override
    public int compareTo(edge a1){
        return this.cost-a1.cost; //거리 오름차순
    }
}

class Main{
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] check;
    static int island;
    //최소신장트리 사용 시, 작은 다리부터 하기 위해서
    static PriorityQueue<edge> pq = new PriorityQueue<edge>();
    static int[] parents;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        int N=Integer.parseInt(str[0]);
        int M=Integer.parseInt(str[1]);
        island=0;
        map=new int[N][M];
        check = new boolean[N][M];
        for(int i=0; i<N; i++){
            str = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(str[j]);
            }
        }
        
        //섬 번호 매기기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==1 && !check[i][j]){
                    island++;
                    Queue<Dot> qu = new LinkedList<>();
                    
                    qu.add(new Dot(i,j));
                    check[i][j]=true;
                    map[i][j]=island;
                    while(!qu.isEmpty()){
                        Dot tmp = qu.poll();
                        
                        for(int z=0; z<4; z++){
                            int tmpx = tmp.x+xx[z];
                            int tmpy = tmp.y+yy[z];
                            
                            if(0<=tmpx && tmpx<N && tmpy>=0 && tmpy<M){
                                if(!check[tmpx][tmpy] && map[tmpx][tmpy]==1){
                                    check[tmpx][tmpy]=true;
                                    qu.add(new Dot(tmpx,tmpy));
                                    map[tmpx][tmpy]=island;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        //다리 연결하기
        check=new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]!=0){
                    int tmpx=i;
                    int tmpy=j;
                    int area=map[i][j];
                    int size=0;
                    
                    for(int z=0; z<4; z++){
                        while(true){
                            tmpx+=xx[z];
                            tmpy+=yy[z];
                            
                            if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<M){
                                if(map[tmpx][tmpy]==area){
                                    size=0;
                                    tmpx=i;
                                    tmpy=j;
                                    break;
                                }
                                else if(map[tmpx][tmpy]==0){
                                    size++;
                                }
                                else{//다른 area를 만날 경우
                                    if(size>1){
                                        pq.add(new edge(area,map[tmpx][tmpy],size));
                                    }
                                    size=0;
                                    tmpx=i;
                                    tmpy=j;
                                    break;
                                }
                            }
                            else{
                                size=0;
                                tmpx=i;
                                tmpy=j;
                                break;
                            }
                            
                        }
                    }
                    
                }
            }
        }
        
        
        //최소 신장 트리인 kruskal을 이용하기
        parents=new int[island+1];
        for(int i=1; i<parents.length; i++){
            parents[i]=i;
        }
        int answer=0;
        int bridge_count=0;
        int g=pq.size();
        for(int i=0; i<g; i++){
            edge tmp = pq.poll();
            
            if (find(tmp.area1) == find(tmp.area2)){
                continue;
            }
            
            union(tmp.area1,tmp.area2);
            answer+=tmp.cost;
            bridge_count+=1;
        }
        
        //섬이 다 연결이 안 되어 있거나 갈 수 없는 경우
        if(answer==0 || bridge_count!=island-1){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }
    
    public static int find(int a){
        if(parents[a]!=a){
            parents[a]=find(parents[a]);
        }
        return parents[a];
    }
    
    public static void union(int a, int b){
        a=find(a);
        b=find(b);
        if(a<b){
            parents[b]=a;
        }
        else{
            parents[a]=b;
        }
    }
}