package multithreading.deadlock;


public class Friend {
    private Friend partner;
    private String name;

    public Friend(String name) {
        this.name = name;
    }

    public synchronized void shakeHand() {
        System.out.println(Thread.currentThread().getName() + " trying to shake hand with " + partner.name);
        partner.shakeHandBack();
    }

    public synchronized void shakeHandBack() {
        System.out.println(Thread.currentThread().getName() + " shaking hand back");
    }

    public void becomePartner(Friend partner) {
        this.partner = partner;
    }
}
