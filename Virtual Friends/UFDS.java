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
