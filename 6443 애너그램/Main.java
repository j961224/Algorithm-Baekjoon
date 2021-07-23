import java.util.*;

class Main{
    static char[] arr;
    static int K;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<N; i++){
            String tmp = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            K=tmp.length();
            arr = new char[K];
            for(int j=0; j<K; j++){
                arr[j]=tmp.charAt(j);
            }
            Arrays.sort(arr);
            for(int j=0; j<K; j++){
                sb.append(arr[j]);
            }
            sb.append("\n");
            
            while(permutation(arr)){
                for(int j=0; j<K; j++){
                    sb.append(arr[j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
    //오름차순으로 정렬했으므로
    public static boolean permutation(char[] arr){
        int i=arr.length-1;
        while(i>0 && arr[i]<=arr[i-1]){
            i--;
        }
        if(i<=0){
            return false;
        }
        int j = arr.length-1;
        while(j>0 && arr[i-1]>=arr[j]){
            j--;
        }
        
        char tmp = arr[j];
        arr[j]=arr[i-1];
        arr[i-1]=tmp;
        j = arr.length-1;
        while(i<j){
            tmp=arr[j];
            arr[j]=arr[i];
            arr[i]=tmp;
            i+=1;
            j-=1;
        }
        return true;
    }
}