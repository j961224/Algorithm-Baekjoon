import java.util.*;

class Main{
    static ArrayList<Integer>[] list;
    static int[] answer;
    static boolean[] check;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        list=new ArrayList[N+1];
        answer= new int[N+1];
        check= new boolean[N+1];
        
        for(int i=1; i<=N; i++){
            list[i]=new ArrayList<>();
        }
        
        for(int i=0; i<N-1; i++){
            int a1 = sc.nextInt();
            int b1 = sc.nextInt();
            list[a1].add(b1);
            list[b1].add(a1);
        }
        
        
        dfs(1);
        for(int i=2; i<=N; i++){
            System.out.println(answer[i]);
        }
    }
    
    public static void dfs(int i){
        check[i]=true;
        for(int k : list[i]){
            if(!check[k]){
                answer[k]=i;
                dfs(k);
            }
        }
    }
}