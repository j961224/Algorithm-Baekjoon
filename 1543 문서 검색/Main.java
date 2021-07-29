import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String a= sc.nextLine();
        String b= sc.nextLine();
        
        int len = b.length();
        int answer=0;
        
        for(int i=0; i<=a.length()-len; i++){
            boolean check = true;
            for(int j=0; j<len; j++){
                if(a.charAt(i+j)!=b.charAt(j)){
                    check=false;
                    break;
                }
            }
            if(check){
                answer+=1;
                i+=len-1;
            }
        }
        System.out.println(answer);
    }
}