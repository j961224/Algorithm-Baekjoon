import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        long X = sc.nextLong();
        long Y = sc.nextLong();
        
        
        long Z = (Y*100)/X;
        if(Z>=99){
            System.out.println(-1);
            return;
        }
        
        long start=0;
        long end = X-1;
        long middle=0;
        while(start<=end){
            middle=(start+end)/2;
            long tmpY = Y+middle;
            long tmpX = X+middle;
            long zz = (tmpY*100)/tmpX;
            
            if(zz>Z){
                end=middle-1;
            }
            else{
                start=middle+1;
            }
        }
        
        System.out.println(start);
    }
}