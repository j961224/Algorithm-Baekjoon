//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.Comparator;
import java.util.*;
//String 잘라서 배열에 넣기(split이용)
public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		
        String[] array=num.split("");//띄어쓰기 없이 한 숫자마다 짤리므로 ""사용
        
        Arrays.sort(array);
        
        for(int i=array.length-1; i>=0; i--){
            System.out.print(array[i]);
        }

    }
}