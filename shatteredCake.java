//id: shatteredcake

class shatteredCake{
    public static void main(String[] args){

        Kattio input=new Kattio();
        
        int width=input.getInt();
        int N=input.getInt();
        int area=0;
        
        for (int i=0;i<N;i++){
            int pieceW=input.getInt();
            int pieceL=input.getInt();
            area+=(pieceW*pieceL);
        }
        
        int length=area/width;
        System.out.print(length);
    }
}
