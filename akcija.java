//id: akcija

import java.util.Arrays;
import java.util.Collections;

class akcija{
  public static void main(String[] args){

    Kattio input=new Kattio();

    int n=input.getInt();

    Integer[] arr=new Integer[n];
    for (int i=0;i<n;i++){
      arr[i]=input.getInt();
    }

    Arrays.sort(arr, Collections.reverseOrder());

    if (arr.length==1){System.out.println(arr[0]);}
    int total=0;
    
    for (int i=0;i<arr.length;i+=3){
      total+=arr[i];
      if (i+1<arr.length){total+=arr[i+1];}
    }
    
    System.out.println(total);
  }
}
