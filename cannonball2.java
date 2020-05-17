//id: humancannonball2

class cannonball2{

    static double gravity=9.81;
    
    public static void main(String[] args){

        Kattio input=new Kattio();

        int cases=input.getInt();

        for (int i=0;i<cases;i++){

            double initialSpeed=input.getDouble();
            double degree=input.getDouble();
            double distance=input.getDouble();
            double heightOne=input.getDouble();
            double heightTwo=input.getDouble();

            boolean helper=height(initialSpeed,degree,distance,heightOne,heightTwo);
            if (helper){input.println("Safe");}
            else{input.println("Not Safe");}
        }

        input.flush();
    }


    public static boolean height(double initialSpeed, double degree, double distance, double h1, double h2){
        
        double time=distance/(initialSpeed*Math.cos(Math.toRadians(degree)));
        double intersect=initialSpeed*time*Math.sin(Math.toRadians(degree))-(gravity*time*time)/2;
        
        return (h1+1<=intersect && intersect<=h2-1);
    }
}
