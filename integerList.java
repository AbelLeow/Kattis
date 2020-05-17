//id: integerlists

class integerList{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int n=input.getInt();

        for (int i=0;i<n;i++){

            String cmd=input.getLine();
            int total=input.getInt();
            String nums=input.getLine();
            nums=nums.substring(1,nums.length()-1);
            String[] helper=nums.split(",");
            int head=0;
            int tail=helper.length-1;
            boolean front=true;
            boolean print=true;
            
            for (int j=0;j<cmd.length();j++){

                if (cmd.charAt(j)=='R'){
                    if (front){front=false;}
                    else{front=true;}
                }

                else{
                    if (total==0){
                        input.println("error");
                        print=false;
                        break;
                    }

                    else if(front){head++; }
                    else{tail--;}
                    total--;
                }
            }

            if (print && total==0){
                input.println("[]");
                print=false;
            }

            if (print){

                input.print("[");

                while (head!=tail){

                    if (front){
                        input.print(helper[head]+",");
                        head++;
                    }

                    else{
                        input.print(helper[tail]+",");
                        tail--;
                    }
                }
                input.println(helper[head]+"]");
            }
        }
        input.flush();
    }
}
