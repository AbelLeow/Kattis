//id: delimitersoup

import java.util.ArrayList;

class delimiterSoup{

    public static void main(String[] args){

        Kattio input=new Kattio();
        int n=input.getInt();

        String stuff=input.getLine();

        ArrayList<Character> helper= new ArrayList<Character>();
        int pointer=0;

        for (int i=0;i<n;i++){
            char a=stuff.charAt(i);
            
            if (a==' '){continue; }
            
            else if(a=='(' || a=='[' || a=='{'){
                helper.add(a);
                pointer++;
            }

            else{
                if (pointer-1<0){
                    System.out.print(a+" ");
                    System.out.print(i);
                    return;                   
                }

                char check=helper.get(pointer-1);
                
                if (check=='(' && a!=')'){
                    System.out.print(a+" ");
                    System.out.print(i);
                    return;
                }
                
                else if (check=='[' && a!=']'){
                    System.out.print(a+" ");
                    System.out.print(i);
                    return;
                }

                else if (check=='{' && a!='}'){
                    System.out.print(a+" ");
                    System.out.print(i);
                    return;
                }

                else{
                    pointer--;
                    helper.remove(pointer);
                }
            }
        }
        System.out.print("ok so far");
    }
}
