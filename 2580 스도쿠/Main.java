import java.util.*;
class Dot{
    int x;
    int y;
    public Dot(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main{
    static int[][] sudo;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Dot> ar = new ArrayList<>();
        sudo = new int[9][9];
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                sudo[i][j]=sc.nextInt();
                if(sudo[i][j]==0){
                    ar.add(new Dot(i,j));
                }
            }
        }
        
        DFS(ar,0);
    }
    
    public static void DFS(ArrayList<Dot> ar , int index){
        if(index==ar.size()){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.printf("%d ",sudo[i][j]);
                }
                if(i!=8){
                    System.out.println();
                }
            }
            System.exit(0);
        }
        
        for(int i=1; i<10; i++){
            if(checkrow(ar,index,i) && checkcol(ar,index,i) && checkbound(ar,index,i)){
                sudo[ar.get(index).x][ar.get(index).y]=i;
                DFS(ar,index+1);
            }
            if(i==9){
                sudo[ar.get(index).x][ar.get(index).y]=0;
            }
        }
    }
    
    public static boolean checkrow(ArrayList<Dot> ar , int index, int num){
        
        for(int i=0; i<9; i++){
            if(ar.get(index).y!=i){
                if(sudo[ar.get(index).x][i]==num){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean checkcol(ArrayList<Dot> ar , int index, int num){
        
        for(int i=0; i<9; i++){
            if(ar.get(index).x!=i){
                if(sudo[i][ar.get(index).y]==num){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean checkbound(ArrayList<Dot> ar , int index, int num){
        
        int xx = (ar.get(index).x/3)*3;
        int yy = (ar.get(index).y/3)*3;
        for(int i=xx; i<xx+3; i++){
            for(int j=yy; j<yy+3; j++){
                if(i!=ar.get(index).x && j!=ar.get(index).y && sudo[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}