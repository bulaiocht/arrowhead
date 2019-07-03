package HomeTask.SecondTask;

public class Task8 {

    public static void printFloatWithExponent(double number){

        int exp = 0;
        int numberInt = (int)number;
        while (!(number%1==0)){
            number*=10;
            exp++;
        }

        System.out.printf("Integer: %d Exponent: %d", numberInt, exp);

    }

}
