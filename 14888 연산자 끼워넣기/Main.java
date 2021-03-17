import java.util.*;


class Main{
    static int N;
    static int[] arr;
    static int max;
    static int min;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        
        N = sc.nextInt();
        arr = new int[N];
        int[] operation = new int[4]; 
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        
        for(int i=0; i<4; i++){
            operation[i]=sc.nextInt();
        }
        
        dfs(0,arr[0],operation);
        System.out.println(max);
        System.out.println(min);
    }
    
    public static void dfs(int count, int value, int[] operation){
        if(count==N-1){
            max=Math.max(value,max);
            min=Math.min(value,min);
            return;
        }
        
        if(operation[0]>0){
            operation[0]-=1;
            dfs(count+1,value+arr[count+1],operation);
            operation[0]+=1;
        }
        
        if(operation[1]>0){
            operation[1]-=1;
            dfs(count+1,value-arr[count+1],operation);
            operation[1]+=1;
        }
        
        if(operation[2]>0){
            operation[2]-=1;
            dfs(count+1,value*arr[count+1],operation);
            operation[2]+=1;
        }
        
        if(operation[3]>0){
            operation[3]-=1;
            dfs(count+1,value/arr[count+1],operation);
            operation[3]+=1;
        }
        
    }
}