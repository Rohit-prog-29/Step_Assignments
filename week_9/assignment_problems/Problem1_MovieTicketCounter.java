import java.util.Scanner;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getBasePrice();

    public double calculateTotalAmount() {
        return count * (getBasePrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePrice() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePrice() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePrice() {
        return 400.0;
    }
}

public class Problem1_MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();
            Ticket ticket = null;

            if (type.equalsIgnoreCase("REGULAR")) {
                ticket = new RegularTicket(count);
            } else if (type.equalsIgnoreCase("PREMIUM")) {
                ticket = new PremiumTicket(count);
            } else if (type.equalsIgnoreCase("RECLINER")) {
                ticket = new ReclinerTicket(count);
            }

            if (ticket != null) {
                double amount = ticket.calculateTotalAmount();
                System.out.printf("%s: %.2f\n", type.toUpperCase(), amount);
                grandTotal += amount;
            }
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
