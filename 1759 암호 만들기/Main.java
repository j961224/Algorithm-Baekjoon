import java.util.*;


class Main{
    static int N,r;
    static String[] alpha;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        r=sc.nextInt();
        N=sc.nextInt();
        sc.nextLine();
        alpha = sc.nextLine().split(" ");
        
        
        Arrays.sort(alpha);
        
        combination(0,r,"");
    }
    
    public static void combination(int start, int r, String tmp){
        if(tmp.length()==r){
            int ja=0;
            int mo=0;
            for(int i=0; i<r; i++){
                Character x = tmp.charAt(i);
                if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                    mo++;
                }
                else{
                    ja++;
                }
            }
            
            if(ja>=2 && mo>=1){
                System.out.println(tmp);
            }
            return;
        }
        
        if(alpha.length<=start){
            return;
        }
        
        combination(start+1,r,tmp+alpha[start]);
        combination(start+1,r,tmp);
    }
}