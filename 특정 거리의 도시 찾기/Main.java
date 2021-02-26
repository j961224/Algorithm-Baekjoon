import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int K=sc.nextInt();
        int X=sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] min_distance = new int[N+10];
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<Integer>());
            min_distance[i]=-1;
        }
        
        for(int i=0; i<M; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph.get(a).add(b);
        }
        min_distance[X]=0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=0; i<graph.get(tmp).size(); i++){
                int tmp1 = graph.get(tmp).get(i);
                
                if(min_distance[tmp1]==-1){
                    min_distance[tmp1]=min_distance[tmp]+1;
                    q.offer(tmp1);
                }
            }
        }
        
        boolean check = false;
        for(int i=1; i<N+1; i++){
            if(min_distance[i]==K){
                check=true;
                System.out.println(i);
            }
        }
        if(!check){
            System.out.println(-1);
        }
        
    }
}