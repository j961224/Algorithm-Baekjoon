import java.util.*;

class Main{
    public static void main(String args[]){
        int answer=0;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        
        while(true){
            if(a%5==0){
                int b = a/5;
                answer+=b;
                break;
            }
            else if(a<0){
                answer=-1;
                break;
            }
            a=a-3;
            answer+=1;
        }
        
        System.out.println(answer);
    }
}