//id: abc

import java.util.PriorityQueue;
import java.util.HashMap;

class abc{
    public static void main(String[] args){

        Kattio input=new Kattio();

        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        HashMap<String,Integer> hm=new HashMap<String, Integer>();

        pq.add(input.getInt());
        pq.add(input.getInt());
        pq.add(input.getInt());

        String word=input.getWord();

        hm.put("A",pq.poll());
        hm.put("B",pq.poll());
        hm.put("C",pq.poll());

        for (int i=0;i<3;i++){
            String letter=word.substring(i,i+1);
            input.print(hm.get(letter)+" ");
        }

        input.flush();
    }
}
