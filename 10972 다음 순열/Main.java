// import java.util.*;
// 시간 초과!
// class Main{
//     static boolean[] check;
//     static int[] answer;
//     static StringBuilder sb;
//     static StringBuilder compare_find;
//     static int sure;
//     static int N;
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
        
//         N = sc.nextInt();
//         check = new boolean[N+1];
//         answer = new int[N];
//         sb = new StringBuilder();
//         compare_find = new StringBuilder();
        
//         for(int i=0; i<N; i++){
//             compare_find.append(sc.nextInt()).append(" ");
//         }
        
//         sure=0;
//         permutation(0);
        
//         if(sure==1){
//             System.out.println(-1);
//             return;
//         }
//         System.out.println(sb);
//     }
    
//     public static void permutation(int start){
//         if(start == N){
//             StringBuilder tmp = new StringBuilder();
//             for(int i=0; i<N; i++){
//                 tmp.append(answer[i]).append(" ");
//             }
            
//             if(sure==1){
//                 sb = tmp;
//                 sure=2;
//                 return;
//             }
            
//             else if(sure==0){
//                 if(tmp.toString().equals(compare_find.toString())){
//                     sure=1;
//                 }
//             }
//         }
        
//         else{
//             for(int i=0; i<N; i++){
//                 if(!check[i]){
//                     check[i]=true;
//                     answer[start]=i+1;
//                     permutation(start+1);
//                     check[i]=false;
//                 }
//             }
//         }
//     }
// }

import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        
        if(nextPermutation(arr)){
            for(int i=0; i<N; i++){
                System.out.print(arr[i]+" ");
            }
        }
        else{
            System.out.println(-1);
        }
    }
    
    public static boolean nextPermutation(int[] arr){
        int a = arr.length-1;
        while(a>0 && arr[a-1]>=arr[a]){
            a--;
        }
        if(a==0){
            return false;
        }
        
        int b = arr.length-1;
        while(arr[a-1]>=arr[b]){
            b--;
        }
        
        int tmp = arr[a-1];
        arr[a-1] = arr[b];
        arr[b] = tmp;
        
        int start = a;
        int end = arr.length-1;
        while(start<end){
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        return true;
    }
}