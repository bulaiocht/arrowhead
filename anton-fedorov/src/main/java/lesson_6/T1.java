package lesson_6;

import java.util.StringJoiner;

public class T1 {
    public static void main(String[] args) {
        String text = "this tsi qwe test";
        String test1 = new String("this is another test");
        String intern = test1.intern();

        String outcome = text + " othe text";

        System.out.println(outcome);

        StringBuilder builder = new StringBuilder();
        builder.append("hello").append("asd").append("xcxcvxcvxcvxcv").append("\n");


        builder.delete(3, 10);


        System.out.println(builder.indexOf(""));

//        StringJoiner joiner = new StringJoiner()
    }
}
