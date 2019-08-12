package multithreading.deadlock;

public class InfiniteFriendship {

    public static void main(String[] args) {

        Friend f1 = new Friend("John");
        Friend f2 = new Friend("Bob");

        f1.becomePartner(f2);

        f2.becomePartner(f1);

        Thread t1 = new Thread(() -> {
            for (;;) {
                f1.shakeHand();
            }
        }, "John");

        Thread t2 = new Thread(() -> {
            for (;;) {
                f2.shakeHand();
            }
        }, "Bob");

        t1.start();
        t2.start();

    }

}
