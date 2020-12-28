import java.util.*;

class Dot{
    int x;
    int y;
    public Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        Dot[] dots = new Dot[3];
        for(int i=0; i<3; i++){
            int tmpx=sc.nextInt();
            int tmpy=sc.nextInt();
            dots[i]=new Dot(tmpx,tmpy);
        }
        int dxab= dots[1].x-dots[0].x;
        int dyab= dots[1].y-dots[0].y;
        int dxac= dots[2].x-dots[0].x;
        int dyac= dots[2].y-dots[0].y;
     
        if(dxab*dyac==dyab*dxac){ // 삼각형 되지 않을 경우
            System.out.println("X");
        }
        else if(checkJungTriangle(dots[0],dots[1],dots[2])){
             System.out.println("JungTriangle");
        }
            
            
            else if(checkTwoLenght(dots[0],dots[1],dots[2])){
                if((dots[1].x-dots[0].x)*(dots[2].x-dots[0].x)+(dots[1].y-dots[0].y)*(dots[2].y-dots[2].y)<0){
                    System.out.println("Dunkak2Triangle");
                }
                else if((dots[0].x-dots[1].x)*(dots[2].x-dots[1].x)+(dots[0].y-dots[1].y)*(dots[2].y-dots[1].y)<0){
                    System.out.println("Dunkak2Triangle");
                }
                else if((dots[0].x-dots[2].x)*(dots[1].x-dots[2].x)+(dots[0].y-dots[2].y)*(dots[1].y-dots[2].y)<0){
                    System.out.println("Dunkak2Triangle");
                }
                else if((dots[1].x-dots[0].x)*(dots[2].x-dots[0].x)+(dots[1].y-dots[0].y)*(dots[2].y-dots[2].y)==0){
                    System.out.println("Jikkak2Triangle");
                }
                else if((dots[0].x-dots[1].x)*(dots[2].x-dots[1].x)+(dots[0].y-dots[1].y)*(dots[2].y-dots[1].y)==0){
                    System.out.println("Jikkak2Triangle");
                }
                else if((dots[0].x-dots[2].x)*(dots[1].x-dots[2].x)+(dots[0].y-dots[2].y)*(dots[1].y-dots[2].y)==0){
                    System.out.println("Jikkak2Triangle");
                }
                else{
                    System.out.println("Yeahkak2Triangle");
                }
            }
            else{
                if((dots[1].x-dots[0].x)*(dots[2].x-dots[0].x)+(dots[1].y-dots[0].y)*(dots[2].y-dots[2].y)<0){
                    System.out.println("DunkakTriangle");
                }
                else if((dots[0].x-dots[1].x)*(dots[2].x-dots[1].x)+(dots[0].y-dots[1].y)*(dots[2].y-dots[1].y)<0){
                    System.out.println("DunkakTriangle");
                }
                else if((dots[0].x-dots[2].x)*(dots[1].x-dots[2].x)+(dots[0].y-dots[2].y)*(dots[1].y-dots[2].y)<0){
                    System.out.println("DunkakTriangle");
                }
                else if((dots[1].x-dots[0].x)*(dots[2].x-dots[0].x)+(dots[1].y-dots[0].y)*(dots[2].y-dots[2].y)==0){
                    System.out.println("JikkakTriangle");
                }
                else if((dots[0].x-dots[1].x)*(dots[2].x-dots[1].x)+(dots[0].y-dots[1].y)*(dots[2].y-dots[1].y)==0){
                    System.out.println("JikkakTriangle");
                }
                else if((dots[0].x-dots[2].x)*(dots[1].x-dots[2].x)+(dots[0].y-dots[2].y)*(dots[1].y-dots[2].y)==0){
                    System.out.println("JikkakTriangle");
                }
                else{
                    System.out.println("YeahkakTriangle");
                }
           }
         
        
        
    }
    
    public static boolean checkTwoLenght(Dot a, Dot b, Dot c){
        int ab = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y); 
        int ac = (a.x - c.x) * (a.x - c.x) + (a.y - c.y) * (a.y - c.y); 
        int bc = (b.x - c.x) * (b.x - c.x) + (b.y - c.y) * (b.y - c.y);
        if(ab==ac || ab == bc || ac == bc) return true; 
        return false;
    }
    
    public static boolean checkJungTriangle(Dot a, Dot b, Dot c){
        int ab = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y); 
        int ac = (a.x - c.x) * (a.x - c.x) + (a.y - c.y) * (a.y - c.y); 
        int bc = (b.x - c.x) * (b.x - c.x) + (b.y - c.y) * (b.y - c.y); 
        
        if(ab==ac && ab == bc) return true; 
        return false;

    }
}