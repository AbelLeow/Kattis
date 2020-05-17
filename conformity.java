//id: conformity

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class conformity{
    public static void main(String[] args){

        Kattio input= new Kattio();

        int n=input.getInt();

        HashMap<ArrayList<Integer>, Integer > hm= new HashMap< ArrayList<Integer>, Integer>();
        
        for (int i=0;i<n;i++){

            ArrayList<Integer> helper=new ArrayList<Integer>();

            for (int j=0;j<5;j++){
                helper.add(input.getInt());
            }

            Collections.sort(helper);

            if (hm.get(helper)==null){
                hm.put(helper,1);
            }
            else{
                hm.put(helper,hm.get(helper)+1);
            }
        }
        
        int max=0;
        int count=0;

        for (int ele:hm.values()){
            if (ele>max){
                max=ele;
                count=1;
            }
            else if (ele==max){count++;}
        }

        input.print(count*max);
        input.flush();


    }
}
