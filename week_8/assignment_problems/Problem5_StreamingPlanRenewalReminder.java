import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class StreamingSubscriber {
    protected String name;
    protected LocalDate startDate;

    public StreamingSubscriber(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate getRenewalDate();
}

class BasicPlanSubscriber extends StreamingSubscriber {
    public BasicPlanSubscriber(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlanSubscriber extends StreamingSubscriber {
    public StandardPlanSubscriber(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlanSubscriber extends StreamingSubscriber {
    public PremiumPlanSubscriber(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class Problem5_StreamingPlanRenewalReminder {

    public static void processSubscribers(List<StreamingSubscriber> subscribers) {
        for (StreamingSubscriber subscriber : subscribers) {
            System.out.printf("%s: %s%n", subscriber.getName(), subscriber.getRenewalDate());
        }
    }

    public static void main(String[] args) {
        List<StreamingSubscriber> subscribers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String plan = scanner.next();
                String name = scanner.next();
                String dateStr = scanner.next();
                LocalDate startDate = LocalDate.parse(dateStr);
                switch (plan.toUpperCase()) {
                    case "BASIC":
                        subscribers.add(new BasicPlanSubscriber(name, startDate));
                        break;
                    case "STANDARD":
                        subscribers.add(new StandardPlanSubscriber(name, startDate));
                        break;
                    case "PREMIUM":
                        subscribers.add(new PremiumPlanSubscriber(name, startDate));
                        break;
                }
            }
            processSubscribers(subscribers);
        } else {
            // Sample test case
            subscribers.add(new BasicPlanSubscriber("Asha", LocalDate.parse("2024-01-15")));
            subscribers.add(new StandardPlanSubscriber("Ravi", LocalDate.parse("2024-02-01")));
            subscribers.add(new PremiumPlanSubscriber("Neha", LocalDate.parse("2024-03-10")));
            subscribers.add(new BasicPlanSubscriber("Kiran", LocalDate.parse("2024-12-20")));
            processSubscribers(subscribers);
        }
        scanner.close();
    }
}
