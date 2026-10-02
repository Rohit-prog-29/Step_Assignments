import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected LocalDate currentDate;

    public LibraryItem(String title, LocalDate currentDate) {
        this.title = title.replaceAll("^\"|\"$", ""); // Strip quotes if any
        this.currentDate = currentDate;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate getDueDate();
}

class BookItem extends LibraryItem {
    public BookItem(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    @Override
    public LocalDate getDueDate() {
        return currentDate.plusDays(14);
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    @Override
    public LocalDate getDueDate() {
        return currentDate.plusDays(7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    @Override
    public LocalDate getDueDate() {
        return currentDate.plusDays(3);
    }
}

public class Problem2_LibraryItemDueDateCalculator {

    public static void processItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.printf("%s: %s%n", item.getTitle(), item.getDueDate());
        }
    }

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                int firstSpace = line.indexOf(' ');
                if (firstSpace != -1) {
                    String type = line.substring(0, firstSpace);
                    String title = line.substring(firstSpace + 1);
                    switch (type.toUpperCase()) {
                        case "BOOK":
                            items.add(new BookItem(title, currentDate));
                            break;
                        case "DVD":
                            items.add(new DvdItem(title, currentDate));
                            break;
                        case "MAGAZINE":
                            items.add(new MagazineItem(title, currentDate));
                            break;
                    }
                }
            }
            processItems(items);
        } else {
            // Sample test case
            items.add(new BookItem("1984", currentDate));
            items.add(new DvdItem("The Matrix", currentDate));
            items.add(new MagazineItem("Forbes Issue 500", currentDate));
            processItems(items);
        }
        scanner.close();
    }
}
