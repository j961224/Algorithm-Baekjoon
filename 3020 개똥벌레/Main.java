import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int H = sc.nextInt();
        int[] botton = new int[H+1];
        int[] top = new int[H+1];
        
        for(int i=0; i<N/2; i++){
            botton[sc.nextInt()]+=1;
            top[sc.nextInt()]+=1;
        }
        
        int min = N;
        int cnt=0;
        int[] botsum = new int[H+1];
        int[] topsum = new int[H+1];
        //누적 합 완료
        for(int i=1; i<H+1; i++){
            botsum[i]=botsum[i-1]+botton[i];
            topsum[i]=topsum[i-1]+top[i];
        }
        
        for(int i=1; i<H+1; i++){
            int value = 0;
            value+=botsum[H]-botsum[i-1];
            value+=topsum[H]-topsum[H-i];
            
            if(min>value){
                min=value;
                cnt=1;
            }
            else if(min==value){
                cnt+=1;
            }
        }
        
        System.out.printf("%d %d",min,cnt);
    }
}