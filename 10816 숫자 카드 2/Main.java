import java.util.*;


class Main{
    static int[] original;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        original = new int[N];
        for(int i=0; i<N; i++){
            original[i]=sc.nextInt();
        }
        
        int M = sc.nextInt();
        
        Arrays.sort(original);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int find = sc.nextInt();
            
            sb.append(upperbound(find) - lowerbound(find)).append(' ');
        }
        System.out.println(sb);
    }
    
    public static int lowerbound(int find){
        int start = 0;
        int end = original.length;
        
        while(start<end){
            int middle = (start+end)/2;
            if(find<=original[middle]){
                end = middle;
            }
            else{
                start = middle+1;
            }
        }
        return start;
    }
    
    public static int upperbound(int find){
        int start = 0;
        int end = original.length;
        
        while(start<end){
            int middle = (start+end)/2;
            if(find<original[middle]){
                end = middle;
            }
            else{
                start = middle+1;
            }
        }
        return start;
    }
}