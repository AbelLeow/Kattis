//Id: 10kindsofpeople

import java.util.Stack;
class 10KindsOfPeople{
    public static void main(String[] args){
        Kattio input=new Kattio();

        int length=input.getInt();
        int breadth=input.getInt();

        String[][] map=new String[length][breadth];
        for (int i=0;i<length;i++){
            String mapping=input.getLine();
            String[] helper=mapping.split("");
            map[i]=helper.clone();
        }

        int[][] colouredMap=dfs(length,breadth,map);

        int n=input.getInt();
        int x1,y1,x2,y2;
        for (int i=0;i<n;i++){

            x1=input.getInt()-1;
            y1=input.getInt()-1;
            x2=input.getInt()-1;
            y2=input.getInt()-1;

            int groupOne=colouredMap[x1][y1];
            int groupTwo=colouredMap[x2][y2];
            
            String typeOne=map[x1][y1];
            if (groupOne!=groupTwo){input.println("neither");}
            else if (typeOne.equals("1")){
                input.println("decimal");
            }
            else{input.println("binary");}
        }

        input.flush();
        
    }

    public static int[][] dfs(int length, int breadth, String[][] map){
        Stack<int[]> neighbours=new Stack<>();
        int[][] visited=new int[length][breadth];
        int groupNum=1;

        int helperi, helperj;
        String helperType, currType;
        for (int i=0;i<length;i++){
            for (int j=0;j<breadth;j++){
                if (visited[i][j]!=0){continue;}

                visited[i][j]=groupNum;

                currType=map[i][j];
                //add up
                if (i!=0){
                    helperi=i-1;
                    int[] helperArr={helperi,j};
                    neighbours.add(helperArr);
                }

                //add down
                if (i!=length-1){
                    helperi=i+1;
                    int[] helperArr={helperi,j};
                    neighbours.add(helperArr);
                }
                
                //add left
                if (j!=0){
                    helperj=j-1;
                    int[] helperArr={i,helperj};
                    neighbours.add(helperArr);
                }

                //add right
                if (j!=breadth-1){
                    helperj=j+1;
                    int[] helperArr={i,helperj};
                    neighbours.add(helperArr);
                }

                while (neighbours.size()>0){
                    int[] newNeighbour=neighbours.pop();
                    int x=newNeighbour[0];
                    int y=newNeighbour[1];
                    if (visited[x][y]!=0){continue;}
                    helperType=map[x][y];
                    if (helperType.equals(currType)){
                        visited[x][y]=groupNum;
                        if (x!=0){
                            int[] helperArr={x-1,y};
                            neighbours.add(helperArr);
                        }
                        if (x!=length-1){
                            int[] helperArr={x+1,y};
                            neighbours.add(helperArr);
                        }
                        if (y!=0){
                            int[] helperArr={x,y-1};
                            neighbours.add(helperArr);
                        }
                        if (y!=breadth-1){
                            int[] helperArr={x,y+1};
                            neighbours.add(helperArr);
                        }
                    }
                }
                groupNum++;
            }
        }
        return visited;
    } 
}
