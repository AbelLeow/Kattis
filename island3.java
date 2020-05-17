//id: island3

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Arrays;

class Island{
    int c1;
    int c2;
    String data;

    public Island(int c1, int c2, String data){
        this.c1=c1;
        this.c2=c2;
        this.data=data;
    }

    public int[] getCoords(){
        int[] helper={c1,c2};
        return helper; 
    }

    public String getData(){return data; }

    @Override
    public boolean equals(Object o){
        if (this==o){return true;}
        if (o==null || getClass()!= o.getClass()){return false;}
        Island helper=(Island) o;
        if (c1!=helper.c1){return false;}
        if (c2!=helper.c2){return false;}
        return true;
    }

    @Override
    public int hashCode(){
        String helper= Integer.toString(c1)+Integer.toString(c2);
        int code= Integer.parseInt(helper);
        return code;
    }
}

class island3{
    public static void main(String[] args){

        Kattio input=new Kattio();

        Queue<Island> hopping= new LinkedList<>();

        int length=input.getInt();
        int breadth=input.getInt();

        String[][] map=new String[length][breadth];

        for (int i=0;i<length;i++){
            String mapping=input.getLine();
            String[] helper=mapping.split("");
            map[i]=helper.clone();
        }

        HashMap<Island, ArrayList<Island> > hm= new HashMap<Island, ArrayList<Island> >();

        //adj list
        for (int j=0;j<length;j++){
            for (int k=0;k<breadth;k++){

                Island piece=new Island(j,k,map[j][k]);
                hm.put(piece, new ArrayList<Island>());

                int helperCoordj;
                int helperCoordk;

                if (j!=0){
                    helperCoordj=j-1;
                    Island helper= new Island(helperCoordj,k,map[helperCoordj][k]);
                    hm.get(piece).add(helper);
                }

                if (j!=length-1){
                    helperCoordj=j+1;
                    Island helper=new Island(helperCoordj,k,map[helperCoordj][k]);
                    hm.get(piece).add(helper);
                }

                if (k!=0){
                    helperCoordk=k-1;
                    Island helper=new Island(j,helperCoordk,map[j][helperCoordk]);
                    hm.get(piece).add(helper);
                }

                if(k!=breadth-1){
                    helperCoordk=k+1;
                    Island helper=new Island(j,helperCoordk,map[j][helperCoordk]);
                    hm.get(piece).add(helper);
                }

                if (piece.getData().equals("L")){
                    hopping.add(piece);
                }
            }
        }

        int count=0; //Number of island
        int[][] visited=new int[length][breadth];

        while (hopping.size()>0){

            Island nextIsland=hopping.poll();
            int[] coordinate=nextIsland.getCoords();
            if (visited[coordinate[0]][coordinate[1]]==1){continue; }

            if (nextIsland.getData().equals("W")){
                visited[coordinate[0]][coordinate[1]]=1;
                continue;
            }
            
            if (nextIsland.getData().equals("L")){
                count++;
                DFS(hm, nextIsland,visited);
            }
        }

        input.println(count);
        input.flush();

    }

    public static void DFS(HashMap<Island, ArrayList<Island> > hm, Island island, int[][] visited){
        Queue<Island> neighbours=new LinkedList<>();
        ArrayList<Island> helper= hm.get(island);
        for (Island i:helper){
            neighbours.add(i);
        }

        while (neighbours.size()>0){
            Island nextNeighbour=neighbours.poll();
            String type=nextNeighbour.getData();
            int[] coordinate=nextNeighbour.getCoords();
            int x=coordinate[0];
            int y=coordinate[1];

            if (visited[x][y]==1){continue;}

            visited[x][y]=1;

            if (type.equals("W")){continue; }

            ArrayList<Island> temp=hm.get(nextNeighbour);
            if (temp.size()>0){
                for (Island j:temp){
                    neighbours.add(j);
                }                
            }  
        }
    }
}
