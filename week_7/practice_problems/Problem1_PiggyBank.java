class PiggyBank {
    private final String bankId;
    private int savings;

    PiggyBank(String bankId) {
        if (bankId == null || bankId.trim().isEmpty()) {
            throw new IllegalArgumentException("Bank ID cannot be empty.");
        }
        this.bankId = bankId;
        this.savings = 0;
    }

    boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        }
        savings += amount;
        return true;
    }

    boolean withdraw(int amount) {
        if (amount <= 0 || amount > savings) {
            return false;
        }
        savings -= amount;
        return true;
    }

    int getSavings() {
        return savings;
    }

    String getBankId() {
        return bankId;
    }
}

public class Problem1_PiggyBank {
    public static void main(String[] args) {
        PiggyBank bank = new PiggyBank("PB-1");
        bank.deposit(100);
        System.out.println("After deposit: " + bank.getSavings());
        bank.withdraw(30);
        System.out.println("After withdrawal: " + bank.getSavings());
        boolean withdrawn = bank.withdraw(500);
        System.out.println("Large withdrawal accepted: " + withdrawn);
        System.out.println("Final savings: " + bank.getSavings());
    }
}