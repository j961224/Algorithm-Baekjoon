import java.util.*;


class Main{
    static class Dot implements Comparable<Dot>{
        int index;
        int cost;
        int old;
        public Dot(int index, int cost, int old){
            this.index=index;
            this.cost=cost;
            this.old=old;
        }
        
        @Override
        public int compareTo(Dot o){
            if(o.cost==this.cost){
                return o.old-this.old;
            }
            return o.cost-this.cost;
        }
    }
    
    static class can implements Comparable<can>{
        int index;
        int cost;
        public can(int index, int cost){
            this.index=index;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(can o){
            return o.cost-this.cost;
        }
        
    }
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Dot[] an = new Dot[N];
        ArrayList<can> candidate = new ArrayList<>();
        int[] arr = new int[M];
        for(int i=0; i<M; i++){
            arr[i]=sc.nextInt();
        }
        
        int real=0;
        for(int i=0; i<M; i++){
            int idx = arr[i];
            boolean check = false;
            if(real<N){
                for(int j=0; j<real; j++){
                    if(an[j].index==idx){
                        check=true;
                        an[j].cost+=1;
                        break;
                    }
                }
                if(!check){
                    an[real]=new Dot(idx,1,real);
                    real+=1;
                }
            }
            
            else{
                for(int j=0; j<real; j++){
                    if(an[j].index==idx){
                        check=true;
                        an[j].cost+=1;
                        break;
                    }
                }
                Arrays.sort(an);
                
                if(!check){
                    boolean ancheck = false;
                    for(int j=0; j<candidate.size(); j++){
                        if(candidate.get(j).index==idx){
                            int c = candidate.get(j).cost;
                            candidate.set(j,new can(idx,c+1));
                            ancheck=true;
                            break;
                        }
                    }
                    
                    if(!ancheck){
                        candidate.add(new can(idx,1));
                    }
                }
                Collections.sort(candidate);
                
                if(candidate.size()>0){
                    //if(an[N-1].cost<=candidate.get(0).cost){
                        an[N-1].index = candidate.get(0).index;
                        an[N-1].cost = candidate.get(0).cost;
                        an[N-1].old = i;
                        candidate.remove(0);
                    //}
                }
            }
            
            
        }
        if(real<N){
            N=real;
        }
        
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i]=an[i].index;
        }
        Arrays.sort(answer);
        for(int i=0; i<N; i++){
            System.out.printf("%d ",answer[i]);
        }
    }
}