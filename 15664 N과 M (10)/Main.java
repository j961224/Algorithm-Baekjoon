import java.util.*;

class Main{
    private static LinkedHashSet<String> set = new LinkedHashSet<>();
    private static StringBuilder sb1  = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] check = new boolean[N];
        //int[] answer = new int[M];
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        combination(check,arr,0,N,M);
        
        for(String a : set){
            sb1.append(a.substring(0,a.length()-1)+"\n");
        }
        System.out.println(sb1);
    }
    
    public static void combination(boolean[] check, int[] arr, int start, int N, int M){
        if(M==0){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++){
                if(check[i]){
                    sb.append(arr[i]+" ");
                }
            }
            set.add(sb.toString());
            return;
        }
        
        if(start==N){
            return;
        }
        
        check[start]=true;
        combination(check,arr,start+1,N,M-1);
        
        check[start]=false;
        combination(check,arr,start+1,N,M);
        
    }
}