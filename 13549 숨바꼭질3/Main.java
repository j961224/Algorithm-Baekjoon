import java.util.*;

class Point{
    int x;
    int cost;
    Point(int x, int cost){
        this.x=x;
        this.cost=cost;
    }
}

class Main{
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] visited = new boolean[2000001];
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        if(N>=K){
            min=N-K;
        }
        else{
            Queue<Point> qu = new LinkedList<>();
            qu.add(new Point(N,0));
            
            while(!qu.isEmpty()){
                Point tmp = qu.poll();
                visited[tmp.x]=true;
                
                if(tmp.x==K){
                    min=Math.min(min,tmp.cost);
                }
                
                if(tmp.x*2<=100000 && !visited[tmp.x*2]){
                    qu.add(new Point(2*tmp.x,tmp.cost));
                }
                
                if(tmp.x+1<=100000 && !visited[tmp.x+1]){
                    qu.add(new Point(tmp.x+1,tmp.cost+1));
                }
                
                if(tmp.x-1>=0 && !visited[tmp.x-1]){
                    qu.add(new Point(tmp.x-1,tmp.cost+1));
                }
            }
        }
        
        System.out.println(min);
    }
}