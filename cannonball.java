//id:humancannonball

import java.util.Comparator;
import java.util.PriorityQueue;

class cannonball{
    public static void main(String[] args){

        Kattio input=new Kattio();

        double x,y;

        x=input.getDouble();
        y=input.getDouble();
        double[] start={x,y}; //start pos
         
        x=input.getDouble();
        y=input.getDouble();
        double[] end={x,y}; //end pos

        //Getting cannon pos
        int n=input.getInt();
        double[][] cannons=new double[n][2];

        for (int i=0;i<n;i++){
            x=input.getDouble();
            y=input.getDouble();
            double[] helper={x,y};
            cannons[i]=helper.clone();
        }

        double[] time=new double[n+1]; //last spot is for destination vertex
        PriorityQueue<DoublePair> pq= new PriorityQueue<>(11, new helperComparator());

        double travelTime;

        for (int j=0;j<n;j++){
            double[] currV=cannons[j];
            double totalDist=distance(start,currV);
            travelTime=totalDist/5;
            time[j]=travelTime;
            DoublePair helper= new DoublePair(j, travelTime);
            pq.add(helper);
        }

        double endTime=distance(start,end)/5;
        time[n]=endTime;

        while (pq.size()>0){
            DoublePair curr=pq.poll();
            double[] currCoord=cannons[curr.getVertex()];
            double currTime=curr.getTime();

            for (int j=0;j<n;j++){
                if (j==curr.getVertex()){continue;}
                double[] neighbour=cannons[j];
                double totalDist=distance(currCoord,neighbour);
                travelTime=2+Math.abs(totalDist-50)/5;
                double totalTime=travelTime+currTime;
                //relaxation
                if (totalTime<time[j]){
                    time[j]=totalTime;
                    DoublePair newNeighbour=new DoublePair(j,totalTime);
                    pq.add(newNeighbour);
                }
            }

            double endDist=distance(currCoord,end);
            endTime=2+Math.abs(endDist-50)/5;
            double totalTime=endTime+currTime;
            if (totalTime<time[n]){time[n]=totalTime;}
        }

        System.out.print(time[n]);
    }

    static double distance(double[] c1, double[] c2){

        double c1x,c1y,c2x,c2y;
        double xDist, yDist, totalDist;

        c1x=c1[0];
        c1y=c1[1];
        c2x=c2[0];
        c2y=c2[1];

        xDist=c1x-c2x;
        yDist=c1y-c2y;
        totalDist=Math.sqrt(xDist*xDist + yDist*yDist);

        return totalDist;
    }
}


class DoublePair{
    double time;
    int vertex;

    public DoublePair(int v, double t){
        time=t;
        vertex=v;
    }

    public double getTime(){return time;}
    public int getVertex(){return vertex;}
}

class helperComparator implements Comparator<DoublePair>{
    public int compare(DoublePair a, DoublePair b){
        double timeA=a.getTime();
        double timeB=b.getTime();
        return Double.compare(timeA, timeB);
    }
}
