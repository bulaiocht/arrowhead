package HomeTasks.HomeTaskSecond;

public class MinDifferenceInNumber {
    public static void main(String[] args) {
        search(args);

    }
    private static void search(String[] args){
        int[] arr = new int[args.length];
        for (int i = 0 ; i<args.length;i++){
            arr[i]= countVarious(args[i]);
        }
        int min = arr[0];
        int index = 0;
        for (int j =1 ; j<arr.length;j++){
            if (arr[j]<min && !args[j-1].equals(args[j])){
                min = arr[j];
                index = j;
            }

        }
        System.out.println("MinDifferenceInNumber: " + args[index]);
    }
    private static int countVarious(String args){
        String[] s0 = args.split("");
        int count = 0;
        int countNumb = 0;
        for (int i = 0 ; i<s0.length;i++){
            for (int j = i+1 ;j<s0.length;j++){
                if (!s0[i].equals(s0[j])) {
                    count++;

                }

            }if (countNumb<count){
                countNumb=count;
            }count = 0;
        }
        return countNumb;

    }

}
