import java.util.*;

class Main{
    static ArrayList<Integer> ar = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        
        boolean[] visited = new boolean[N];
        Arrays.sort(arr);
        combi(arr,visited,0,M,3);
        
        Collections.sort(ar);
        System.out.println(ar.get(ar.size()-1));
    }
    
    public static void combi(int[] arr,boolean[] visited, int start,int M,int r){
        if(r==0){
            int tmp=0;
            for(int k=0; k<arr.length; k++){
                if(visited[k]){
                    tmp+=arr[k];
                }
            }
            if(tmp<=M){
                ar.add(tmp);
                return;
            }
            else{
                return;
            }
        }
        
        else{
            for(int i=start; i<arr.length; i++){
                visited[i]=true;
                combi(arr,visited,i+1,M,r-1);
                visited[i]=false;
            }
        }
    }
}