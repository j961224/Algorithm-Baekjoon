package dd;

import java.util.*;
//LCS -> 가장 긴 공통된 부분수열
public class Main{
  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      String arg0 = sc.nextLine();
      String arg1 = sc.nextLine();
      int k=0;
      
      int[][] matrix = new int[arg0.length()+1][arg1.length()+1];
      for(int i=0; i<arg1.length()+1; i++){
          matrix[0][i]=0;
      }
      
      
      for(int i=1; i<arg0.length()+1; i++){
          matrix[i][0]=0;
          for(int j=1; j<arg1.length()+1; j++){
              if(arg0.charAt(i-1)==arg1.charAt(j-1)){
                  matrix[i][j]=matrix[i-1][j-1]+1;
              }
              else if(arg0.charAt(i-1) != arg1.charAt(j-1)){
                  matrix[i][j]=Math.max(matrix[i-1][j],matrix[i][j-1]);
              }
              
              if(matrix[i][j]>k){
                  k=matrix[i][j];
              }
          }
      }
      
      
      System.out.println(k);
  }
}
