//id: virtualfriends

import java.util.HashMap;

class virtualFriends{
    public static void main(String[] args){

        Kattio input=new Kattio();
        int testCase=input.getInt();

        for (int i=0;i<testCase;i++){

            int friendShip=input.getInt();

            UFDS helper=new UFDS(friendShip*2);

            HashMap<String, Integer> hm=new HashMap<String, Integer>();
            int counter=0;
            int numA,numB;

            for (int j=0;j<friendShip;j++){
                String personA=input.getWord();
                String personB=input.getWord();
                if (hm.get(personA)==null){
                    hm.put(personA,counter);
                    numA=counter;
                    counter++;
                }
                
                else{numA=hm.get(personA); }

                if (hm.get(personB)==null){
                    hm.put(personB,counter);
                    numB=counter;
                    counter++;
                }
                
                else{numB=hm.get(personB); }

                helper.unionSet(numA,numB);
                int ans=helper.getSize(helper.findSet(numA));
                input.println(ans);
            }
        }

        input.flush();
    }
}
