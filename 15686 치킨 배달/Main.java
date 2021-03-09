import java.util.*;
class Home{
    int x;
    int y;
    Home(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main{
    static int[][] array;
    static ArrayList<Home> chicken;
    static ArrayList<Home> house;
    static Stack<Home> st;
    static int distance;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N=sc.nextInt();
        int M=sc.nextInt();
        chicken=new ArrayList<>();
        house= new ArrayList<>();
        st=new Stack<>();
        distance=Integer.MAX_VALUE;
        array=new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                array[i][j]=sc.nextInt();
                if(array[i][j]==1){
                    house.add(new Home(i,j));
                }
                if(array[i][j]==2){
                    chicken.add(new Home(i,j));
                }
            }
        }
        
        dfs(0,M,0);
        System.out.println(distance);
    }
    
    public static void dfs(int start, int M, int cnt){
        if(cnt==M){
            caldistance();
            return;
        }
        for(int i=start; i<chicken.size(); i++){
            st.add(chicken.get(i));
            dfs(i+1,M,cnt+1);
            st.pop();
        }
    }
    
    public static void caldistance(){
        int total=0;
        for(Home house1 : house){
            int dist=Integer.MAX_VALUE;
            for(Home chic : st){
                int di = Math.abs(house1.x-chic.x)+Math.abs(house1.y-chic.y);
                if(dist>di){
                    dist=di;
                }
            }
            total+=dist;
            
            if(total>distance){
                return;
            }
        }
        distance=Math.min(total,distance);
    }
}