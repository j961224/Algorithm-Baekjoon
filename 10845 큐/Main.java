import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> qu = new LinkedList<>();
        for(int i=0; i<N; i++){
            String tmp = sc.next();
            if(tmp.equals("push")){
                qu.addLast(sc.nextInt());
            }
            
            else if(tmp.equals("pop")){
                if(qu.isEmpty()){
                    sb.append(-1+"\n");
                }
                else{
                    sb.append(qu.pollFirst()+"\n");
                }
            }
            
            else if(tmp.equals("size")){
                sb.append(qu.size()+"\n");
            }
            
            else if(tmp.equals("empty")){
                if(qu.isEmpty()){
                    sb.append(1+"\n");
                }
                else{
                    sb.append(0+"\n");
                }
            }
            
            else if(tmp.equals("front")){
                if(qu.isEmpty()){
                    sb.append(-1+"\n");
                }
                else{
                    sb.append(qu.peekFirst()+"\n");
                }
            }
            
            else if(tmp.equals("back")){
                if(qu.isEmpty()){
                    sb.append(-1+"\n");
                }
                else{
                    sb.append(qu.peekLast()+"\n");
                }
            }
        }
        
        System.out.println(sb);
    }
}