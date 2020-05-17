//id: transitwoes

class transitWoes{
    public static void main(String[] args){
    
        Kattio input=new Kattio();

        int startTime=input.getInt();
        int endTime=input.getInt();
        int routes=input.getInt();

        int[] walkTime=new int[routes+1];
        int[] busTime=new int[routes];
        int[] busInterval=new int[routes];

        int i;

        for (i=0;i<routes+1;i++){walkTime[i]=input.getInt(); }
        for (i=0;i<routes;i++){busTime[i]=input.getInt(); }
        for (i=0;i<routes;i++){busInterval[i]=input.getInt(); }

        int pointer=0;

        while (startTime<=endTime && pointer<routes){
        
            startTime+=walkTime[pointer];

            if (startTime%busInterval[pointer]!=0){
                int misses=startTime/busInterval[pointer];
                startTime=(misses+1)*busInterval[pointer];
            }
            
            startTime+=busTime[pointer];
            pointer++;
        }

        startTime+=walkTime[pointer++];

        if (startTime>endTime){input.println("no");}
        else{input.println("yes");}

        input.flush();
    }
}
