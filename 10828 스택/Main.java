import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Stack<Integer> st = new Stack<>();
        
        int N = sc.nextInt();
        sc.nextLine();
        int minus = -1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            String[] tmp = sc.nextLine().split(" ");
            if(tmp[0].equals("push")){
                st.add(Integer.parseInt(tmp[1]));
            }
            
            else if(tmp[0].equals("pop")){
                if(st.isEmpty()){
                    sb.append(minus+"\n");
                }
                else{
                    sb.append(st.pop()+"\n");
                }
            }
            
            else if(tmp[0].equals("size")){
                sb.append(st.size()+"\n");
            }
            
            else if(tmp[0].equals("empty")){
                if(st.isEmpty()){
                    sb.append(1+"\n");
                }
                else{
                    sb.append(0+"\n");
                }
            }
            
            else if(tmp[0].equals("top")){
                if(st.isEmpty()){
                    sb.append(minus+"\n");
                }
                else{
                    int t = st.peek();
                    sb.append(t+"\n");
                }
            }
        }
        
        System.out.println(sb);
    }
}