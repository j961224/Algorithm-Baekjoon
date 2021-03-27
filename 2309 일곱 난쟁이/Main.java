import java.util.*;

class Main{
    static ArrayList<Integer> answer;
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        arr = new int[9];
        check = new boolean[9];
        answer = new ArrayList<>();
        for(int i=0; i<9; i++){
            arr[i]=sc.nextInt();
        }
        
        //Arrays.sort(arr);
        dfs(0);
    }
    
    public static void dfs(int start){
        if(answer.size()==7){
            int sum=0;
            for(int i=0; i<7; i++){
                sum+=answer.get(i);
            }
            if(sum==100){
                Collections.sort(answer);
                for(int k=0; k<7; k++){
                    System.out.println(answer.get(k));
                }
            }
            return;
        }
        
        for(int i=start; i<9; i++){
            if(!check[i]){
                check[i]=true;
                answer.add(arr[i]);
                dfs(i);
                check[i]=false;
                answer.remove(answer.size()-1);
            }
        }
    }
    
}