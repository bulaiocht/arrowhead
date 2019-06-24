package lesson_5;

import java.util.UUID;

public class T1 {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        System.out.println(s);
    }
}
