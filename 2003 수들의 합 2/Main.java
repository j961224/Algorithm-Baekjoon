import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        int answer=0;
        for(int i=0; i<N; i++){
            int z = arr[i];
            if(z==M){
                answer+=1;
            }
            else{
            for(int j=i+1; j<N; j++){
                z+=arr[j];
                if(z>M){
                    break;
                }
                else if(z==M){
                    answer+=1;
                    break;
                }
            }
            }
        }
        
        System.out.println(answer);
    }
}