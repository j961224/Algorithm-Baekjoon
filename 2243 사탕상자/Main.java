import java.util.*;
//1로 탐색 후(sum), update
//2로 그냥 update
//-> segment tree를 예상할 수 있고 
//sum 함수에게 찾을 범위를 주어 찾아야 하는데 sum에게 줄 범위를 어떻게 줄지는 이분탐색으로 주기로 결정

class Main{
    static long[] tree = new long[4*1000001];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        init(1,1000000,1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int trial = sc.nextInt();
            
            //binary search로 찾을 범위를 정한 뒤, sum으로 찾고 사탕을 차감했으니 update해줘야함.
            if(trial==1){
                long tmp = sc.nextLong();
                int num = binarysearch(1,1000000,tmp);
                sb.append(num+"\n");
                update(1,1000000,1,num,-1); //1개 차감
            }
            else if(trial==2){
                int rank = sc.nextInt();
                int number = sc.nextInt();
                
                update(1,1000000,1,rank,number);
            }
        }
        
        System.out.println(sb);
    }
    
    public static int binarysearch(int start, int end, long find){
        int s = start;
        int e = end;
        int mid=0;
        //같은 것 중에 가장 앞 순위 뽑으니 return s
        while(s<=e){
            mid = (s+e)/2;
            long z = sum(1,1000000,1,1,mid);
            
            if(z<find){
                s=mid+1;
            }
            else if(z>=find){
                e=mid-1;
            }
        }
        
        return s;
    }
    
    public static long init(int start, int end, int node){
        if(start==end){
            return tree[node]=0;
        }
        
        int mid = (start+end)/2;
        return tree[node]=init(start,mid,node*2)+init(mid+1,end,node*2+1);
    }
    
    public static long sum(int start, int end, int node, int findx, int findy){
        if(findx>end || findy<start){
            return 0;
        }
        if(findx<=start && end<=findy){
            return tree[node];
        }
        
        int mid = (start+end)/2;
        return sum(start,mid,node*2,findx,findy)+sum(mid+1,end,node*2+1,findx,findy);
    }
    
    
    public static void update(int start, int end, int node, int rank, int number){
        if(rank<start || end<rank){
            return;
        }
        
        tree[node]+=number;
        if(start==end){
            return;
        }
        
        int mid = (start+end)/2;
        update(start,mid,2*node,rank,number);
        update(mid+1,end,2*node+1,rank,number);
    }
}