//id: sibice

class sibice{
    public static void main(String[] args){
        Kattio input=new Kattio();

        int n=input.getInt();
        int w=input.getInt();
        int h=input.getInt();

        double maxLength=Math.sqrt(w*w+h*h);

        for (int i=0;i<n;i++){
        
            int m=input.getInt();
            
            if (m<=maxLength){
                input.println("DA");
            }
            
            else{input.println("NE");}
        }
        
        input.flush();
    }
}
