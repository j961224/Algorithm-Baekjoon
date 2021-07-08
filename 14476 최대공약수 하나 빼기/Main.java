import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long answer=-1;
        long num=0;
        int N = sc.nextInt();
        long[] arr = new long[N+2];
        long[] leftgcd = new long[N+2]; //누적합식으로 처음에서 위로 하나씩 최대공약수 구한다.
        long[] rightgcd = new long[N+2]; //누적합식으로 위에서 처음으로 하나씩 최대공약수 구한다.
        
        for(int i=1; i<=N; i++){
            arr[i]=sc.nextLong();
        }
        for(int i=1; i<=N; i++){
            leftgcd[i]=gcd(leftgcd[i-1],arr[i]);
        }
        for(int i=N; i>=1; i--){
            rightgcd[i]=gcd(rightgcd[i+1],arr[i]);
        }
        for(int i=1; i<=N; i++){
            long cgcd = gcd(leftgcd[i-1],rightgcd[i+1]);
            if(arr[i]%cgcd==0){
                //최대공약수가 뺄 정수에 약수므로 아웃
                continue;
            }
            if(answer<cgcd){
                answer=cgcd;
                num=arr[i];
            }
        }
        if(answer==-1){
            System.out.println(answer);
        }
        else{
            System.out.println(answer+" "+num);
        }
    }
    public static long gcd(long a, long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}