import java.util.*;
class Trial{
    int x;
    int trials;
    public Trial(int x, int trials){
        this.x=x;
        this.trials=trials;
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        String z = Integer.toString(N);
        int answer = -1;
        boolean[][] check = new boolean[1000001][11];
        Queue<Trial> qu = new LinkedList<>();
        qu.add(new Trial(N,0));
        check[N][0]=true;
        while(!qu.isEmpty()){
            if(qu.peek().trials==K){
                break;
            }
            
            Trial tmp = qu.poll();
            for(int i=0; i<z.length()-1; i++){
                for(int j=i+1; j<z.length(); j++){
                    int sol = solve(tmp.x,i,j);
                    if(sol!=-1 && !check[sol][tmp.trials+1]){
                        check[sol][tmp.trials+1]=true;
                        qu.add(new Trial(sol,tmp.trials+1));
                    }
                }
            }
        }
        
        while(!qu.isEmpty()){
            Trial z1 = qu.poll();
            if(answer<z1.x){
                answer=z1.x;
            }
        }
        System.out.println(answer);
    }
    
    public static int solve(int num, int i, int j){
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        if(i==0 &&sb.charAt(j)=='0'){
            return -1;
        }
        
        char tz = sb.charAt(j);
        sb.setCharAt(j,sb.charAt(i));
        sb.setCharAt(i,tz);
        return Integer.parseInt(sb.toString());
    }
}