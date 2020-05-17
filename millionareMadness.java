//id: millionairemadness

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

class helperComparator implements Comparator<int[]>{
    public int compare(int[] arr1,int[] arr2){
        if (arr1[0] > arr2[0]){return 1;}
        else if (arr1[0] < arr2[0] ){return -1;}
        else if (arr1[0]==arr2[0] && arr1[1]>arr2[1]){return 1;}
        else if (arr1[0]==arr2[0] && arr1[1]<arr2[1]){return -1;}
        else{return 0;}
    }
}

class millionareMadness{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int maxValue=1000000001; //Value is 1 more than 10**9

        int counter=0;
        int length=input.getInt();
        int breadth=input.getInt();

        int[][] hmVertex=new int[length*breadth][2]; //I.e index 0 =vertex 0= coordinate (0,0) and so forth
        int[][] hmCoord=new int[length][breadth]; //does the opposite, so hmCoord[0][0]= vertex 0, and hmCoord[0][1]=vertex 1

        int[][] map=new int[length][breadth]; //The map given
        int[][] dArray=new int[length][breadth]; //The length of ladder required from pred vertex
        int[][][] pred=new int[length][breadth][2]; //stores the pred coord (Idk why I didn't use vertex number)
        int[][] sortedArray=new int[length][breadth]; //1 means that the vertex is considered sorted

        for (int[] h:dArray){ Arrays.fill(h,maxValue); }

        dArray[0][0]=0;

        for (int i=0;i<length;i++){
            for (int j=0;j<breadth;j++){
                map[i][j]=input.getInt();
                int[] helper={i,j};
                hmVertex[counter]=helper.clone();
                hmCoord[i][j]=counter;
                counter++;
            }
        }

        //Items come in the form of {distance, vertex}
        PriorityQueue<int[]> neighbours=new PriorityQueue<int[]>(11,new helperComparator());

        int[][] modificationArray=new int[length][breadth];
        int[] helper={0,0};

        neighbours.add(helper);
        
        int vertex,height,d,x,y;
        int[] coord;
        int tempX,tempY, tempHeight, diff, currLadder;
        while (neighbours.size()>0){

            int[] curr=neighbours.poll();
            d=curr[0];
            vertex=curr[1];
            coord=hmVertex[vertex];
            x=coord[0];
            y=coord[1];
            height=map[x][y];
            currLadder=dArray[x][y];

            if (modificationArray[x][y]!=-1 && d!=modificationArray[x][y]){continue;} 
            sortedArray[x][y]=1;

            //seach up
            if (x!=0){
                tempX=x-1;
                tempY=y;
                if (sortedArray[tempX][tempY]==0){ 
                    tempHeight=map[tempX][tempY];
                    diff=Math.max(0,tempHeight-height);
                    diff=Math.max(diff,currLadder);

                    if (diff<dArray[tempX][tempY]){ //Only if its possible to get a shorted ladder
                        modificationArray[tempX][tempY]=diff; //Setting the correct value to the shorter one
                        int[] helperA={diff,hmCoord[tempX][tempY]};
                        neighbours.add(helperA);
                        
                        pred[tempX][tempY]=coord.clone(); //setting new predecessor
                        dArray[tempX][tempY]=diff; //estimated shortest ladder required
                    }
                }
            }

            //search down
            if (x!=length-1){
                tempX=x+1;
                tempY=y;
                if (sortedArray[tempX][tempY]==0){
                    tempHeight=map[tempX][tempY];
                    diff=Math.max(0,tempHeight-height);
                    diff=Math.max(diff,currLadder);
                    if (diff<dArray[tempX][tempY]){
                        modificationArray[tempX][tempY]=diff;
                        int[] helperA={diff,hmCoord[tempX][tempY]};
                        neighbours.add(helperA);
                        
                        pred[tempX][tempY]=coord.clone();
                        dArray[tempX][tempY]=diff;
                    }
                }
            }

            //search left
            if (y!=0){
                tempX=x;
                tempY=y-1;
                if (sortedArray[tempX][tempY]==0){
                    tempHeight=map[tempX][tempY];
                    diff=Math.max(0,tempHeight-height);
                    diff=Math.max(diff,currLadder);
                    if (diff<dArray[tempX][tempY]){
                        modificationArray[tempX][tempY]=diff;
                        int[] helperA={diff,hmCoord[tempX][tempY]};
                        neighbours.add(helperA);
                        
                        pred[tempX][tempY]=coord.clone();
                        dArray[tempX][tempY]=diff;
                    }
                }
            }

            //search right
            if (y!=breadth-1){
                tempX=x;
                tempY=y+1;
                if (sortedArray[tempX][tempY]==0){
                    tempHeight=map[tempX][tempY];
                    diff=Math.max(0,tempHeight-height);
                    diff=Math.max(diff,currLadder);
                    if (diff<dArray[tempX][tempY]){
                        modificationArray[tempX][tempY]=diff;
                        int[] helperA={diff,hmCoord[tempX][tempY]};
                        neighbours.add(helperA);
                        
                        pred[tempX][tempY]=coord.clone();
                        dArray[tempX][tempY]=diff;
                    }
                }
            }
        }

        int ans=dArray[length-1][breadth-1];
        System.out.println(ans);
    }
}
