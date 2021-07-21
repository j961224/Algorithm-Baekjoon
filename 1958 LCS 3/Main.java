import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String a = sc.nextLine();
        String b= sc.nextLine();
        String c = sc.nextLine();
        
        int[][][] arr = new int[a.length()+1][b.length()+1][c.length()+1];
        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                for(int z=1; z<=c.length(); z++){
                    if(a.charAt(i-1)==b.charAt(j-1) && b.charAt(j-1)==c.charAt(z-1)){
                        arr[i][j][z]=arr[i-1][j-1][z-1]+1;
                    }
                    else{
                        arr[i][j][z]=Math.max(arr[i-1][j][z],Math.max(arr[i][j-1][z],arr[i][j][z-1]));
                    }
                }
            }
        }
        
        System.out.println(arr[a.length()][b.length()][c.length()]);
    }
}