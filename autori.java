//id: autori

import java.util.Scanner;

class autori{
    public static void main(String[] args){

        Scanner input=new Scanner(System.in);

        String name=input.nextLine();
        String[] temp=name.split("-");

        for (String s:temp){
            System.out.print(s.charAt(0));
        }
    }
}
