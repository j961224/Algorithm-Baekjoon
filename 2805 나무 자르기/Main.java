import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[] arr=new int[N];
        int M = sc.nextInt();
        
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        long middle=0;
        long start=1;
        long end=arr[N-1];
        
        while(end>=start){
            middle=(start+end)/2;
            long count=0;
            for(int i=0; i<N; i++){
                if(middle<arr[i]){
                    count+=arr[i]-middle;
                }
            }
            
            if(M<=count){
                start=middle+1;
            }
            else{
                end=middle-1;
            }
        }
        
        System.out.println(end);
    }
}