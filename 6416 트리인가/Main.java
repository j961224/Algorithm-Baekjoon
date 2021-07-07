import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int index=1;
        int x = sc.nextInt();
        int y = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(x>=0 || y>=0){
            HashMap<Integer,Integer> hm = new HashMap<>();
            int edge=0;
            while(x!=0 && y!=0){
                hm.put(x,hm.getOrDefault(x,0));
                hm.put(y,hm.getOrDefault(y,0)+1);
                edge+=1;
                x = sc.nextInt();
                y = sc.nextInt();
            }
            int root=0;
            boolean check0=true;
            for(int z : hm.keySet()){
                if(hm.get(z)==0){
                    root+=1;
                }
                else if(hm.get(z)>=2){ // 가르킴을 받는 횟수가 2개이상이면 out
                    check0=false;
                    break;
                }
            }
            
            if((check0 && edge==hm.size()-1 && root==1) || hm.size()==0){
                sb.append("Case "+index+" is a tree."+"\n");
            }
            else{
                sb.append("Case "+index+" is not a tree."+"\n");
            }
            index+=1;
            x = sc.nextInt();
            y = sc.nextInt();
        }
        
        System.out.println(sb);
    }
}