package s;

//�Է��� ���� �������� �� null�� �����ϴ� �� BufferedReader.readLine�̰�, 
//Scanner.nextLine�� �� ��� NoSuchElementException�� ������.
//1 5 2 6 3 7 4 => �ϳ��� StringTokenizer�� �޾Ƽ� �ϳ��� �ڸ���.
//nextLine�� ���� ���ڰ� �ƹ��͵� ������, nextLine�� �� ���ڿ��� ������. 
//nextLine�� null�� �������� ����
import java.io.*;
import java.util.*;

public class Main{
 static int[][] src;
 public static void main(String[] args) throws Exception {
     BufferedReader v = new BufferedReader(new InputStreamReader(System.in));
     
     StringTokenizer str = new StringTokenizer(v.readLine());
     int N = Integer.parseInt(str.nextToken());
     int M = Integer.parseInt(str.nextToken());
     src = new int[N][2];
     
     str = new StringTokenizer(v.readLine());
     for(int j=0; j<N; j++){
         
         src[j][0]=Integer.parseInt(str.nextToken());
         src[j][1]=j+1;
     }
     
     Arrays.sort(src, new Comparator<int[]>() {
         @Override
         public int compare(int[] arg0, int[] arg1) {
             return Integer.compare(arg0[0], arg1[0]);
         }
     });
     
     while(M > 0){
         str = new StringTokenizer(v.readLine());
         int a = Integer.parseInt(str.nextToken());
         int b = Integer.parseInt(str.nextToken());
         int c = Integer.parseInt(str.nextToken());
         System.out.println(cal(a,b,c));    
         M=M-1;
     }
     v.close();
 }
 public static int cal(int a, int b, int c){
     int k=0;
     int result=0;
     for (int j = 0; j < src.length; j++){
         if(src[j][1]>=a && src[j][1]<=b){
             k++;
         }
         if(c==k){
             result=src[j][0];
             break;
         }
     }
     return result;
 }
 
 
 
 
}
