//id: grasshopper

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class grasshopper{

    static int maxValue=999999;
    public static void main(String[] args){

        Kattio input=new Kattio();

        int length, breadth;
        int startX, startY, endX, endY;

        while (input.hasMoreTokens()){

            length=input.getInt();
            breadth=input.getInt();
            startX=input.getInt()-1;
            startY=input.getInt()-1;
            endX=input.getInt()-1;
            endY=input.getInt()-1;

            int[] start={startX, startY};
            int[] end={endX, endY};

            int totalHops=hops(length,breadth,start,end);
            if (totalHops==maxValue){input.println("impossible");}
            else{input.println(totalHops);}
        }

        input.flush();
    }

    static int hops(int length, int breadth, int[] start, int[] end){

        int[][] visited=new int[length][breadth];
        int[][] distance=new int[length][breadth];

        int[] temp=new int[breadth];
        Arrays.fill(temp,maxValue);

        for (int i=0;i<length;i++){
            distance[i]=temp.clone();
        }

        distance[start[0]][start[1]]=0;

        Queue<int[]> neighbours=new LinkedList<>();

        int currX, currY;
        int neighbourX, neighbourY, neighbourDist, newDist;
        int[] curr;
        int[][] moves={ {-2,-1}, {-2,+1}, {+2, -1}, {+2, +1}, {+1, +2},{+1, -2}, {-1, +2}, {-1, -2} };

        neighbours.add(start);

        while (neighbours.size()>0){

            curr=neighbours.poll();
            currX=curr[0];
            currY=curr[1]; 

            for (int[] m:moves){

                neighbourX=currX+m[0];
                neighbourY=currY+m[1];

                if (!isWithin(length, breadth, neighbourX, neighbourY)){continue;}

                int[] temp2={neighbourX, neighbourY};

                neighbourDist=distance[neighbourX][neighbourY];

                newDist=distance[currX][currY]+1;
                if (newDist<neighbourDist){
                    distance[neighbourX][neighbourY]=newDist;
                    neighbours.add(temp2.clone());
                }

                if (temp2.equals(end)){break;}
            }
        }

        return distance[end[0]][end[1]];
    }


    static boolean isWithin(int length, int breadth, int x, int y){
        return (0<=x && x<length && 0<=y && y<breadth);
    }
}
