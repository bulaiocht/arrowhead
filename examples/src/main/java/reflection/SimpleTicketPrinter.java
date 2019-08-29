package reflection;

public class SimpleTicketPrinter implements TicketPrinter {

    @UserSecured(user = "cashier")
    @Override
    public String printTickets(int money, String user) {
        System.out.println(user);

        if (money < 10) {
            throw new IllegalArgumentException("Not much money you have.");
        }

        return "Tickets";

    }
}
