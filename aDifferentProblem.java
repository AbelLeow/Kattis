//id: different

import java.util.Scanner;

class extra{
    public static void main(String[] args){

        Scanner input=new Scanner(System.in);

        while (input.hasNextLong()){
            long first=input.nextLong();
            Long sec=input.nextLong();
            Long dif=Math.abs(first-sec);
            System.out.println(dif);
        }
    }
}
