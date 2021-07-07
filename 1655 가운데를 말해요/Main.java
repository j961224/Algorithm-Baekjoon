import java.util.*;



class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        PriorityQueue<Integer> pq0 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int tmp = sc.nextInt();
            if(pq0.size()==pq1.size()){
                pq0.add(tmp);
            }
            else{
                pq1.add(tmp);
            }
            
            if(!pq0.isEmpty() && !pq1.isEmpty() && pq1.peek()<pq0.peek()){
                int z0 = pq0.poll();
                int z1 = pq1.poll();
                pq0.add(z1);
                pq1.add(z0);
            }
            sb.append(pq0.peek()+"\n");
        }
        
        System.out.println(sb);
    }
}