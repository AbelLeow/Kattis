//id: statistics

class statistics{
    public static void main(String[] args){

        Kattio input=new Kattio();
        
        int num=1;
        int check;
        while (input.hasMoreTokens()){
            int count=input.getInt();
            int big=input.getInt();
            int small=big;
            for (int i=1;i<count;i++){
                check=input.getInt();
                
                if (check>big){
                    big=check;
                }
                
                else if (check<small){
                    small=check;
                }
            }
            
            int range=big-small;
            input.println("Case "+num+": "+small+" "+big+" "+range);
            num++;
        }
        
        input.flush();    
    }
}
