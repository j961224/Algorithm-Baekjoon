import java.util.*;

class Main{
    static int N;
    static int max=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N=sc.nextInt();
        int[][] arr = new int[N][2];
        boolean[] check = new boolean[N];
        for(int i=0; i<N; i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                
                if(arg0[1]==arg1[1]){
                    return arg0[0]-arg1[0];
                }
                return arg0[1] - arg1[1];
            }
        });
        
        int time=0;
        int endtime=0;
        
        for(int i=0; i<N; i++){
            if(endtime<=arr[i][0]){
                endtime=arr[i][1];
                time++;
            }
        }
        
        System.out.println(time);
        
    }
}