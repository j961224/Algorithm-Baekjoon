import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i]=sc.nextInt();
        }
        
        int M = sc.nextInt();
        int[] B = new int[M];
        for(int i=0; i<M; i++){
            B[i]=sc.nextInt();
        }
        
        //A합의 경우들(중복된 원소 합 없이)
        ArrayList<Integer> sumA = new ArrayList<>();
        for(int i=0; i<N; i++){
            int tmp = A[i];
            sumA.add(tmp);
            for(int j=i+1; j<N; j++){
                tmp+=A[j];
                sumA.add(tmp);
            }
        }
        
        //B합의 경우들(중복된 원소 합 없이)
        ArrayList<Integer> sumB = new ArrayList<>();
        for(int i=0; i<M; i++){
            int tmp = B[i];
            sumB.add(tmp);
            for(int j=i+1; j<M; j++){
                tmp+=B[j];
                sumB.add(tmp);
            }
        }
        
        //합 정렬
        Collections.sort(sumA);
        Collections.sort(sumB);
        
        int Asize = sumA.size();
        int Bsize = sumB.size();
        
        //A는 작은 곳부터 오고 B는 큰곳에서 내려온다. (binary search)
        int ac = 0;
        int bc = Bsize-1;
        long ans = 0;
        
        while(ac<Asize && bc>=0){
            int tmpA=sumA.get(ac);
            int tmpB=sumB.get(bc);
            long Acount =0;
            long Bcount =0;
            
            if(tmpA+tmpB==T){
                while(ac<Asize && sumA.get(ac)==tmpA){
                    ac++;
                    Acount++;
                }
                while(bc>=0 && sumB.get(bc)==tmpB){
                    bc--;
                    Bcount++;
                }
                
                ans+=Acount*Bcount;
            }
            
            else if(tmpA+tmpB>T){
                bc--;
            }
            else if(tmpA+tmpB<T){
                ac++;
            }
        }
        
        System.out.println(ans);
    }
}