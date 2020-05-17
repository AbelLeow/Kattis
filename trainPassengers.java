//id: trainpassengers

class trainPassengers{
    public static void main(String[] args){

        Kattio input=new Kattio();
        
        int capacity=input.getInt();
        int stations=input.getInt();
        int current=0;

        for (int i=0;i<stations;i++){
            int leaving=input.getInt();
            int entering=input.getInt();
            int waiting=input.getInt();

            current-=leaving;
            if (current<0){ //Ensure current passengers doesn't go into negative
                System.out.print("impossible");
                return;
            }

            current+=entering;
            if(current>capacity){ //Ensure capacity isn't exceeded
                System.out.print("impossible");
                return;
            }

            if (current!=capacity && waiting!=0){ //Ensure no passengers are waiting when there's space
                System.out.print("impossible");
                return;
            }
        }

        if (current!=0){System.out.print("impossible"); }
        else{ System.out.print("possible"); } 
    }
}
