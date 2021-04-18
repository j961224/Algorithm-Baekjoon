import java.util.*;


class Position{
    int x;
    int Num;
    Position(int x, int Num){
        this.x=x;
        this.Num=Num;
    }
}

class Main{
    static Position[] position;
    static int N;
    static ArrayList<ArrayList<Integer>> tree;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        position = new Position[N+1];
        
        for(int i=1; i<=N; i++){
            position[i]=new Position(i,sc.nextInt());
        }
        
        tree = new ArrayList<>();
        
        for(int i=0; i<=N; i++){
            tree.add(new ArrayList<>());
        }
        
        for(int i=1; i<=N; i++){
            int n =sc.nextInt();
            for(int j=0; j<n; j++){
                int tmp = sc.nextInt();
                tree.get(i).add(tmp);
            }
        }
        
        
        for(int i=1; i<=N/2; i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            combination(1,N,i,tmp);
        }
        
        if(answer==Integer.MAX_VALUE){
            answer = -1;
        }
        
        System.out.println(answer);
    }
    
    public static void combination(int start, int N, int r, ArrayList<Integer> tmp){
        if(r==0){
            calc(tmp);
            return;
        }
        
        for(int i=start; i<=N; i++){
            tmp.add(i);
            combination(i+1,N,r-1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
    
    public static void calc(ArrayList<Integer> tmp){
        if(!isConnect(position[tmp.get(0)].x,tmp,tmp.size())){
            return;
        }
        
        
        ArrayList<Integer> tmp1 = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(!tmp.contains(i)){
                tmp1.add(i);
            }
        }
        
        if(!isConnect(position[tmp1.get(0)].x,tmp1,tmp1.size())){
            return;
        }
        
        int a=0;
        int b=0;
        
        for(int i=0; i<tmp.size(); i++){
            a+=position[tmp.get(i)].Num;
        }
        
        for(int i=0; i<tmp1.size(); i++){
            b+=position[tmp1.get(i)].Num;
        }
        
        answer=Math.min(Math.abs(a-b),answer);
        
    }
    
    public static boolean isConnect(int num,ArrayList<Integer> tmp,int size){
        boolean[] visit = new boolean[N+1];
        visit[num]=true;
        Queue<Integer> qu =new LinkedList<>();
        qu.offer(num);
        
        int count=1;
        while(!qu.isEmpty()){
            int z = qu.poll();
            
            for(int a : tree.get(z)){
                if(!visit[a] && tmp.contains(a)){
                    count+=1;
                    qu.offer(a);
                    visit[a]=true;
                }
            }
        }
        
        if(count==size){
            return true;
        }
        return false;
        
    }
    
}