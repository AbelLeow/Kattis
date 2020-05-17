//id: chartingprogress

class chartingProgress{

    public static void main(String[] args){

        Kattio input= new Kattio();
        
        int count=0;
        
        while (input.hasMoreTokens()){

            String line=input.getWord();
            int length=line.length();

            int total=counter(line);
            count+=total;
            int front=length-count;
            int back=length-front-total;

            for (int i=0;i<front;i++){ input.print("."); }
            
            for (int j=0;j<total;j++){ input.print("*"); }
            
            for (int k=0;k<back;k++){ input.print("."); }

            input.println("");
            
            if (count==length){
                input.println("");
                count=0;
            }
        }
        input.flush();
    }



    public static int counter(String line){
        int n=0;
        for (int i=0;i<line.length();i++){
            if (line.charAt(i)=='*'){ n++; }
        }
        return n;
    }
}
