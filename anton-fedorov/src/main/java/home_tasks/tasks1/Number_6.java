package home_tasks.tasks1;

import java.util.Scanner;

public class Number_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Todo how to display ° without Â°
        System.out.println("Input initial temperature in C:");
        float tempC = scanner.nextFloat();

        float tempK = tempC + 273.15f;
        System.out.println("The same temperature in K: " + tempK);

        float tempF = 1.8f * tempK - 459.67f;
        System.out.println("The same temperature in F: " + tempF);
    }
}
