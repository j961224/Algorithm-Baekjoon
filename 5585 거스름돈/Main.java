import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] coin= {500,100,50,10,5,1};
        int money = sc.nextInt();
        int answer=0;
        money=1000-money;
        int cnt=0;
        while(true){
            if((money/coin[cnt])>=1){
                answer+=money/coin[cnt];
                money-=(money/coin[cnt])*(coin[cnt]);
            }
            if(cnt==5){
                break;
            }
            cnt++;
        }
        
        System.out.println(answer);
    }
}