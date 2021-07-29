import java.util.*;


class Main{
    //static int N;
    static int[] preorder = new int[100001];
    static int[] postorder = new int[100001];
    static int[] inorder = new int[100001]; 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i=0; i<N; i++){
            inorder[i]=sc.nextInt();
        }
        for(int i=0; i<N; i++){
            postorder[i]=sc.nextInt();
        }
        for(int i=0; i<N; i++){
            preorder[inorder[i]]=i;
        }
        
        dfs(0,N-1,0,N-1);
    }
    
    public static void dfs(int is, int ie, int ps, int pe){
        if(is>ie || ps>pe){
            return;
        }
        int root = postorder[pe];
        System.out.print(root+" ");
        int inroot = preorder[root]; //inorder의 root 찾기
        int left = inroot-is;
        dfs(is,inroot-1,ps,ps+left-1);//left
        dfs(inroot+1,ie,ps+left,pe-1);//right
    }
}