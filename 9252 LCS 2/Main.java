import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String a = sc.nextLine();
        String b = sc.nextLine();
        
        int[][] arr = new int[a.length()+1][b.length()+1];
        
        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1]+1;
                }
                else{
                    if(arr[i-1][j]>arr[i][j-1]){
                        arr[i][j]=arr[i-1][j];
                    }
                    else{
                        arr[i][j]=arr[i][j-1];
                    }
                }
            }
        }
        
        
        System.out.println(arr[a.length()][b.length()]);
        int z = a.length();
        int z1 = b.length();
        Stack<Character> st = new Stack();
        while(z>=1 && z1>=1){
            //y라인과 같다면 a와 b가 같은 부분이 있어 같은 것이 아니므로 y쪽 감소
            if(arr[z][z1]==arr[z][z1-1]){
                z1--;
            }
            //x라인과 같다면 a와 b가 같은 부분이 있어 같은 것이 아니므로 x쪽 감소
            else if(arr[z][z1]==arr[z-1][z1]){
                z--;
            }
            else{
                //이 경우는 같은 경우 대각선으로 증가시켰으므로 반대로 내려가니 z-1 부분 저장
                st.add(a.charAt(z-1));
                z1--;
                z--;
            }
        }
        
        while(!st.isEmpty()){
            System.out.print(st.pop());
        }
    }
}