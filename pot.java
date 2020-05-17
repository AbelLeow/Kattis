//id: pot


class pot{
    public static void main(String[] args){

        Kattio input=new Kattio(System.in);

        int n=input.getInt();
        int total=0;

        for (int i=0;i<n;i++){
            String wrong=input.getWord();
            String helper=wrong.substring(0,wrong.length()-1);
            String helper2=wrong.substring(wrong.length()-1,wrong.length());
            int originalNum=Integer.parseInt(helper);
            int origPow=Integer.parseInt(helper2);
            total+=Math.pow(originalNum,origPow);
        }
        
        System.out.print(total);
    }
}
