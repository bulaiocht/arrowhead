package HomeTasks.HomeTaskSecond;

public class TypeOfConsistNumber {
    public static void main(String[] args) {
        typeNumber(args);
    }
    private static void typeNumber (String[]args){
        int countCouple=0;
        int countCoupleEquallyUnCouple = 0;
        for (String args1: args) {
            countCouple+=couple(args1);
            countCoupleEquallyUnCouple+=coupleEquallyUnCouple(args1);

        }
        System.out.println("Count number with couple numbers: "+ countCouple);
        System.out.println("Count number with couple equally uncouple numbers : "+countCoupleEquallyUnCouple);
    }
    private static int couple (String s){
        String[] s1 = s.split("");
        int count = 0;
        for (String sx:s1) {
            if (Integer.parseInt(sx)%2==0){
                count++;
            }
        }
        return count==s1.length? 1:0;


    }
    private static int coupleEquallyUnCouple (String s){
        String[] s1 = s.split("");
        int count1 = 0;
        int count2 = 0;
        for (String sx:s1) {
            if (Integer.parseInt(sx)%2==0){
                count1++;
            }else{
                count2++;
            }
        }
        return count1==count2? 1:0;

    }
}
