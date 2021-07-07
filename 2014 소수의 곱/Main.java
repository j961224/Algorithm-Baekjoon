import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = sc.nextInt();
        long[] an = new long[N];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            an[i]=sc.nextLong();
            pq.add(an[i]);
        }
        
        long answer=0;
        
        while(true){
            if(num<=0){
                break;
            }
            //제일 작은 것부터 차례대로 나오므로. 이미 오름차순으로 배열 원소를 받았으므로 가능
            answer = pq.poll();
            
            for(int i=0; i<N; i++){
                if((answer*an[i])>=(long)Math.pow(2,31)){
                    break;
                }
                
                pq.offer(answer*an[i]);
                
                if(answer%an[i]==0){
                    break;
                }
            }
            num-=1;
        }
        
        System.out.println(answer);
    }
}