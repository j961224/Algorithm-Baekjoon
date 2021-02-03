import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] N = new int[n];
        for(int i=0; i<n; i++){
            N[i]=sc.nextInt();
        }
        int answer=0;
        for(int i=0; i<n; i++){
            boolean check = true;
            if(N[i]==1){
                check=false;
            }
            for(int j=2; j<N[i]; j++){
                if(N[i]%j==0){
                    check=false;
                    break;
                }
            }
            if(check){
                answer++;
            }
        }
        System.out.println(answer);
    }
}