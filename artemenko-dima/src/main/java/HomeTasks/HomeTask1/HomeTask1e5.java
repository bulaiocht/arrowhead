package HomeTasks.HomeTask1;

public class HomeTask1e5 {
//    5. Определить в какую переменную вместится число.
//    Число передавать как аргумент командной строки.
    public static void main(String[] args) {
        for (String number : args) {
            char[] strToArray = number.toCharArray();
            for (char ch : strToArray){
                try {
                    System.out.println(Integer.parseInt(number) + " Integer");
                }
                catch (NumberFormatException e){
                    System.out.println(ch + " Character");
                }
            }
        }
    }
}
