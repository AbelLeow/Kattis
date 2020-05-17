//id: coconut

class Player{ 

    public boolean cracked;//Checks if coconut is cracked yet
    public boolean gameOver;
    public boolean leftSpilled;//Checks if left hand coconut is spilled
    public boolean rightSpilled;//Same except for right
    public int left; //1 for when hand is up, 0 for when it is down
    public int right;//Same as above
    public Player next;//Linked List idea
    public int playerNumber;

    public Player(int a){
        this.cracked=false;
        this.gameOver=false;
        this.leftSpilled=false;
        this.rightSpilled=false;
        this.left=1;
        this.right=1;
        this.next=null;
        this.playerNumber=a;
    }

    public void setNext(Player a){next=a;} 

    public Player getNext(){return next;}
    public int getNumber(){return playerNumber;}
    public boolean isDone(){return gameOver;} //true when player loses both hands
    public boolean isCracked(){return cracked;} //checks coconut crack status
    public int getLeft(){return left;} //returns 1 or 0 depending if hand is up or down
    public int getRight(){return right;} 

    public int checkSkip(){ //Checks how many counts the player takes
        if (!cracked){return 1;}
        else {return (left+right);}
    }

    public void update(int c){ //updates the player depending on which hand needs to be updated
        if (c==0){cracked=true;}//cracks coconut
        else{
            if (c==1){ //right hand
                if (!rightSpilled){rightSpilled=true;}
                else if (right==1){right=0;} 
            }
            else if (c==-1){ //left hand
                if (!leftSpilled){leftSpilled=true;}
                else {left=0;}
            }
        }

        if (left+right==0){gameOver=true;}
    }
}

class coconutSplat{

    public static void main(String[] args){

        Kattio input=new Kattio();
        int s=input.getInt();
        int n=input.getInt();

        Player head=new Player(1); //creates 1st entry
        Player current=head;
    
        //populates the rest
        for (int i=1;i<n;i++){
            Player temp=new Player(i+1);
            current.setNext(temp);
            current=current.getNext();
        }

        current.setNext(head);
        Player previous=current;

        current=current.getNext(); //Reset to index 0

        int helper=s;
        while (current!=current.getNext()){

            boolean c=current.isCracked();
            int l=current.getLeft();
            int r=current.getRight();

            int moves=current.checkSkip();

            helper-=moves;
    
            //0 =update crack, 1=update right, -1=update left
            if (helper==0){
                if (!c){
                    current.update(0); 
                    helper=s;
                }
                else if(l==1){
                    current.update(-1);
                    if (current.isDone()){
                        current=current.getNext();
                        previous.setNext(current);
                        helper=s;
                    }
                    else{

                        previous=current;
                        current=current.getNext();
                        helper=s;
                    }
                }

                else if(r==1){
                    current.update(1);
                    if (current.isDone()){
                        current=current.getNext();
                        previous.setNext(current);
                        helper=s;
                    }
                    else{
                        previous=current;
                        current=current.getNext();
                        helper=s;
                    }

                }
            }

            else if (helper==-1){
                current.update(1);
                if (current.getRight()==1){
                    helper=s+1;
                }
                else{helper=s;}
            }

            //if helper>0, continue on
            else{
                previous=current;
                current=current.getNext();

            }
        }
        System.out.println(current.getNumber());
    }
}




