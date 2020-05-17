//id: bestrelayteam

class bestRelayTeam{

    public static void main(String[] args){


        Kattio input=new Kattio();

        int runners=input.getInt();


        //names, firstLap, otherLap are arrs for the runners for their names, first lap timings, other lap timings
        //Located by indexing
        String[] names= new String[runners];
        double[] firstLap=new double[runners];
        double[] otherLap=new double[runners];

        //isSelectedFirst and isSelectedOther are there to check if that runner is already taken into consideration
        //Booleam values are default false, will change to true if is considered.
        boolean[] isSelectedFirst=new boolean[runners];
        boolean[] isSelectedOther=new boolean[runners];


        //Populate the arrays, takes O(n) time, n=runnners
        for (int pop=0;pop<runners;pop++){ 
            String name=input.getWord();
            double firstTime=input.getDouble();
            double otherTime=input.getDouble();
            names[pop]=name;
            firstLap[pop]=firstTime;
            otherLap[pop]=otherTime;
        }

        int[] firstLapIndex=new int[4]; //Fastest 4 runners for 1st lap
        int[] otherLapIndex=new int[4]; //Fastest 4 runners for other laps

        double fastestTimeFirst=9999.99;
        double fastestTimeOther=9999.99;

        //Find the fastest 4 for each category
        for (int i=0;i<4;i++){
            //fastest 4 for first lap
            for (int j=0;j<runners;j++){
                if (firstLap[j]<fastestTimeFirst && !(isSelectedFirst[j])){

                    firstLapIndex[i]=j;
                    fastestTimeFirst=firstLap[j];

                }
            }

            isSelectedFirst[firstLapIndex[i]]=true;//notifies that runner is considered
            fastestTimeFirst=9999.99;//reset timing

            //Fastest 4 for other laps
            for (int k=0;k<runners;k++){
                if (otherLap[k]<fastestTimeOther && !(isSelectedOther[k])){
                    otherLapIndex[i]=k;
                    fastestTimeOther=otherLap[k];
                }
            }

            isSelectedOther[otherLapIndex[i]]=true; //Same as above
            fastestTimeOther=9999.99;
        }


        int[] fastestCurrent={-1,-1,-1,-1}; //Current fastest combination
        int[] consideredIndex={-1,-1,-1,-1}; //The next possible combination
        double totalTime=9999.99; //total time of current combination

        //Iterates through the runners for 1st Lap
        for (int a=0;a<4;a++){//Chosing from 1st lap arr
                consideredIndex[0]= firstLapIndex[a];

            // b,c and d iterates through the runners for other Laps
            for (int b=0;b<4;b++){ 
                if (!contain(consideredIndex,otherLapIndex[b])){
                consideredIndex[1]= otherLapIndex[b];}
                else{continue;}

                for (int c=1;c<4;c++){
                    if (!contain(consideredIndex,otherLapIndex[c])){
                    consideredIndex[2]= otherLapIndex[c];}
                    else{continue;}

                    for (int d=2;d<4;d++){
                        if (!contain(consideredIndex,otherLapIndex[d])){
                        consideredIndex[3]= otherLapIndex[d];}
                        else{continue;}
                        
                        //Finds the total time for the combinations currently considered
                        double newTotalTime= firstLap[consideredIndex[0]]+otherLap[consideredIndex[1]]+otherLap[consideredIndex[2]]+otherLap[consideredIndex[3]];
                        
                        //Change the team if new time is faster than prev time
                        if (newTotalTime<totalTime){
                            totalTime=newTotalTime;
                            fastestCurrent[0]=consideredIndex[0];
                            fastestCurrent[1]=consideredIndex[1];
                            fastestCurrent[2]=consideredIndex[2];
                            fastestCurrent[3]=consideredIndex[3];
                        }
                    }
                }
            }

            //Resets for next first runner
            consideredIndex[1]=-1;
            consideredIndex[2]=-1;
            consideredIndex[3]=-1;
        }

        input.println(totalTime);
        input.println(names[fastestCurrent[0]]);
        input.println(names[fastestCurrent[1]]);
        input.println(names[fastestCurrent[2]]);
        input.println(names[fastestCurrent[3]]);
        input.flush();


    }


    public static boolean contain(int[] arr, int val){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==val){return true; }
        }

        return false;
    }
}
