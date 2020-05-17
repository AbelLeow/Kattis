//id: froshweek

import java.util.Arrays;

class froshWeek{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int lineLength=input.getInt();

        int[] line=new int[lineLength];


        for (int i=0;i<lineLength;i++){line[i]=input.getInt(); }

        long answer=mergeSort(line);

        System.out.print(answer);
    }



    public static long mergeSort(int[] arr){

        int arrLen=arr.length;
        if (arrLen<=1){
            return 0;
        }

        int half=arrLen/2;
        int[] leftArr=Arrays.copyOfRange(arr,0,half);
        int[] rightArr=Arrays.copyOfRange(arr,half,arrLen);
        long l= mergeSort(leftArr);
        long r= mergeSort(rightArr);
        long m= merge(leftArr,rightArr, arr);
        long total=l+r+m;
        return total;


    }

    public static long merge(int[] left, int[] right, int[] orig){

        long totalSwaps=0;

        int le=0;
        int ri=0;
        int he=0;

        while (le<left.length && ri<right.length){
            if (left[le]<=right[ri]){
                orig[he++]=left[le++];
            }

            else{
                totalSwaps+=(left.length-le);
                orig[he++]=right[ri++];
            }
        }

        while (le<left.length){
            orig[he++]=left[le++];
        }
        while(ri<right.length){
            orig[he++]=right[ri++];
        }

        return totalSwaps;
    }
}
