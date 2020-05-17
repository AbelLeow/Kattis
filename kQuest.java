//id: kattissquest

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Comparator;

class kQuest{
    public static void main(String[] args){

        Kattio input=new Kattio();
        int n=input.getInt();

        TreeMap<Integer, PriorityQueue<Integer>> hm=new TreeMap<Integer, PriorityQueue<Integer>>();

        for (int i=0;i<n;i++){

            String cmd=input.getWord();

            if (cmd.charAt(0)=='a'){ //add command
                int energy=input.getInt();
                int gold=input.getInt();

                if (hm.get(energy)==null){//if hm doesn't contain, create new hm entry
                    PriorityQueue<Integer> pq=new PriorityQueue<Integer>(11, Comparator.reverseOrder());
                    pq.add(gold);
                    hm.put(energy,pq);
                }  

                else{ //if it does, add a new node to the back
                    hm.get(energy).add(gold);
                } 
            }

            else{ //query command
                int x=input.getInt(); //Total energy left
                int e=x;              //hm key
                long gold=0;

                while (e>0 && x>0){
                    if (hm.get(e)==null){
                        if (hm.floorKey(e)!=null){e=hm.floorKey(e);}
                        else{e=0;}
                    }

                    else{
                        PriorityQueue<Integer> helper=hm.get(e);
                        while (helper.size()>0 && x>=e){
                            gold+=helper.poll();
                            x-=e;
                        }

                        if (helper.size()==0){hm.remove(e);}
                        if (hm.floorKey(x)==null){e=0;}
                        else{e=hm.floorKey(x);}
                    }
                }

                input.println(gold);
            }
        }

        input.flush();
    }
}
