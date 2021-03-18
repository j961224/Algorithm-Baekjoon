import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr= new int[M];
        for(int i=0; i<M; i++){
            arr[i]=sc.nextInt();
        }
        
        Arrays.sort(arr);
        int start=1;
        int end=arr[M-1];
        int middle=0;
        int min = Integer.MAX_VALUE;
        while(end>=start){
            middle=(start+end)/2;
            int count=0;
            for(int i=0; i<M; i++){
                int tmp = arr[i]/middle;
                count+=tmp;
                if(arr[i]%middle!=0){
                    count+=1;
                }
            }
            
            if(N>=count){
                min=Math.min(min,middle);
                end=middle-1;
            }
            else{
                start=middle+1;
            }
        }
        
        System.out.println(min);
    }
}