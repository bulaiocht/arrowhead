package HomeTasks;

public class HomeTask1e3 {
    //    3. Найти количество чисел, содержащих только четные цифры,
    //    а также количество чисел с равным числом четных и нечетных цифр.
    public static void main(String[] args) {

        Integer[] arrNum=new Integer[args.length];
        int i=0;
        for(String str:args){
            arrNum[i]=Integer.parseInt(str);
            i++;
        }

        int count1 = 0;
        int count2 = 0;
        for (int k = 0; k < arrNum.length; k++) {
            int countEvenNumbers = 0;
            int countOddNumbers = 0;
            int[] numberElements = getCharsOfInteger(arrNum[k]);
            for (int j = 0; j < numberElements.length; j++) {
                if (numberElements[j] % 2 == 0) {
                    countEvenNumbers++;
                } else {
                    countOddNumbers++;
                }
            }
            if (countEvenNumbers == countOddNumbers) {
                count2++;
            }
            if (countOddNumbers == 0) {
                count1++;
            }
        }
        System.out.println("number of numbers containing even numbers only: " + count1);
        System.out.println("the number of numbers with an equal number of even and odd numbers: " + count2);
    }

    private static int[] getCharsOfInteger(int number) {
        int[] elements = new int[(int) Math.ceil(Math.log10(number + 0.5))];
        for (int i = 0; i < elements.length; i++) {
            elements[elements.length - i - 1] = number % 10;
            number /= 10;
        }
        return elements;
    }
}