import java.util.*;

class Position{
    int x;
    int y;
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main{
    static String[] move = {"R","RB","B","LB","L","LT","T","RT"};
    static int[] move_x = {1,1,0,-1,-1,-1,0,1};
    static int[] move_y = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] start = sc.nextLine().split(" ");
        int k_x = (int)start[0].charAt(0)-65;
        int d_x = (int)start[1].charAt(0)-65;
        int k_y = 8-((int)start[0].charAt(1)-48);
        int d_y = 8-((int)start[1].charAt(1)-48);
        
        Position position_King = new Position(k_x,k_y);
        Position position_Doll = new Position(d_x,d_y);
        
        int cnt = Integer.parseInt(start[2]);
        
        for(int i=0; i<cnt; i++){
            String moving = sc.nextLine();
            
            for(int j=0; j<move.length; j++){
                if(move[j].equals(moving)){
                    int tmpx = position_King.x+move_x[j];
                    int tmpy = position_King.y+move_y[j];

                    if(tmpx>=0 && tmpx<8 && tmpy>=0 && tmpy<8){
                        
                        if(tmpx==position_Doll.x && tmpy==position_Doll.y){
                            int tmpxx = position_Doll.x+move_x[j];
                            int tmpyy = position_Doll.y+move_y[j];
                            if(tmpxx<0 || tmpxx>=8 || tmpyy<0 || tmpyy>=8){
                                break;
                            }
                            position_Doll = new Position(tmpxx,tmpyy);
                        }
                        position_King = new Position(tmpx,tmpy);
                    }
                    
                    break;
                }
            }
        }
        
        String answerKing="";
        String answerDoll="";
        answerKing+=(char)(position_King.x+65);
        answerDoll+=(char)(position_Doll.x+65);
        
        answerKing+=Integer.toString(8-position_King.y);
        answerDoll+=Integer.toString(8-position_Doll.y);
        
        System.out.println(answerKing);
        System.out.println(answerDoll);
    }
}