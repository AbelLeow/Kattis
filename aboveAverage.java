//id: aboveaverage

import java.util.Arrays;
import java.util.Comparator;

class aboveAverage{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int cases=input.getInt();

        for (int i=0;i<cases;i++){

            int students=input.getInt();
            double totalScore=0;
            double[] score=new double[students];
            
            for (int j=0;j<students;j++){
                double temp=input.getInt();
                score[j]=temp;
                totalScore+=temp;
            }
            
            double averageScore=totalScore/students;
            Arrays.sort(score);
            double aboveAvg=0;

            for (int j=students-1;j>-1;j--){
                if (score[j]>averageScore){aboveAvg++;}
                else{break;}
            }

            double perc=(aboveAvg/students)*100;
            String ans=String.format("%.3f",perc);

            input.println(ans+"%");

        }
        input.flush();
    }
}
