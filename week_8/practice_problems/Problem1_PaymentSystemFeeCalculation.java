import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PaymentTransaction {
    protected double amount;

    public PaymentTransaction(double amount) {
        this.amount = amount;
    }

    public abstract String getType();
    public abstract double getAdjustedAmount();
}

class CardTransaction extends PaymentTransaction {
    public CardTransaction(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "CARD";
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.02; // 2% processing fee
    }
}

class WalletTransaction extends PaymentTransaction {
    public WalletTransaction(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "WALLET";
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.01; // 1% processing fee
    }
}

class BankTransferTransaction extends PaymentTransaction {
    public BankTransferTransaction(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "BANKTRANSFER";
    }

    @Override
    public double getAdjustedAmount() {
        return amount; // 0% fee
    }
}

public class Problem1_PaymentSystemFeeCalculation {

    public static void processTransactions(List<PaymentTransaction> transactions) {
        double total = 0.0;
        for (PaymentTransaction tx : transactions) {
            double adjusted = tx.getAdjustedAmount();
            System.out.printf("%s: %.2f%n", tx.getType(), adjusted);
            total += adjusted;
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        List<PaymentTransaction> transactions = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                double amount = scanner.nextDouble();
                switch (type.toUpperCase()) {
                    case "CARD":
                        transactions.add(new CardTransaction(amount));
                        break;
                    case "WALLET":
                        transactions.add(new WalletTransaction(amount));
                        break;
                    case "BANKTRANSFER":
                        transactions.add(new BankTransferTransaction(amount));
                        break;
                }
            }
            processTransactions(transactions);
        } else {
            // Sample test case
            transactions.add(new CardTransaction(1000));
            transactions.add(new WalletTransaction(500));
            transactions.add(new BankTransferTransaction(2000));
            processTransactions(transactions);
        }
        scanner.close();
    }
}
