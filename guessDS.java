//id: guessthedatastructure

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.Comparator;
import java.util.LinkedList;

class guessDS{
    public static void main(String[] args){

        Kattio input=new Kattio();

        while (input.hasMoreTokens()){

            int runs=input.getInt();
            Queue<Integer> q=new LinkedList<>();
            Stack<Integer> s=new Stack<Integer>();
            PriorityQueue<Integer> pq=new PriorityQueue<Integer>(11, Comparator.reverseOrder());

            boolean is_q=true;
            boolean is_s=true;
            boolean is_pq=true;

            for (int i=0;i<runs;i++){

                int cmd=input.getInt();
                int value=input.getInt();

                if (cmd==1){
                    q.add(value);
                    s.add(value);
                    pq.add(value);
                }

                else{
                    if (is_q){
                        if (q.size()==0){ is_q=false;}
                        else if (q.peek()!=value){
                            is_q=false;
                        }
                        else{ q.remove();}
                    }

                    if (is_s){
                        if (s.size()==0){is_s=false;}

                        else if (s.peek()!=value){
                            is_s=false;
                        }
                        else{s.pop();}
                    }

                    if (is_pq){
                        if (pq.size()==0){is_pq=false;}
                        else if (pq.peek()!=value){
                            is_pq=false;
                        }
                        else{pq.remove();}
                    }
                }
            }

            int count=0;
            if (is_pq){count++;}
            if (is_q){count++;}
            if (is_s){count++;}

            if (count>1){input.println("not sure");}
            else if (is_pq){input.println("priority queue");}
            else if (is_q){input.println("queue");}
            else if (is_s){input.println("stack");}
            else {input.println("impossible");}

        }

        input.flush();
    }

}
