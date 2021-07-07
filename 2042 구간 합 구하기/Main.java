import java.util.*;

//Segment Tree는 연속적으로 존재하는 특정 범위의 데이터 합을 구하는데 유용
class Main{
    static int N,M,K;
    static long[] tree;
    static long[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N =sc.nextInt();
        M =sc.nextInt();
        K =sc.nextInt();
        tree = new long[4*N];
        arr = new long[N+1];
        for(int i=1; i<=N; i++){
            arr[i]=sc.nextLong();
        }
        
        //구간 합 트리 생성
        init(1,N,1);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<K+M; i++){
            int decision = sc.nextInt();
            int changeindex = sc.nextInt();
            long changecost = sc.nextLong();
            //1일 때는 값만 바꾼다.
            if(decision == 1){
                long cc = changecost-arr[changeindex];
                arr[changeindex]=changecost;
                update(1,N,1,changeindex,cc);
            }
            else if(decision == 2){
                sb.append(sum(1,N,1,changeindex,(int)changecost)+"\n");
            }
        }
        System.out.println(sb);
    }
    
    public static long init(int start, int end, int node){
        if(start==end){
            return tree[node]=arr[start];
        }
        
        int mid = (start+end)/2;
        return tree[node]=init(start,mid,node*2)+init(mid+1,end,node*2+1);
    }
    
    public static void update(int start, int end, int node, int cindex, long ccost){
        if(cindex<start || end<cindex){
            return;
        }
        
        tree[node]+=ccost;
        if(start==end){
            return;
        }
        int mid = (start+end)/2;
        update(start,mid,node*2,cindex,ccost);
        update(mid+1,end,node*2+1,cindex,ccost);
    }
    
    public static long sum(int start, int end, int node, int left, int right){
        if(left>end || right<start){
            return 0;
        }
        if(left<=start && end<=right){
            return tree[node];
        }
        
        int mid = (start+end)/2;
        return sum(start,mid,node*2,left,right)+sum(mid+1,end,node*2+1,left,right);
    }
}