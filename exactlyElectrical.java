//id: exactlyelectrical

import java.util.Scanner;

class exactlyElectrical{
    public static void main(String[] args){
        Scanner input=new Scanner (System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();
        int d=input.nextInt();
        int batt=input.nextInt();

        int totalDist=Math.abs(a-c) + Math.abs(b-d);

        if (batt<totalDist){ System.out.println("N"); return;}

        else if(batt==totalDist){System.out.println("Y"); return;}

        int battDiff= batt-totalDist;

        if (battDiff%2==0){
            System.out.println("Y");
        }
        else{ System.out.println("N");}
    }
}
