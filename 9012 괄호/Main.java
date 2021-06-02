import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] answer = new String[N];
        sc.nextLine();
        for(int i=0; i<N; i++){
            Stack<Character> st = new Stack<>();
            String s = sc.nextLine();
            boolean check = true;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)=='('){
                    st.push(s.charAt(j));
                }
                else if(s.charAt(j)==')'){
                    if(st.size()==0){
                        check=false;
                        break;
                    }
                    else{
                        st.pop();
                    }
                }
            }
            if(st.size()==0 && check){
                answer[i]="YES";
            }
            else{
                answer[i]="NO";
            }
        }
        
        for(String an : answer){
            System.out.println(an);
        }
        
    }
}