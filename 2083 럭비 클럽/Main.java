import java.util.*;

class info{
    String name;
    int old;
    int weight;
    public info(String name, int old, int weight){
        this.name=name;
        this.old=old;
        this.weight=weight;
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<info> arr = new ArrayList<>();
        String name = sc.next();
        int old = sc.nextInt();
        int weight = sc.nextInt();
        while(true){
            if(name.equals("#") && old==0 && weight==0){
                break;
            }
            arr.add(new info(name,old,weight));
            name=sc.next();
            old=sc.nextInt();
            weight=sc.nextInt();
        }
        for(info i : arr){
            if(i.old>17 || i.weight>=80){
                System.out.println(i.name+" "+"Senior");
            }
            else{
                System.out.println(i.name+" "+"Junior");
            }
        }
    }
}