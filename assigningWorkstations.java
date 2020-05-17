//id: workstations

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class assigningWorkstations{
    public static void main(String[] args){

        Kattio input= new Kattio();

        int num=input.getInt();
        int delay=input.getInt();

        Integer[][] queue=new Integer[num][2];

        for (int i=0;i<num;i++){

            int start=input.getInt();
            int end=input.getInt();
            queue[i][0]=start;
            queue[i][1]=end;

        }

        Arrays.sort(queue, new Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b){
                return Integer.compare(a[0],b[0]);
            }
        });

        PriorityQueue<Integer> working=new PriorityQueue<Integer>(); //start+end
        PriorityQueue<Integer> open=new PriorityQueue<Integer>(); //CurrentT + delay

        Queue<Integer[]> workers=new LinkedList<Integer[]>();

        for (int k=0;k<num;k++){
            workers.add(queue[k]);
        }

        int t=0;
        int ans=0;

        while (workers.size()>0){

            int enter=workers.peek()[0];
            int workTime=workers.peek()[1];

            while (working.size()!=0 && working.peek()<=t){
                int finish=working.poll();
                open.add(finish+delay);
            }

            while (open.size()!=0 && open.peek()<t){ open.poll(); }

            if (enter>t){ t=enter; continue;}

            if (open.size()!=0){
                open.poll();
                ans++;
            }

            working.add(t+workTime);
            workers.poll();

            if (workers.size()==0){break;}
            if (workers.peek()[0]==t){continue;}
            t++;
        }

        input.println(ans);
        input.flush();
    }
}

