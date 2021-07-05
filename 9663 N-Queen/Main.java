import java.util.*;

class Main{
    static int answer, N;
    static int[] an;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        answer=0;
        an = new int[N];
        if(N==1){
            System.out.println(1);
            return;
        }
        for(int i=0; i<N; i++){
            an[i]=N+3;
        }
        for(int i=0; i<N; i++){
            DFS(0,i,an,1);
        }
        
        System.out.println(answer);
    }
    
    public static void DFS(int start,int index, int[] an, int count){
        if(start==N-1){
            if(count==N){
                answer+=1;
            }
            return;
        }
        
        an[start]=index;
        for(int i=0; i<N; i++){
            boolean check = true;
            for(int j=0; j<start+1; j++){
                if(an[j]==i || Math.abs(index-i)<2){
                    check=false;
                    break;
                }
                else if(Math.abs(start+1-j)==Math.abs(an[j]-i)){
                    check=false;
                    break;
                }
            }
            
            if(check){
                DFS(start+1,i,an,count+1);
                an[start+1]=0;
            }
        }
    }
}