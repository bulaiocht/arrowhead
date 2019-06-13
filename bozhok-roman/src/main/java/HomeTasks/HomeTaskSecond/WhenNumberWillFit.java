package main.java.HomeTasks.HomeTaskSecond;

public class WhenNumberWillFit {
    public static void main(String[] args) {
        typeVariable(args);

    }

    private static void typeVariable (String[] args){
        String so = args[0];

        try {
            long l =Long.parseLong(so);
            System.out.println("Input in Long");

            try {
                int i = Integer .parseInt(so);
                System.out.println("Input in Integer");

                try {
                    short s = Short.parseShort(so);
                    System.out.println("Input in Short");
                    try {
                        byte b = Byte.parseByte(so);
                        System.out.println("Input in Byte");
                    }catch (Exception e){

                    }
                }catch (Exception e){

                }

            }catch (Exception e){

            }

        }catch (Exception e){
            try {

                double d = Double.parseDouble(so);
                System.out.println("Input in Double");
                try {
                    float f = Float.parseFloat(so);
                    System.out.println("Input in Float");
                }catch (Exception e1){

                }
            }catch (Exception e1){

            }
        }
    }
}
