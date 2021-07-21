import java.util.*;

class room implements Comparable<room>{
    int start;
    int end;
    public room(int start, int end){
        this.start=start;
        this.end=end;
    }
    
    @Override
    public int compareTo(room o){
        if(this.start==o.start){
            return this.end-o.end;
        }
        return this.start-o.start;
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        room[] arr = new room[N];
        for(int i=0; i<N; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[i]=new room(s,e);
        }
        
        Arrays.sort(arr);
        
        pq.add(arr[0].end);
        
        for(int i=1; i<N; i++){
            if(pq.peek()<=arr[i].start){
                pq.poll();
            }
            pq.add(arr[i].end);
        }
        System.out.println(pq.size());
    }
}