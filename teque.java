//id: teque

import java.util.HashMap;

class teque{
    public static void main(String[] args){

        Kattio input= new Kattio();

        int n=input.getInt();

        HashMap<Integer, Integer> frontMap=new HashMap<Integer, Integer>();
        int frontF=0;
        int frontB=0; 

        HashMap<Integer, Integer> backMap=new HashMap<Integer, Integer>();
        int backF=0;
        int backB=0;

        for (int i=0;i<n;i++){
            String cmd=input.getWord();
            int val=input.getInt();

            if (cmd.charAt(0)=='g'){ // if get
                if (val<frontMap.size()){
                    int ans=frontMap.get(val+frontF);
                    input.println(ans);
                }
                
                else{
                    val=val-frontMap.size();
                    int ans=backMap.get(val+backF);
                    input.println(ans);
                }
            }
            
            else if (cmd.charAt(5)=='f'){ //push_front
                frontF--;
                frontMap.put(frontF,val);

                //Making sure "centre" stays at the end of front
                if (frontMap.size()-backMap.size()>1){
                    frontB--;
                    backF--;
                    backMap.put(backF, frontMap.get(frontB));
                    frontMap.remove(frontB);
                }
            }

            else if (cmd.charAt(5)=='b'){ //push_back
                backMap.put(backB,val);
                backB++;

                //Same thing about "centre"
                if (backMap.size()>frontMap.size()){

                    frontMap.put(frontB, backMap.get(backF));
                    frontB++;
                    backMap.remove(backF);
                    backF++;               
                }
            }

            else if (cmd.charAt(5)=='m'){ //push_middle
                if (frontMap.size()==backMap.size()){
                    frontMap.put(frontB,val);
                    frontB++;
                }
                
                else{
                    backF--;
                    backMap.put(backF,val);
                }
            }
        }
        
        input.flush();
    }
}
