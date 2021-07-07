import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        
        int N  = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int t = sc.nextInt();
            
            if(t==0){
                if(pq.isEmpty()){
                    sb.append(0+"\n");
                }
                else{
                    sb.append(pq.poll()+"\n");
                }
            }
            else{
                pq.add(t);
            }
        }
        System.out.println(sb);
    }
}