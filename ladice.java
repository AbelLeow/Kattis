//id: ladice

class UFDS{

    int[] arr;
    int[] rank;
    int[] size; //Total possible items the drawer can store
    int[] totalItems; //Current total items within the drawer

    public UFDS(int n){
        arr=new int[n];
        rank=new int[n];
        size=new int[n];
        totalItems=new int[n];

        for (int i=0;i<n;i++){
            arr[i]=i;
            size[i]=1;
        }
    }

    public int findSet(int i){
        if (arr[i]==i){
            return i;
        }

        else{
            arr[i]=findSet(arr[i]);
            return arr[i];
        }
    }

    public boolean isSameSet(int i, int j){return findSet(i)==findSet(j); }

    public void unionSet(int i, int j){
        if (!isSameSet(i,j)){
            int x = findSet(i);
            int y=findSet(j);
            if (rank[x]>rank[y]){ //Join Y under X
                arr[y]=x;
                size[x]+=size[y];
                totalItems[x]+=totalItems[y];

            }

            else{ //Join x under Y
                arr[x]=y;
                if (rank[x]==rank[y]){
                    rank[y]++;
                }
                size[y]+=size[x];
                totalItems[y]+=totalItems[x];
            }
        }
    }


    public int getSize(int i){return size[i]; }
    
    public int getItems(int i){return totalItems[i]; }

    public void increaseItems(int i){totalItems[i]++; }
}

class ladic{
    public static void main(String[] args){
        Kattio input=new Kattio();
        int items=input.getInt();
        int drawers=input.getInt();
        UFDS sets=new UFDS(drawers);

        for (int i=0;i<items;i++){

            int first=input.getInt()-1;
            int second=input.getInt()-1;
            sets.unionSet(first,second);
            int root=sets.findSet(first);

            if (sets.getSize(root)>sets.getItems(root)){ //Still have space for more items
                sets.increaseItems(root);
                input.println("LADICA");
            }
            
            else{
                input.println("SMECE");
            }
        }

        input.flush();
    }
}
