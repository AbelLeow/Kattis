import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;



class dominoes2{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int cases=input.getInt();

        int i,j;
        int dominoes, chains, calls, count;
        int d1,d2;
        boolean[] knockedOver;
        HashMap<Integer, ArrayList<Integer>> links;
        Queue<Integer> q=new LinkedList<>();

        for (i=0;i<cases;i++){
        
            dominoes=input.getInt();
            chains=input.getInt();
            calls=input.getInt();

            count=0;
            links=new HashMap<Integer, ArrayList<Integer>>();
            knockedOver=new boolean[dominoes];

            for (j=0;j<chains;j++){
                
                d1=input.getInt()-1;
                d2=input.getInt()-1;

                if (!links.containsKey(d1)){
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    links.put(d1,temp);
                }

                links.get(d1).add(d2);
            }

            for (j=0;j<calls;j++){

                d1=input.getInt()-1;
                
                q.add(d1);

                while (!q.isEmpty()){

                    d2=q.poll();
                    if (knockedOver[d2]){continue;}

                    knockedOver[d2]=true;
                    count++;

                    if(!links.containsKey(d2)){continue;}

                    ArrayList<Integer> temp=links.get(d2);

                    for (int k: temp){
                        q.add(k);
                    }
                }
            }

            input.println(count);

        }
        input.flush();
    }
}
