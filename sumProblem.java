//id: sumkindofproblem

class extra{
    public static void main(String[] args){

        Kattio input=new Kattio();
        
        int runs=input.getInt();
        for (int i=0;i<runs;i++){
            int current=input.getInt();
            int count=input.getInt();
            int first=pos(count);
            int sec=odd(count);
            int third=even(count);
            input.println(current+" "+first+" "+sec+" "+third);
        }
        
        input.flush();
    }

    public static int pos(int n){
        int total=0;
        for (int i=1;i<=n;i++){total+=i; }
        return total;
    }

    public static int odd(int n){
        int total=0;
        for (int i=1;i<=n;i++){ total+=((i*2)-1); }
        return total;
    }

    public static int even(int n){
        int total=0;
        for (int i=1;i<=n;i++){total+=i*2; }
        return total;
    }
}
