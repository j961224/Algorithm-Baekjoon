import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] mindp = new int[3];
        int[] maxdp = new int[3];
        
        for(int i=0; i<N; i++){
            int x0 = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            
            if(i==0){
                mindp[0]=maxdp[0]=x0;
                mindp[1]=maxdp[1]=x1;
                mindp[2]=maxdp[2]=x2;
            }
            else{
                int before_0 = mindp[0];
                int before_2 = mindp[2];
                mindp[0] = Math.min(before_0,mindp[1])+x0;
                mindp[2] = Math.min(before_2,mindp[1])+x2;
                mindp[1] = Math.min(before_0,Math.min(before_2,mindp[1]))+x1;
                
                
                before_0 = maxdp[0];
                before_2 = maxdp[2];
                maxdp[0] = Math.max(before_0,maxdp[1])+x0;
                maxdp[2] = Math.max(before_2,maxdp[1])+x2;
                maxdp[1] = Math.max(before_0,Math.max(before_2,maxdp[1]))+x1;
            }
        }
        
        
        
        System.out.printf("%d %d",Math.max(maxdp[0],Math.max(maxdp[1],maxdp[2])),Math.min(mindp[0],Math.min(mindp[1],mindp[2])));
    }
}