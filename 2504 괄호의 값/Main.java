import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String k =sc.nextLine();
        
        Stack<Character> st = new Stack<>();
        int answer=0;
        int tmp=1;
        boolean check=false;
        for(int i=0; i<k.length(); i++){
            if(k.charAt(i)=='('){
                st.add('(');
                tmp*=2;
            }
            if(k.charAt(i)=='['){
                st.add('[');
                tmp*=3;
            }
            if(k.charAt(i)==')'){
                if(st.isEmpty() || st.peek()!='('){
                    check=true;
                    break;
                }
                if(k.charAt(i-1)=='('){
                    answer+=tmp;
                }
                st.pop();
                tmp/=2;
            }
            if(k.charAt(i)==']'){
                if(st.isEmpty() || st.peek()!='['){
                    check=true;
                    break;
                }
                if(k.charAt(i-1)=='['){
                    answer+=tmp;
                }
                st.pop();
                tmp/=3;
            }
        }
        
        if(check || !st.isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(answer);
        }
    }
}