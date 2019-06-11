package HomeTasks.HomeTaskSecond;



public class QuadraticEquation {
    public static void main(String[] args) {
        calculateQuadraticEquation(args);

    }
    private static void calculateQuadraticEquation(String[] args){
        if (args.length<4){
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);

            if (a==0){
                if(b==0){
                    if (c==0){
                        System.out.println("Haven't result");
                    }else {
                        System.out.println("Haven't result");}

                }else {
                    if(c==0){
                        System.out.println("x=0");
                    }else {
                        System.out.println("x="+(-c)/b);
                    }
                }

            }else {
                if(b==0){
                    if (c==0){
                        System.out.println("x=0");
                    }else {
                        if((-c)>0){

                            c = Math.sqrt(-c);
                            System.out.println("x1= " + c + " , " + "x2= " + (-c));
                        }else{
                            System.out.println("Haven't result");
                        }
                    }

                }else {
                    if(c==0){
                        System.out.println("x1= "+0+" , "+ "x2= "+(-b));
                    }else {
                        double d = Math.sqrt(b*b-4*a*c);

                        if (d==0){
                            double x = (-b)/2*a;
                            System.out.println("x= "+ x);
                        }else if ((b*b-4*a*c)<0){
                            System.out.println("Haven't result");
                        }else {
                            double x1 = ((-b)+d)/2*a;
                            double x2 = ((-b)-d)/2*a;
                            System.out.println("x1= "+x1+" , "+ "x2= "+x2);
                        }

                    }

                }

            }

        }else {
            System.out.println("Many numbers");
        }
    }
}
