import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int asd[] = new int[count];
        
        for(int i=0; i<count; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            
            asd[i]=calculate(x1,y1,r1,x2,y2,r2);
            System.out.println(asd[i]);
        
        }
    }
    
    public static int calculate(int x1,int y1,int r1,int x2,int y2,int r2){
        double d = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        
        if(x1==x2 && y1==y2){
            if(r1==r2)
                return -1;
            else
                return 0;
        }
        else{
            if(r1<r2){
                int tmp=r1;
                r1=r2;
                r2=tmp;
            }
            
            if(d<r1+r2 && d>r1-r2)
                return 2;
            else if(d==r1+r2 || d==r1-r2)
                return 1;
            else
                return 0;
        }
    }
    
    
}