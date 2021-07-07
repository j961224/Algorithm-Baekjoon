import java.util.*;
import java.io.*;

class Dot{
    int data;
    Dot leftnode;
    Dot rightnode;
    
    public Dot(int data){
        this.data=data;
    }
    
    public Dot(int data,Dot leftnode,Dot rightnode){
        this.data=data;
        this.leftnode=leftnode;
        this.rightnode=rightnode;
    }
    
    public void insert(int n){
        if(n<this.data){
            if(this.leftnode==null){
                this.leftnode=new Dot(n);
            }
            else{
                this.leftnode.insert(n);
            }
        }
        else{
            if(this.rightnode==null){
                this.rightnode=new Dot(n);
            }
            else{
                this.rightnode.insert(n);
            }
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Dot tree = new Dot(Integer.parseInt(br.readLine()));
        while(true){
            String z = br.readLine();
            if(z==null || z.equals("")){
                break;
            }
            tree.insert(Integer.parseInt(z));
        }
        
        postorder(tree);
    }
    
    public static void postorder(Dot tree){
        if(tree==null){
            return;
        }
        if(tree.leftnode!=null){
            postorder(tree.leftnode);
        }
        if(tree.rightnode!=null){
            postorder(tree.rightnode);
        }
        // postorder(tree.leftnode);
        // postorder(tree.rightnode);
        System.out.println(tree.data);
    }
}