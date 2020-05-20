//id: basicprogramming2

import java.util.HashMap;
import java.util.Arrays;
import java.util.PriorityQueue;

class basicP2{
    public static void main(String[] args){

        Kattio input=new Kattio();
        int n=input.getInt();
        int t=input.getInt();

        int i, number;
        HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();

        if (t==1){
            boolean yes=false;

            for (i=0;i<n;i++){

                number=input.getInt();
                if (7777-number!=number && hm.containsKey(7777-number)){
                    yes=true;
                    break;
                }

                hm.put(number,0);
            }

            if (yes){input.println("yes");}
            else{input.println("no");}
        }
        
        else if(t==2){
            for (i=0;i<n;i++){
                number=input.getInt();
                if (hm.containsKey(number)){input.println("Contains duplicate"); input.flush(); return;}

                hm.put(number,0);
            }

            input.println("Unique");
        }

        else if(t==3){

            int baseTimes=n/2;
            for (i=0;i<n;i++){
                number=input.getInt();
                if (!hm.containsKey(number)){hm.put(number,0); }

                hm.put(number, hm.get(number)+1);
            }

            for (int l: hm.keySet()){
                if (hm.get(l)>baseTimes){input.println(l); input.flush(); return;}
            }

            input.println(-1);
        }

        else if(t==4){

            int[] helperArr=new int[n];
            for (i=0;i<n;i++){
                helperArr[i]=input.getInt();
            }

            Arrays.sort(helperArr);
            if (n%2!=0){
                input.println(helperArr[n/2]);
            }

            else{
                input.print(helperArr[(n/2)-1]+" ");
                input.println(helperArr[n/2]);
            }
        }

        else if(t==5){

            PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
            for (i=0;i<n;i++){
                number=input.getInt();
                if (100<=number && number<=999){pq.add(number);}
            }

            while(!pq.isEmpty()){
                input.print(pq.poll()+" ");
            }
        }

        input.flush();
    }
}
