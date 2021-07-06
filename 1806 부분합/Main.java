import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        int answer=-1;
        int start=0;
        int end=0;
        int sum=0;
        while(true){
            if(sum>=S){
                if(answer==-1){
                    answer=end-start;
                }
                else{
                    answer = Math.min(answer,end-start);
                }
                sum-=arr[start];
                start+=1;
            }
            else if(end==N){
                break;
            }
            else{
                sum+=arr[end];
                end+=1;
            }
        }
        
        if(answer==-1){
            answer=0;
        }
        System.out.println(answer);
    }
}