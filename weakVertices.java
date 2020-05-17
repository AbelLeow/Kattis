//id: weakvertices

import java.util.HashMap;
import java.util.ArrayList;

class weakVertices{
    public static void main(String[] args){
    
        Kattio input=new Kattio();

        int vertices=input.getInt();
        while (vertices!=-1){

            //Adjacency List
            HashMap<Integer, ArrayList<Integer>> directNeighboursList=new HashMap<Integer,ArrayList<Integer>>();

            //Adjacency Matrix
            HashMap<Integer,int[]> oneAwayNeighbours=new HashMap<Integer,int[]>();

            int i,j;
            int helper;

            //populate directNeighbours
            for (i=0;i<vertices;i++){
            
                directNeighboursList.put(i,new ArrayList<Integer>());
                
                for (j=0;j<vertices;j++){
                    helper=input.getInt();
                    if (helper==1){directNeighboursList.get(i).add(j); }
                }
            }

            //populate oneAwayNeighbours
            for (i=0;i<vertices;i++){
            
                int[] indirect=new int[vertices];
                ArrayList<Integer> arrhelper=directNeighboursList.get(i);
                
                for (int s:arrhelper){
                    ArrayList<Integer> neighbourArrHelper=directNeighboursList.get(s);
                    for (int l:neighbourArrHelper){indirect[l]=1; }
                }

                oneAwayNeighbours.put(i,indirect.clone());
            }
            //end of preparation
            
            boolean weak;
            for (i=0;i<vertices;i++){
            
                weak=true;
                ArrayList<Integer> arrListHelper=directNeighboursList.get(i);
                for (int p:arrListHelper){
                    if(i==p){continue;}
                    if (oneAwayNeighbours.get(i)[p]==1){weak=false; break; }
                }
                
                if (weak){input.print(i +" "); }
            }
            
            input.println(" ");
            vertices=input.getInt();
        }

        input.flush();
    }
}
