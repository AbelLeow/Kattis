import java.util.Arrays;

class ba1{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int n=input.getInt();
        int t=input.getInt();

        if (t==1){System.out.print(7);}

        else if (t==2){
            int a=input.getInt();
            int b=input.getInt();
            if (a>b){System.out.print("Bigger");}
            else if(a==b){System.out.print("Equal");}
            else{System.out.print("Smaller");}
        }

        else if(t==3){
            int[] arr=new int[3];
            for (int i=0;i<3;i++){
                arr[i]=input.getInt();
            }
            Arrays.sort(arr);
            System.out.print(arr[1]);
        }

        else if(t==4){
            long total=0;
            for (int i=0;i<n;i++){
                total+=input.getLong();
            }
            System.out.print(total);
        }

        else if(t==5){
            long total=0;
            long curr;

            for (int i=0;i<n;i++){
                curr=input.getLong();
                if (curr%2==0){total+=curr;}
            }
            System.out.print(total);
        }

        else if (t==6){
                int[] arr=new int[n];
                int value;
                for (int i=0;i<n;i++){
                    value=input.getInt();
                    arr[i]=value%26;
                }

                char[] letters="abcdefghijklmnopqrstuvwxyz".toCharArray();
                for (int l:arr){
                    input.print(letters[l]);
                }
                
                input.flush();
        }

        else if (t==7){
            int[] arr=new int[n];
            for (int i=0;i<n;i++){
                arr[i]=input.getInt();
            }

            int pointer=0;
            int count=0;
            while (pointer<n-1){
                pointer=arr[pointer];
                count++;
                if (count>n){System.out.print("Cyclic"); return;}
            }

            if (pointer==n-1){System.out.print("Done");}
            else{System.out.print("Out");}
        }
    }
}
