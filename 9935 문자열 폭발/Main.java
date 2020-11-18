import java.util.*;
import java.io.*;

// Queue와 stack 중에 생각해봤을 때, charAt으로 하나씩 받으면서 bomb와 같아지는게 있으면 빼기 위해서 
// stack을 사용하기로 결정!
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();
        
        Stack<Character> st = new Stack<>();
        
        
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            boolean check = true;
            
            st.push(c);
            
            if(c==bomb.charAt(bomb.length()-1) && st.size()>=bomb.length()){
                for(int j=bomb.length()-1; j>=0; j--){//bomb string이 stack에 겹치는 것을 확인 -> true가 될 경우가 겹치는 것!
                    if(bomb.charAt(j)!=st.get(st.size()-(bomb.length()-j))){
                        check=false;
                        break;
                    }
                }
                if(check){//제일 최근에 stack에 들어간 부분을 bomb length만큼 빼버린다.
                    for(int j=0; j<bomb.length(); j++){
                        st.pop();
                    }
                }
            }
        }
        StringBuffer str =new StringBuffer();
        if(st.isEmpty()){
            System.out.println("FRULA");
        }
        else{
            for(int z=0; z<st.size(); z++){
                str.append(st.get(z));
            }
        }
        System.out.println(str);
        
            
    }
}