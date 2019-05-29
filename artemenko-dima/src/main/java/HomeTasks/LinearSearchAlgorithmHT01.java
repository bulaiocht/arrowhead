package HomeTasks;

public class LinearSearchAlgorithmHT01 {
    public static void main(String args[]) {
        int[] integerArray = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584};
        int numberToFind = 610;
        System.out.println("Find number " + numberToFind + ". found, index: " + linerSearch(integerArray, numberToFind));
    }

    public static int linerSearch(int[] integerArray, int key) {
        int arraySize = integerArray.length;
        for (int i = 0; i < arraySize; i++) {
            if (integerArray[i] == key) {
                return i;
            }
        }
        System.out.println("\n" + "this number is missing");
        return -1;
    }
}