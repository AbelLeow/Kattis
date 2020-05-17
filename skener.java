//id: skener

class skener{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int r=input.getInt();
        int c=input.getInt();
        int Zr=input.getInt();
        int Zc=input.getInt();

        for (int i=0;i<r;i++){
            String orig=input.getLine();
            int length=orig.length();
            String helper="";
            
            for (int j=0;j<length;j++){
                for (int l=0;l<Zc;l++){
                    helper+= orig.charAt(j);
                }
            }

            for (int z=0;z<Zr;z++){
                input.println(helper);
            }
        }

        input.flush();      
    }
}
