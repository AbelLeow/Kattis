id: ferryloading4

import java.util.ArrayList;

class ferryLoading4{

    public static void main(String[] args){

        Kattio input=new Kattio();

        int testCases=input.getInt();

        for (int i=0;i<testCases;i++){

            int l=input.getInt() * 100;
            int cars=input.getInt();
            ArrayList<Integer> left=new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();

            for (int j=0;j<cars;j++){
                int carL=input.getInt();
                String pos=input.getWord();
                if (pos.charAt(0)=='l'){left.add(carL);}
                else{right.add(carL);}
            }

            int count=0;
            int helper=l;

            boolean leftSide=true;

            while (left.size()>0 || right.size()>0){
                if (leftSide){
                    if (left.size()==0){count++; }

                    else{
                        while (helper-left.get(0)>=0){
                            helper-=left.get(0);
                            left.remove(0);
                            if (left.size()==0){break;}
                        }

                        count++;
                    }

                    leftSide=false;

                }

                else{
                    if (right.size()==0){count++; }
                    
                    else{
                        while (helper-right.get(0)>0){
                            helper-=right.get(0);
                            right.remove(0);
                            if (right.size()==0){break;}
                        }

                        count++;
                    }

                    leftSide=true;
                }

                helper=l;
            }

            input.println(count);
        }
        input.flush();
    }
}
