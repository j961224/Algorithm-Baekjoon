import java.util.*;


class Main{
    static int N,M,K;
    static long[] arr;
    static long[] tree;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N=sc.nextInt();
        M=sc.nextInt();
        K=sc.nextInt();
        arr = new long[N+1];
        tree = new long[4*N];
        
        for(int i=1; i<=N; i++){
            arr[i]=sc.nextInt();
        }
        
        init(1,N,1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M+K; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a==1){
                arr[b]=c;
                update(1,N,1,b,c);
            }
            else{
                sb.append(sum(1,N,1,b,c)%1000000007+"\n");
            }
        }
        System.out.println(sb);
    }
    
    public static long init(int start, int end, int node){
        if(start==end){
            return tree[node]=arr[start];
        }
        
        int mid = (start+end)/2;
        return tree[node]=(init(start,mid,node*2)*init(mid+1,end,node*2+1))%1000000007;
    }
    
    public static long update(int start,int end, int node, int changeindex, int changevalue){
        if(changeindex<start || end<changeindex){
            return tree[node];
        }
    
        if(start==end){
            return tree[node]=changevalue;
        }
        int mid = (start+end)/2;
        return tree[node]=(update(start,mid,node*2,changeindex,changevalue)*update(mid+1,end,node*2+1,changeindex,changevalue))%1000000007;
    }
    
    public static long sum(int first, int second, int node, int start, int end){
        if(end<first || second<start){
            return 1;
        }
        
        if(start<=first && second<=end){
            return tree[node];
        }
        
        int mid = (first+second)/2;
        return (sum(first,mid,node*2,start,end)*sum(mid+1,second,node*2+1,start,end))%1000000007;
    }
}