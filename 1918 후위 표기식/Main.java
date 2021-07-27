import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String an = sc.nextLine();
        
        
        Stack<Character> buho = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<an.length(); i++){
            char tmp = an.charAt(i);
            if((int)'A'<=(int)tmp && (int)tmp<=(int)'Z'){
                sb.append(tmp);
            }
            else if(tmp=='('){
                buho.add(tmp);
            }
            else if(tmp==')'){
                while(true){
                    if(buho.isEmpty()){
                        break;
                    }
                    if(buho.peek()=='('){
                        buho.pop();
                        break;
                    }
                    else{
                        sb.append(buho.pop());
                    }
                }
            }
            else if(tmp=='*' || tmp=='/'){
                while(true){
                    if(buho.isEmpty()){
                        break;
                    }
                    if(buho.peek()=='*' || buho.peek()=='/'){
                         sb.append(buho.pop());
                    }
                    else{
                        break;
                    }
                }
                buho.add(tmp);
            }
            else{
                while(!buho.isEmpty()){
                    if(buho.peek()=='('){
                        break;
                    }
                    sb.append(buho.pop());
                }
                buho.add(tmp);
            }
        }
        
        while(!buho.isEmpty()){
            sb.append(buho.pop());
        }
        
        System.out.println(sb);
    }
}