//id: grandpabernie

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class grandpaBernie{
    public static void main(String[] args){

        Kattio input= new Kattio();

        int countries=input.getInt();

        HashMap<String, ArrayList<Integer>> travels=new HashMap<String, ArrayList<Integer>>();

        for (int i=0;i<countries;i++){
            String country=input.getWord();
            int year=input.getInt();

            if (travels.get(country)==null){
                travels.put(country, new ArrayList<Integer>() );
            }

            travels.get(country).add(year);
        }

        for (ArrayList<Integer> years:travels.values()){
            if (years.size()>1){
            Collections.sort(years);}
        }

        int queries=input.getInt();

        for (int j=0;j<queries;j++){

            String country=input.getWord();
            int index=input.getInt();

            ArrayList<Integer> helper=travels.get(country);

            input.println(helper.get(index-1));
        }

        input.flush();
    }
}
