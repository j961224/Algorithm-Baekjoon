import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] check = new int[M];
        combination(check,0,0,N,M);
    }
    
    public static void combination(int[] check,int index, int target, int N, int M){
        if(M==0){
            for(int i=0; i<index; i++){
                System.out.printf("%d ",check[i]+1);
            }
            System.out.println();
            return;
        }
        
        if(target==N){
            return;
        }
        
        check[index]=target;
        combination(check,index+1,target,N,M-1);
        combination(check,index,target+1,N,M);
    }
    
}