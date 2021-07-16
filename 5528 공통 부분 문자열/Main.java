import java.util.*;

//LCS를 생각한다면 쉽게 풀 수 있는 문제다.
//LCS는 부분 수열이 되는 수열 중 가장 긴 수열을 찾는 것이고
//이 문제는 공통 부분 문자열 중에 가장 긴 수열을 찾는 것이다.
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        
        int[][] arr = new int[a.length()+1][b.length()+1];
        int max=0;
        for(int i=1; i<=b.length(); i++){
            for(int j=1; j<=a.length(); j++){
                if(a.charAt(j-1)==b.charAt(i-1)){
                    arr[j][i]=arr[j-1][i-1]+1;
                    max = Math.max(max,arr[j][i]);
                }
            }
        }
        
        System.out.println(max);
    }
}