import java.util.*;

class Dot{
    int dest;
    int cost;
    public Dot(int dest, int cost){
        this.dest=dest;
        this.cost=cost;
    }
}

class Main{
    static int N, max,idx;
    static ArrayList<Dot>[] arr;
    static boolean[] visit;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new ArrayList[N+1];
        
        for(int i=1; i<N+1; i++){
            arr[i]=new ArrayList<>();
        }
        
        for(int i=1; i<N; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr[a].add(new Dot(b,c));
            arr[b].add(new Dot(a,c));
        }
        max=1;
        idx=1;
        visit=new boolean[N+1];
        visit[1]=true;
        dfs(1,0); // root인 1과 가장 먼 node 찾음
        
        visit=new boolean[N+1];
        visit[idx]=true;
        max=0;
        dfs(idx,0); // root와 가장 먼 node와 가장 거리가 많이 차이나는 node와의 거리 찾기
        System.out.println(max);
    }
    
    public static void dfs(int index, int cost){
        if(cost>max){
            max=cost;
            idx=index;
        }
        
        for(Dot k : arr[index]){
            if(!visit[k.dest]){
                visit[k.dest]=true;
                dfs(k.dest,k.cost+cost);
            }
        }
    }
}