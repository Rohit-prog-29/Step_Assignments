import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class Problem3_LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalFines = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            LibraryItem item = null;

            if (type.equalsIgnoreCase("BOOK")) {
                item = new BookItem(title, daysLate);
            } else if (type.equalsIgnoreCase("DVD")) {
                item = new DVDItem(title, daysLate);
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                item = new MagazineItem(title, daysLate);
            }

            if (item != null) {
                double fine = item.calculateFine();
                System.out.printf("%s: %.2f\n", item.getTitle(), fine);
                totalFines += fine;
            }
        }

        System.out.printf("Total Fines: %.2f\n", totalFines);
        scanner.close();
    }
}
