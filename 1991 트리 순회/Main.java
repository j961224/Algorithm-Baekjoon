import java.util.*;
import java.io.*;

class Dot{
    char data;
    Dot leftnode;
    Dot rightnode;
    public Dot(char data){
        this.data=data;
    }
}

class Tree{
    Dot root;
    
    public void create(char data, char left, char right){
        if(root==null){
            root = new Dot(data);
            
            if(left!='.'){
                root.leftnode=new Dot(left);
            }
            
            if(right!='.'){
                root.rightnode=new Dot(right);
            }
        }
        else{
            search(root,data,left,right);
        }
    }
    
    public void search(Dot root, char data, char left, char right){
        if(root==null){
            return;
        }
        
        if(root.data==data){
            if(left!='.'){
                root.leftnode = new Dot(left);
            }
            
            if(right!='.'){
                root.rightnode = new Dot(right);
            }
        }
        else{
            search(root.leftnode,data,left,right);
            search(root.rightnode,data,left,right);
        }
    }
    
    public void preorder(Dot r){
        System.out.print(r.data);
        if(r.leftnode!=null){
            preorder(r.leftnode);
        }
        if(r.rightnode!=null){
            preorder(r.rightnode);
        }
    }
    
    public void inorder(Dot r){
        if(r.leftnode!=null){
            inorder(r.leftnode);
        }
        System.out.print(r.data);
        if(r.rightnode!=null){
            inorder(r.rightnode);
        }
    }
    
    public void postorder(Dot r){
        if(r.leftnode!=null){
            postorder(r.leftnode);
        }
        if(r.rightnode!=null){
            postorder(r.rightnode);
        }
        System.out.print(r.data);
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Tree tree = new Tree();
        sc.nextLine();
        for(int i=0; i<N; i++){
            String tmp = sc.nextLine().replace(" ","");
            tree.create(tmp.charAt(0),tmp.charAt(1),tmp.charAt(2));
        }
        
        tree.preorder(tree.root);
        System.out.println();
        
        tree.inorder(tree.root);
        System.out.println();
        
        tree.postorder(tree.root);
    }
}