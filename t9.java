//id: t9spelling

class t9{
    public static void main(String[] args){
        
        Kattio input=new Kattio();

        int cases=input.getInt();
        String[] keypads={" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; //2nd " " is a dummy so that the other letters and nums correspond

        for (int i=1;i<=cases;i++){

            String output=" "; //Creates an empty output for current testcase

            String original=input.getLine();
            int stringLen=original.length();

            for (int j=0;j<stringLen;j++){
                String letter=Character.toString(original.charAt(j)); 

                for (int s=0;s<10;s++){
                    int pos=keypads[s].indexOf(letter);
                    
                    //checks for the pos of the current letter using the above "phone" arr
                    //If it is, index s=number to press, (pos+1)=number of times to press index s
                    if (pos!=-1){
                        String whichNumber= String.valueOf(s);
                        String addOn=whichNumber;

                        for (int help=0;help<pos;help++){
                            addOn+=whichNumber;
                        }
                        
                        //Check if a space is required
                        if (needSpace(output,addOn)){output+=" "; }
                        output+=addOn;
                        break;
                    }
                }
            }
            
            //to remove the initial " " in output when it was initialised
            int outputLen=output.length();
            
            output=output.substring(1,outputLen);
            input.println("Case #"+i+": "+output);
        }
        
        input.flush();

        

    }


    //Helper function to check if a "pause" is required between each letter
    public static boolean needSpace(String a, String b){
        int aLen=a.length();
        if (a.charAt(aLen-1)==b.charAt(0)){return true; }  
        return false;
    }
}
