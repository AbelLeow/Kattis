//id: dicecup

import java.util.Arrays;
import java.util.TreeMap;
import java.util.PriorityQueue;

class diceCup{
    public static void main(String[] args){
        Kattio input=new Kattio();

        int d1=input.getInt();
        int d2=input.getInt();

        int[] temp=new int[d1+d2+1];

        TreeMap<Double,PriorityQueue<Integer>> tm=new TreeMap<Double,PriorityQueue<Integer>>();

        int total=0;
        for (int i=1;i<d1+1;i++){
            for (int j=1;j<d2+1;j++){
                temp[i+j]++;
                total++;
            }
        }

        double perc;
        for (int w=0;w<d1+d2+1;w++){
            perc=(double) temp[w]/ (double) total;
            if (!tm.containsKey(perc)){
                PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
                pq.add(w);
                tm.put(perc,pq);
            }
            else{
                tm.get(perc).add(w);
            }
        }
        
        PriorityQueue<Integer> ans=tm.lastEntry().getValue();
        while (ans.size()>0){
            input.println(ans.poll());
        }

        input.flush();
    }
}
