package HomeTask.SecondTask;

public class Task1 {
    public static void main(String[] args) {

        String shortestNumber = args[0];
        String longestNumber = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i].length()<shortestNumber.length()){
                shortestNumber = args[i];
            }
            if (args[i].length()>longestNumber.length()){
                longestNumber = args[i];
            }
        }
        System.out.println("Shortest number is "+shortestNumber+" with length: "+shortestNumber.length());
        System.out.println("Longest number is "+longestNumber+" with length: "+longestNumber.length());

    }
}
