import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int x=1;
        if(B>=C){
            x=-1;
        }
        
        else{
            x=(A/(C-B))+1;
        }
        
        
        System.out.println(x);
    }
}