//id: peasoup

class psp{
    public static void main(String[] args){
    
        Kattio input= new Kattio();

        //Get Number of Restaurants
        int Restaurants=input.getInt();
        String[] qualifiedRest=new String[Restaurants];

        int counter=0;

        for (int i=0; i<Restaurants;i++){

            int menuItems=input.getInt(); //Get Menu Items
            String restName=input.getLine(); //Restaurant Name
            boolean soup=false;
            boolean pancake=false;

            for (int j=0; j<menuItems;j++){ //iterate through menu items
                String food=input.getLine();
               
                if (food.equals("pea soup")){ soup=true; }
                if (food.equals("pancakes")){pancake=true; }
            }

            if (soup && pancake){
                qualifiedRest[counter]=restName;
                counter+=1;
            }
        }

        if (qualifiedRest[0]==null){ System.out.println("Anywhere is fine I guess"); }
        else{ System.out.println(qualifiedRest[0]); }
    }
}
