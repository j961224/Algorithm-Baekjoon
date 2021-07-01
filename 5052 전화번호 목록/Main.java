import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            int M = Integer.parseInt(br.readLine());
            String[] number = new String[M];
            for(int j=0; j<M; j++){
                number[j]=br.readLine(); 
            }
            
            boolean check =false;
            Arrays.sort(number,new Comparator<String>(){
                @Override
                public int compare(String o1, String o2){
                    return o1.compareTo(o2); //사전순
                }
            });
            
            for(int j=1; j<M; j++){
                if(number[j].startsWith(number[j-1])){
                    check=true;
                    break;
                }
            }
            
            System.out.println(check==false?"YES":"NO");
        }
    }
}