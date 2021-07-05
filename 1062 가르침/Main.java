import java.util.*;


class Main{
    static String[] ar1;
    static boolean[] check;
    static int N,K,answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        K = sc.nextInt();
        ar1 = new String[N];
        if(K<5){
            System.out.println(0);
            return;
        }
        else if(K==26){
            System.out.println(N);
            return;
        }
        
        check = new boolean[26];
        check['a'-'a']=true;
        check['n'-'a']=true;
        check['t'-'a']=true;
        check['i'-'a']=true;
        check['c'-'a']=true;
        
        answer=0;
        sc.nextLine();
        
        for(int i=0; i<N; i++){
            String g = sc.nextLine().replaceAll("anta|tica","");
            ar1[i]=g;
        }
        

        
        DFS(0,0);
        System.out.println(answer);
    }
    
    public static void DFS(int start, int tmpk){
        if(tmpk==K-5){
            int z=0;
            for(int i=0; i<N; i++){
                boolean cc = true;
                for(int j=0; j<ar1[i].length(); j++){
                    if(!check[ar1[i].charAt(j)-'a']){
                        cc=false;
                        break;
                    }
                }
                if(cc){
                    z+=1;
                }
            }
            answer=Math.max(answer,z);
            return;
        }
        
        for(int i=start; i<26; i++){
            if(!check[i]){
                check[i]=true;
                DFS(i,tmpk+1);
                check[i]=false;
            }
        }
        
    }
}