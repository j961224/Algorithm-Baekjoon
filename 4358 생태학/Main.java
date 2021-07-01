import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> hm = new HashMap<>();
        int size=0;
        String tmp = br.readLine();
        while(true){
            hm.put(tmp,hm.getOrDefault(tmp,0)+1);
            size++;
            tmp = br.readLine();
            if(tmp==null || tmp.length()==0){
                break;
            }
        }
        
        List<Map.Entry<String,Integer>> entries = new LinkedList<>(hm.entrySet());
        Collections.sort(entries,(o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        
        for(Map.Entry<String,Integer> entry : entries){
            double tmp1 = (double)(hm.get(entry.getKey())*100.0)/size;
            System.out.printf("%s %s",entry.getKey(),String.format("%.4f", tmp1));
            System.out.println();
        }
    }
}