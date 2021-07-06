import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        int[] check = new int[26];
        String[] ar = new String[N];
        for(int i=0; i<N; i++){
            ar[i]=sc.nextLine();
        }
        
        for(int i=0; i<N; i++){
            int leng = (int)Math.pow(10,ar[i].length()-1);
            for(int j=0; j<ar[i].length(); j++){
                if(leng==0){
                    break;
                }
                check[ar[i].charAt(j)-'A']+=leng;
                leng/=10;
            }
        }
        
        Arrays.sort(check);
        int num=9;
        int answer=0;
        for(int i=check.length-1; i>0; i--){
            if(check[i]==0){
                break;
            }
            answer+=check[i]*num;
            num-=1;
        }
        
        System.out.println(answer);
    }
}