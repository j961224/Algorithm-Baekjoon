import java.util.*;


class Main{
    static ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
    static int[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //dp를 [x][0]부분은 x가 얼리어답터가 아닌 경우, [x][1]부분은 x가 얼리어답터인 경우를 의미
        dp = new int[N+1][2];
        for(int i=0; i<=N; i++){
            ar.add(new ArrayList<>());
        }
        
        for(int i=0; i<N-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //양방향
            ar.get(a).add(b);
            ar.get(b).add(a);
        }
        
        //root node를 1로 설정
        dp(1,-1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
    
    public static void dp(int start, int parent){
        dp[start][0]=0; //우선 자기 자신이 얼리어답터가 아니므로 갯수는 0 설정
        dp[start][1]=1; //자기 자신이 일단 얼리어답터이므로 갯수 1 설정
        
        for(int des : ar.get(start)){
            if(des!=parent){
                dp(des,start);
                //우선 start 자신은 얼리어답터가 아니니 des가 얼리어답터인 경우를 더해야한다.
                dp[start][0]+=dp[des][1];
                //start가 얼리어답터이므로 des는 얼리어답터여도 되고 아니어도 되니 얼리어답터 최솟값을 구하므로 min 사용
                dp[start][1]+=Math.min(dp[des][0],dp[des][1]);
            }
        }
    }
}