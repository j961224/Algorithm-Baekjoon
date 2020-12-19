import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total=0;
        int problemt=sc.nextInt();
        int smdfur=sc.nextInt();
        int maxpro=sc.nextInt();
        int tmpmaxpro=maxpro;
        int[][] maxinfo= new int[problemt][2];
        
        for(int i=0; i<problemt; i++){
            int tmp = sc.nextInt();
            int tmp1 = sc.nextInt();
            maxinfo[i][0]=tmp;
            maxinfo[i][1]=tmp1;
        }
        
        Arrays.sort(maxinfo, new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                if(arg0[1]==arg1[1]){
                    return Integer.compare(arg0[0], arg1[0]);                }
                else{
                    return Integer.compare(arg0[1], arg1[1]);
                }
            }
        });
        
        int tmpnum=0;
        for(int i=0; i<maxpro; i++){
            if(tmpmaxpro==0){
                break;
            }
            else if(smdfur>=maxinfo[i][1]){
                tmpmaxpro--;
                tmpnum++;
                total+=140;
            }
        }
        
        for(int i=tmpnum; i<problemt; i++){
            if(tmpmaxpro==0){
                break;
            }
            else if(smdfur>=maxinfo[i][0]){
                tmpmaxpro--;
                total+=100;
            }
        }
        
        System.out.println(total);
        
    }
}