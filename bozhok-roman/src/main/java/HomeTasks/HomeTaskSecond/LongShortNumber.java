package HomeTasks.HomeTaskSecond;



public class LongShortNumber {
    public static void main(String[] args) {
        System.out.println("HomeTask1");
        longShortNumber(args);
        System.out.println("");


    }
    private static void longShortNumber(String[] args){
        int length ;
        String[] s0= args[0].split("");
        length= s0.length;
        int min =length;
        int max=length;
        int indexMin=0;
        int indexMax=0;
        for (int i = 1 ;i<args.length;i++){
            s0= args[i].split("");
            length= s0.length;
            if (min>length){
                min = length;
                indexMin = i;
            }else if(max<length){
                max = length;
                indexMax = i;

            }

        }

        System.out.println("Min length "+min+" number "+args[indexMin]);
        System.out.println("Max length "+max+" number "+args[indexMax]);


    }
}



