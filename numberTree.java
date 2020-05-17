//id: numbertree

class numberTree{
    public static void main(String[] args){
    
        Kattio input=new Kattio();
        
        int num=0;
        int h=input.getInt();
        for (int i=0;i<h+1;i++){num+=Math.pow(2,i); }
        
        String word;
        if (input.hasMoreTokens()){word=input.getWord(); }
        else{
            input.print(num);
            input.flush();
            return;
        }
        
        int length=word.length();
        int l=1;
        int r=2;
        for (int j=0;j<length;j++){
            if (word.charAt(j)=='L'){
                num-=l;
                l=l*2;
                r=l+1;
            }
            
            else{
                num-=r;
                r=r*2;
                l=r-1;
            }
        }     
        
        input.print(num);
        input.flush();
    }
}

