//id: lostmap

import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

class lostMap{
    public static void main(String[] args){

        Kattio input= new Kattio();

        int n=input.getInt();
        int[][] table=new int[n][n];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                table[i][j]=input.getInt();
            }
        }

        HashMap<Integer, ArrayList<int[]> > matrixList=new HashMap<Integer, ArrayList<int[]> >();

        for (int i=0;i<n;i++){

            matrixList.put(i, new ArrayList<int[]>());

            for (int j=0;j<n;j++){

                int neighbourDistance=table[i][j];
                if (neighbourDistance!=0){
                    int[] helper={j,neighbourDistance, i};
                    matrixList.get(i).add(helper);
                }
            }
        }

        //comes in the form of {vertex,distance}
        PriorityQueue<int[]> neighbours=new PriorityQueue<int[]>(11, new helperC());

        int[] solved=new int[n];
        int[] minDistance=new int[n];
        int[] pred=new int[n];

        Arrays.fill(pred,-1);

        int maxValue=10000000;
        Arrays.fill(minDistance,maxValue);
        minDistance[0]=0;

        ArrayList<int[]> temp=matrixList.get(0);
        for (int[] l:temp){neighbours.add(l); }

        while (neighbours.size()>0){

            int[] curr=neighbours.poll();

            int currVertex=curr[0];
            int dist=curr[1];
            int predVertex=curr[2];

            if (pred[predVertex]==currVertex){continue;}
            if (minDistance[currVertex]!=maxValue && dist!=minDistance[currVertex]){continue;}

            if (minDistance[predVertex]+dist<minDistance[currVertex]){

                minDistance[currVertex]=minDistance[predVertex]+dist;
                pred[currVertex]=predVertex;

                ArrayList<int[]> tempHelper=matrixList.get(currVertex);

                for (int[] m:tempHelper){
                    neighbours.add(m);
                }
            }
        }
 
        for (int i=0;i<n;i++){
            int prev=pred[i];
            if (prev==-1){continue;}
            int start=i+1;
            int end=prev+1;
            input.println(start+" "+end);
        }

        input.flush();
    }
}

class helperC implements Comparator<int[]>{
    public int compare(int[] c1, int[] c2){
        return Integer.compare(c1[1],c2[1]);
    }
}
