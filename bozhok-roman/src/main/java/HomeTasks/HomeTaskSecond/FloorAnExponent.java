package main.java.HomeTasks.HomeTaskSecond;


public class FloorAnExponent {
    public static void printWholeAndE(float number){
        int exp = 0;
        int num = (int)number;
        while (!(number%1==0)){
            number*=10;
            exp++;

        }
        System.out.println("INT: "+ num +" EXP: "+exp);

    }
}
