import java.util.*;
//HashSet은 Set 인터페이스의 구현 클래스입니다. 
//그렇기에 Set의 성질을 그대로 상속받습니다. 
//Set은 객체를 중복해서 저장할 수 없고 하나의 null 값만 저장할 수 있습니다. 
//또한 저장 순서가 유지되지 않습니다. 

//만약 요소의 저장 순서를 유지해야 한다면 JDK 1.4부터 제공하는 LinkedHashSet 클래스를 사용하면 됩니다.
class Main{
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    static String[][] arr;
    static HashSet<String> hs;
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        arr = new String[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                arr[i][j]=sc.next();
            }
        }
        hs = new HashSet<String>();
        String sb = new String();
        for(int i=0; i<25; i++){
            dfs(i/5,i%5,sb);
        }
        
        System.out.println(hs.size());
    }
    
    public static void dfs(int x, int y, String sb){
        if(sb.length()==6){
            hs.add(sb.toString());
        }
        else{
            for(int i=0; i<4; i++){
                int tmpx=x+xx[i];
                int tmpy=y+yy[i];
                if(tmpx>=0 && tmpx<5 && tmpy>=0 && tmpy<5){
                    dfs(tmpx,tmpy,sb+arr[tmpx][tmpy]);
                }
            }
        }
    }
}