//id: sortofsorting

import java.util.Comparator;
import java.util.Arrays;

class sortOfSorting{
    public static void main(String[] args){
    
        Kattio input=new Kattio();
        
        int totalNames=input.getInt();
        while (true){

            if (totalNames==0){break;}

            String[] names=new String[totalNames];

            //Populating names arr
            for (int i=0;i<totalNames;i++){
                String name=input.getLine();
                names[i]=name;
            }
          
            Arrays.sort(names, new Comparator<String>(){
                public int compare(String a, String b){
                    return a.substring(0,2).compareTo(b.substring(0,2));
                }
            });

            for (int j=0;j<totalNames;j++){input.println(names[j]); }

            totalNames=input.getInt();
            
            if (totalNames==0){break;}

            input.println(" ");
        }
        
        input.flush();
    }
}
