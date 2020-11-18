import java.util.*;
import java.io.*;

// Queue�� stack �߿� �����غ��� ��, charAt���� �ϳ��� �����鼭 bomb�� �������°� ������ ���� ���ؼ� 
// stack�� ����ϱ�� ����!
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
                for(int j=bomb.length()-1; j>=0; j--){//bomb string�� stack�� ��ġ�� ���� Ȯ�� -> true�� �� ��찡 ��ġ�� ��!
                    if(bomb.charAt(j)!=st.get(st.size()-(bomb.length()-j))){
                        check=false;
                        break;
                    }
                }
                if(check){//���� �ֱٿ� stack�� �� �κ��� bomb length��ŭ ��������.
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