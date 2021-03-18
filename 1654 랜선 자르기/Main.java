import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int K = sc.nextInt();
        int N = sc.nextInt();
        
        int[] arr= new int[K];
        for(int i=0; i<K; i++){
            arr[i]=sc.nextInt();
        }
        
        Arrays.sort(arr);
        long start=1;
        long middle=0;
        long end=arr[K-1];
        
        while(end>=start){
            middle = (start+end)/2;
            long count=0;
            for(int i=0; i<K; i++){
                count+=arr[i]/middle;
            }
            if(count>=N){
                start=middle+1;
            }
            else{
                end=middle-1;
            }
        }
        
        System.out.println(end);
        
    }
}