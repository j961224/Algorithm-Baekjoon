import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        sc.nextLine();
        for(int i=0; i<N; i++){
            String[] z = sc.nextLine().split(" ");
            A[i]=Integer.parseInt(z[0]);
            B[i]=Integer.parseInt(z[1]);
            C[i]=Integer.parseInt(z[2]);
            D[i]=Integer.parseInt(z[3]);
        }
        
        int[] AB = new int[N*N];
        int[] CD = new int[N*N];
        int c=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                AB[c]=A[i]+B[j];
                CD[c]=C[i]+D[j];
                c+=1;
            }
        }
        
        Arrays.sort(AB);
        Arrays.sort(CD);
        
        int ab=0;
        int cd=CD.length-1;
        long ans=0;
        while(ab<AB.length && cd>=0){
            int tmpab = AB[ab];
            int tmpcd = CD[cd];
            long abcount=0;
            long cdcount=0;
            if(tmpab+tmpcd==0){
                while(ab<AB.length && tmpab==AB[ab]){
                    ab++;
                    abcount++;
                }
                while(cd>=0 && tmpcd==CD[cd]){
                    cd--;
                    cdcount++;
                }
                ans+=abcount*cdcount;
            }
            
            else if(tmpab+tmpcd>0){
                cd--;
            }
            else if(tmpab+tmpcd<0){
                ab++;
            }
        }
        
        System.out.println(ans);
    }
}