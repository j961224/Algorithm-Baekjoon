import java.util.*;

class Delivery{
    int time;
    int who;
    public Delivery(int who, int time){
        this.time=time;
        this.who=who;
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tkdals=sc.nextInt();
        int wltn=sc.nextInt();
        int totalitem=sc.nextInt();
        
        ArrayList<Delivery> ar = new ArrayList<>();
        int Bend=-1;
        int Rend=-1;
        for(int i=0; i<totalitem; i++){
            int timer = sc.nextInt();
            char w = sc.next().charAt(0);
            int ti = sc.nextInt();
            
            if(w=='B'){
                int tmp=0;
                if(timer<Bend){
                    timer=Bend;
                }
                for(int j=0; j<ti; j++){
                    ar.add(new Delivery(1,timer+(j*tkdals)));
                    tmp=timer+(j*tkdals);
                }
                Bend=tmp+tkdals;
            }
            
            if(w=='R'){
                int tmp1=0;
                if(timer<Rend){
                    timer=Rend;
                }
                for(int j=0; j<ti; j++){
                    ar.add(new Delivery(2,timer+(j*wltn)));
                    tmp1=timer+j*wltn;
                }
                Rend=tmp1+wltn;
            }
        }
        
        Collections.sort(ar,new Comparator<Delivery>() {
            @Override
            public int compare(Delivery arg0, Delivery arg1) {
                if(arg0.time==arg1.time){
                    return Integer.compare(arg0.who, arg1.who);
                }
                else{
                    return Integer.compare(arg0.time, arg1.time);
                }
            }
        });
        
        ArrayList<Integer> ar1 = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();
        for(int i=0; i<ar.size(); i++){
            if(ar.get(i).who==1){
                ar1.add(i+1);
            }
            if(ar.get(i).who==2){
                ar2.add(i+1);
            }
        }
        System.out.println(ar1.size());
        for(int i=0; i<ar1.size(); i++){
            if(ar1.size()-1==i){
                System.out.printf("%d\n",ar1.get(i));
            }
            else{
                System.out.printf("%d ",ar1.get(i));
            }
        }
        System.out.println(ar2.size());
        for(int i=0; i<ar2.size(); i++){
            if(ar2.size()-1==i){
                System.out.printf("%d\n",ar2.get(i));
            }
            else{
                System.out.printf("%d ",ar2.get(i));
            }
        }
    }
}