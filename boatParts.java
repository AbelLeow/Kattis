//id: boatparts

import java.util.HashMap;

class boatParts{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int p=input.getInt();
        int n=input.getInt();
        int day=-1;
        
        HashMap<String,Integer> helper=new HashMap<String, Integer>();

        for (int i=0;i<n;i++){
            String part=input.getWord();
            if (helper.get(part)==null){

                helper.put(part,1);

                if (helper.size()==p){ day=i+1; break; }

            }
        }

        if (day==-1){ System.out.print("paradox avoided"); }
        else{ System.out.print(day); }

    }
}
