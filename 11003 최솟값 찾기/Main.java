import java.util.*;
import java.io.*;

class Dot{
    int cost;
    int index;
    public Dot(int cost,int index){
        this.cost=cost;
        this.index=index;
    }
}


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.valueOf(st.nextToken());
		int L = Integer.valueOf(st.nextToken());
        StringBuilder sb = new StringBuilder();
        //deque로 중간중간에 큰 값을 가진 index제거하기 위해 사용
        st = new StringTokenizer(br.readLine());
        Deque<Dot> dq = new LinkedList<>();
        for(int i=0; i<N; i++){
            int tmp = Integer.valueOf(st.nextToken());
            
            while(!dq.isEmpty() && dq.getLast().cost>tmp){
                dq.removeLast();
            }
            
            dq.addLast(new Dot(tmp,i));
            //오래 된거 삭제
            if(dq.getFirst().index<=i-L){
                dq.removeFirst();
            }
            sb.append(dq.getFirst().cost+" ");
        }
        bw.write(sb.toString());
		bw.flush();
		bw.close();
    }
}