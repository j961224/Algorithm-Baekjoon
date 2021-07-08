// import java.util.*;
// class Rain{
//     long year;
//     long rainy;
//     public Rain(long year, long rainy){
//         this.year=year;
//         this.rainy=rainy;
//     }
// }

// class Main{
//     static Rain[] arr;
//     static long[] tree;
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
        
//         int N = sc.nextInt();
//         arr = new Rain[N+1];
//         tree = new long[4*N];
//         for(int i=1; i<=N; i++){
//             arr[N]=new Rain(sc.nextLong(),sc.nextLong());
//         }
        
//         init(1,N,1);
//         int M = sc.nextInt();
//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<M; i++){
//             long startyear = sc.nextLong();
//             long endyear = sc.nextLong();
//             int start=0;
//             int end=0;
//             boolean check = true;
//             long startrain=0;
//             long endrain=0;
//             for(int j=0; j<N; j++){
//                 if(arr[j].year==startyear){
//                     start=j;
//                     startrain = arr[j].rainy;
//                     break;
//                 }
//             }
//             long syear = startyear;
//             for(int j1=start+1; j1<N; j1++){
//                 if(syear+1!=arr[j1].year){
//                     check=false;
//                     break;
//                 }
//                 else if(arr[j1].year==endyear){
//                     end=j1;
//                     endrain = arr[j1].rainy;
//                     break;
//                 }
//                 syear+=1;
//             }
            
//             if(!check || startrain<endrain){
//                 sb.append("false"+"\n");
//                 continue;
//             }
            
//             long t = sum(1,N,1,start+1,end-1);
//             if(t>=endrain || t>=startrain){
//                 check=false;
//             }
            
//             if(check){
//                 sb.append("true"+"\n");
//             }
//             else{
//                 sb.append("false"+"\n");
//             }
//         }
        
//         System.out.println(sb);
//     }
    
//     public static long init(int start, int end, int node){
//         if(start==end){
//             return tree[node]=arr[start].rainy;
//         }
        
//         int mid = (start+end)/2;
//         return tree[node]=Math.max(init(start,mid,node*2),init(mid+1,end,node*2+1));
//     }
    
//     public static long sum(int first,int second, int node, int starty, int endy){
//         if(starty>second || endy<first){
//             return 0;
//         }
//         if(first<=starty && endy<=second){
//             return tree[node];
//         }
        
//         int mid = (first+second)/2;
//         return Math.max(sum(first,mid,2*node,starty,endy),sum(mid+1,second,2*node,starty,endy));
//     }
// }

import java.util.*;
class Rain{
    long first;
    long second;
    public Rain(long first, long second){
        this.first=first;
        this.second=second;
    }
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Rain[] arr = new Rain[N];
        for(int i=0; i<N; i++){
            arr[i]=new Rain(sc.nextLong(),sc.nextLong());
        }
        
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            long y, x;
            long Y = -1;
            long X = -2;
            // 중간 년도 값들의 최대 저장
            long Between = -1;
            //시작값과 끝값 다 있는지 확인
            boolean ValueY = false;
            boolean ValueX = false;
            
            // 모든 년도 값들이 다 있는지 체크
            boolean NOTALL = false;
            int cnt = 0;
            y=sc.nextLong();
            x=sc.nextLong();
            for (int j = 0; j < N; ++j){
                if(arr[j].first < y) continue;
                else if(arr[j].first == y){
                    Y = arr[j].second;
                    ValueY = true;
                }
                
                else if(arr[j].first > y && arr[j].first < x){
                    if(Between<arr[j].second){
                        Between=arr[j].second;
                    }
                    cnt++;
                }
                
                else if(arr[j].first == x){
                    X = arr[j].second;
                    ValueX = true;
                    break;
                }
                else break;
            }
            if(cnt<x-y-1) NOTALL = true;
            
            // 애초에 조건 만족 안하는 경우
            if((ValueX&&Between>=X) || (ValueY&&Between>=Y) || (ValueX&&ValueY&&X>Y)){
                sb.append("false"+"\n");
                continue;
            }
            
            // x,y 가 연속된 년도인 경우
            if(y+1==x){
                // X==Y==1 인 경우도 걸러짐..!
                if(ValueX&&ValueY) sb.append("true"+"\n");
                else sb.append("maybe"+"\n");
                continue;
            }
            
            // 아래는 x,y 가 연속되지 않은 경우만 남음
            // x나 y년도 값이 1(최소) 인경우
            if(X==1 || Y==1){
                sb.append("false"+"\n");
                continue;
            }
            
            // 모르는 값이 있는 경우
            if(NOTALL||!ValueX||!ValueY){
                sb.append("maybe"+"\n");
                continue;
            }
            
            // 중간에 빠진 년도 있는경우
            if(NOTALL){
                sb.append("maybe"+"\n");
                continue;
            }
            sb.append("true"+"\n");
        }
        System.out.println(sb);
    }
}