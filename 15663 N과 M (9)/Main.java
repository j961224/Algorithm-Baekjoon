import java.util.*;

class Main{
    private static int N,M;
    private static boolean[] check;
    private static int[] arr;
    private static LinkedHashSet<String> set = new LinkedHashSet<>();
    private static HashMap<String,Integer> hm = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N=sc.nextInt();
        M=sc.nextInt();
        
        arr=new int[N];
        check=new boolean[N+1];
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        
        permutation(0,"");
        for(String s : set){
            sb.append(s.substring(0,s.length()-1)+"\n");
        }
        System.out.println(sb);
    }
    
    public static void permutation(int start,String s){
        if(start==M){
            set.add(s);
            return;
        }
        
        for(int i=0; i<N; i++){
            if(!check[i]){
                check[i]=true;
                permutation(start+1,s+arr[i]+" ");
                check[i]=false;
            }
        }
        
    }
}