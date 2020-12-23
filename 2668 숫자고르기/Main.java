import java.util.*;


class Main{
    static int last;
    static boolean[] visited;
    static ArrayList<Integer> an;
    static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        
        arr = new int[size+1];
        visited = new boolean[size+1];
        an = new ArrayList<>();
        
        for(int i=1; i<size+1; i++){
            arr[i]=sc.nextInt();
        }
        
        for(int i=1; i<size+1; i++){
            visited[i]=true;
            last=i;
            dfs(i);
            visited[i]=false;
        }
        
        System.out.println(an.size());
        Collections.sort(an);
        for(int i=0; i<an.size(); i++){
           System.out.println(an.get(i)); 
        }
    }
    
    public static void dfs(int idx){
        if(!visited[arr[idx]]){
            visited[arr[idx]]=true;
            dfs(arr[idx]);
            visited[arr[idx]]=false;
        }
        if(arr[idx]==last){
            an.add(last);
        }
    }
}