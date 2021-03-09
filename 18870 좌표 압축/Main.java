import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//interface 구현을 통한 문제 접근과 hashmap으로 접근
//출력때 하나씩 출력하는거 보다 stringbuilder로 출력값을 다 묶은 뒤에 한번에 sb.toString()으로 출력하는 것이 시간 절약이 될 수 있다.
class Dot implements Comparable<Dot>{
    int size;
    int index;
    Dot(int size, int index){
        this.size=size;
        this.index=index;
    }
    
    @Override
    public int compareTo(Dot d){
        return this.size-d.size; //size별로 오름차순
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        ArrayList<Dot> ar = new ArrayList<>();
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            ar.add(new Dot(Integer.parseInt(input[i]),i));
        }
        
        Collections.sort(ar);
        int N1=-1;
        int cnt=Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            Dot tmp = ar.get(i);
            if(cnt<tmp.size){
                N1++;
                cnt=tmp.size;
                answer[tmp.index]=N1;
            }
            else if(cnt==tmp.size){
                answer[tmp.index]=N1;
            }
        }
    
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb.toString());
        
    }
}

// class Main{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int N=sc.nextInt();
//         int[] arr = new int[N];
//         int[] cl = new int[N];
//         for(int i=0; i<N; i++){
//             arr[i]=sc.nextInt();
//             cl[i]=arr[i];
//         }
        
//         Arrays.sort(cl);
//         HashMap<Integer,Integer> hm = new HashMap<>();
//         int N1=0;
//         for(int i=0; i<N; i++){
//             if(!hm.containsKey(cl[i])){
//                 hm.put(cl[i],N1);
//                 N1+=1;
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<N; i++){
//             sb.append(hm.get(arr[i])).append(' ');
//         }
//         System.out.println(sb.toString());
//     } 
// }