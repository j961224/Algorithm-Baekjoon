import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] times = new int[n];
        for(int i=0; i<n; i++){
            times[i]=sc.nextInt();
        }
        Arrays.sort(times);
        long max = (long)times[times.length-1]*m;
        long min = 1;
        long mid = 0;
        long sum;
        long answer=max;
        while(min<=max){
            sum=0;
            mid=(min+max)/2;
            for(int t : times){
                sum+=mid/t;
            }
            if(sum>=m){
                if(mid<answer){
                    answer=mid;
                }
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        
        System.out.println(answer);
    }
}