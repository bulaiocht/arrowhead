package HomeTasks;

public class HomeTask1e2 {
//    2. Найти число, в котором число различных цифр минимально.
//    Если таких чисел несколько, найти первое из них.
    public static void main (String [] args){

        Integer[] values=new Integer[args.length];
        int a=0;
        for(String str:args){
            values[a]=Integer.parseInt(str);
            a++;
        }

        int[] countArray = new int[values.length];
        int maxValueOfDifferentDigitsIndex = 0;
        int maxValueOfDifferentDigits = 0;

        for (int i = 0; i < values.length; i++) {
            int count = 0;
            int[] valueElements = getCharsOfInteger(values[i]);
            for (int j = 0; j < valueElements.length; j++) {
                for (int k = j + 1; k < valueElements.length ; k++ ) {
                    if(valueElements[j] == valueElements[k]) {
                        count++;
                    }
                }
            }
            countArray[i] = count;
        }

        for (int j = 0; j < countArray.length; j++){
            if(countArray[j] > maxValueOfDifferentDigits)
            {
                maxValueOfDifferentDigitsIndex = j;
                maxValueOfDifferentDigits = countArray[j];
            }
        }
        System.out.println("Value with least Digits Number");

        System.out.println(values[maxValueOfDifferentDigitsIndex]);
    }

    public static int[] getCharsOfInteger(int number) {
        int[] elements = new int[(int) Math.ceil(Math.log10(number + 0.5))];
        for (int i = 0; i < elements.length; i++) {
            elements[elements.length - i - 1] = number % 10;
            number /= 10;
        }
        return elements;
    }
}

