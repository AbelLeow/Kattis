//id:  missinggnomes

class missingGnomes{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int m=input.getInt();
        boolean[] all=new boolean[m];
        int n=input.getInt();

        int[] current=new int[n];

        for (int a=0;a<n;a++){current[a]=input.getInt(); }
        for (int i=0;i<n;i++){all[current[i]-1]=true; }

        int[] helper=new int[m-n];
        int pointer=0;

        for (int j=0;j<m;j++){
            if (all[j]!=true){
                helper[pointer]=j+1;
                pointer++;
            }
        }

        int[] answer=merge(helper,current);

        for (int l:answer){ input.println(l); }
        input.flush();
    }


    public static int[] merge(int[] a, int[] b){
        int pointA=0;
        int pointB=0;

        int[] c=new int[a.length+b.length];
        int pointC=0;

        while (pointA<a.length && pointB<b.length){
            if (a[pointA]<=b[pointB]){
                c[pointC]=a[pointA];
                pointA++;
            }
            else{
                c[pointC]=b[pointB];
                pointB++;
            }
            pointC++;
        }

        while (pointA<a.length){
            c[pointC++]=a[pointA++];
        }
        while (pointB<b.length){
            c[pointC++]=b[pointB++];
        }

        return c;
    }
}
