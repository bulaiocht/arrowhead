package strings;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringExample {

    public static void main(String[] args) {

        String text = "this is some text";

        String text2 = new String("this is another text");

        String intern = text2.intern();

        String outcome = text + " and suffix" + " and yet another one" + " and another one";

        System.out.println(outcome);

        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();


        builder.append("hello").append(" world").append("!").append("\n");

        int start = builder.indexOf("world");
        int end = builder.lastIndexOf("world");

        builder.replace(start, end, "wlrdo");


        String string = builder.toString();
        System.out.println(string);

        StringBuilder reverse = builder.reverse();
        System.out.println(reverse);


        String format = String.format("This is number: %d", 10);

        System.out.println(format);

        final String join = String.join("/", "one", "two", "three");

        System.out.println(join);

        String substring = join.substring(5, 7);

        System.out.println(substring);

        int length = join.length();

        System.out.println(length);

        String[] split = join.split("/");

        for (final String s : split) {
            System.out.println(s);
        }

        char[] chars = join.toCharArray();

        final boolean oNe = "one".equals("oNe");
        final boolean oNe1 = "one".equalsIgnoreCase("oNe");

        System.out.println(oNe);
        System.out.println(oNe1);

        String trim = join.trim();

        final String trim1 = " join me\n".trim();

        System.out.print(trim1);
        System.out.print("hello\n");

        StringJoiner joiner = new StringJoiner(",", "[", "]");

        int [] array = new int[]{1,2,3,4,5,6,7,8,9,0};

        for (final int i : array) {
            joiner.add(String.valueOf(i));
        }

        System.out.println(joiner.toString());



        StringTokenizer tokenizer = new StringTokenizer("This|is|string|tokenizer|example", "|", true);
        StringTokenizer tokenizer2 = new StringTokenizer("This is string tokenizer example");

        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }

        while (tokenizer2.hasMoreTokens()) {
            System.out.println(tokenizer2.nextToken());
        }

    }

}
