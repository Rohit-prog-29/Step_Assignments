import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class CustomerBill {
    protected double amount;

    public CustomerBill(double amount) {
        this.amount = amount;
    }

    public abstract String getCustomerType();
    public abstract double getFinalAmount();
}

class StudentBill extends CustomerBill {
    public StudentBill(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "STUDENT";
    }

    @Override
    public double getFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class StaffBill extends CustomerBill {
    public StaffBill(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "STAFF";
    }

    @Override
    public double getFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class GuestBill extends CustomerBill {
    public GuestBill(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "GUEST";
    }

    @Override
    public double getFinalAmount() {
        return amount + 10.0; // ₹10 service charge
    }
}

public class Problem1_CanteenBillingCounter {

    public static void processBills(List<CustomerBill> bills) {
        double total = 0.0;
        for (CustomerBill bill : bills) {
            double finalAmount = bill.getFinalAmount();
            System.out.printf("%s: %.2f%n", bill.getCustomerType(), finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        List<CustomerBill> bills = new ArrayList<>();

        if (args.length > 0 && args[0].equals("--demo")) {
            bills.add(new StudentBill(200));
            bills.add(new StaffBill(300));
            bills.add(new GuestBill(150));
            processBills(bills);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                double amount = scanner.nextDouble();
                switch (type.toUpperCase()) {
                    case "STUDENT":
                        bills.add(new StudentBill(amount));
                        break;
                    case "STAFF":
                        bills.add(new StaffBill(amount));
                        break;
                    case "GUEST":
                        bills.add(new GuestBill(amount));
                        break;
                }
            }
            processBills(bills);
        } else {
            // Default sample execution if no input piped
            bills.add(new StudentBill(200));
            bills.add(new StaffBill(300));
            bills.add(new GuestBill(150));
            processBills(bills);
        }
        scanner.close();
    }
}
