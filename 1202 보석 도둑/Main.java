import java.util.*;
class Bag implements Comparable<Bag>{
    int weight;
    int cost;
    public Bag(int weight, int cost){
        this.weight=weight;
        this.cost=cost;
    }
    
    @Override
    public int compareTo(Bag o){
        return this.weight-o.weight;
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int pire = sc.nextInt();
        int bag = sc.nextInt();
        long answer=0;
        Bag[] ar = new Bag[pire];
        int[] w = new int[bag];
        for(int i=0; i<pire; i++){
            ar[i]=new Bag(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(ar);
        for(int i=0; i<bag; i++){
            w[i]=sc.nextInt();
        }
        Arrays.sort(w);
        int index=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<bag; i++){
            while(index<pire && ar[index].weight<=w[i]){
                pq.add(ar[index].cost);
                index+=1;
            }
            if(!pq.isEmpty()){
                answer+=pq.poll();
            }
        }
        
        System.out.println(answer);
    }
}