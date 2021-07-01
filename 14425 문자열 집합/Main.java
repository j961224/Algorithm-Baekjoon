import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++){
            String w = sc.nextLine();
            hm.put(w,0);
        }
        int answer=0;
        
        for(int i=0; i<M; i++){
            String tmp = sc.nextLine();
            if(hm.containsKey(tmp)){
                answer+=1;
            }
        }
        
        
        System.out.println(answer);
    }
}