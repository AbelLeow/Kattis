class UFDS{

    int[] arr;
    int[] rank;
    int[] size;

    public UFDS(int n){
        arr=new int[n];
        rank=new int[n];
        size=new int[n];

        for (int i=0;i<n;i++){
            arr[i]=i;
            size[i]=1;
        }
    }

    public int findSet(int i){
        if (arr[i]==i){return i; }
        else{
            arr[i]=findSet(arr[i]);
            return arr[i];
        }
    }

    public boolean isSameSet(int i, int j){
        return findSet(i)==findSet(j);
    }

    public void unionSet(int i, int j){
        if (!isSameSet(i,j)){
            int x = findSet(i);
            int y = findSet(j);
            if (rank[x]>rank[y]){ //Join Y under X
                arr[y]=x;

            }

            else{ //Join x under Y
                arr[x]=y;
                if (rank[x]==rank[y]){
                    rank[y]++;
                }
            }

            size[x]+=size[y];
            size[y]=size[x];
        }
    }

    public int getSize(int i){return size[i]; }
}


class internet{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int houses=input.getInt();
        int cables=input.getInt();

        UFDS connection=new UFDS(houses);

        int h1, h2;
        int i;
        for (i=0;i<cables;i++){
            h1=input.getInt()-1;
            h2=input.getInt()-1;
            connection.unionSet(h1,h2);
        }

        boolean connected=true;
        for (i=1;i<houses;i++){
            if (!connection.isSameSet(0,i)){
                input.println(i+1);
                connected=false;
            }
        }

        if (connected){
            input.println("Connected");
        }

        input.flush();
    }
}
