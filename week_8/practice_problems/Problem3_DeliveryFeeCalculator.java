import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class DeliveryRequest {
    protected double weight;
    protected double distance;

    public DeliveryRequest(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract String getDeliveryType();
    public abstract double calculateFee();
}

class StandardDelivery extends DeliveryRequest {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public String getDeliveryType() {
        return "STANDARD";
    }

    @Override
    public double calculateFee() {
        return 5.0 + (weight * 0.50) + (distance * 0.10);
    }
}

class ExpressDelivery extends DeliveryRequest {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public String getDeliveryType() {
        return "EXPRESS";
    }

    @Override
    public double calculateFee() {
        return 15.0 + (weight * 1.00) + (distance * 0.20);
    }
}

class InternationalDelivery extends DeliveryRequest {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public String getDeliveryType() {
        return "INTERNATIONAL";
    }

    @Override
    public double calculateFee() {
        return 25.0 + (weight * 2.00) + (distance * 0.50) + customsFee;
    }
}

public class Problem3_DeliveryFeeCalculator {

    public static void processRequests(List<DeliveryRequest> requests) {
        double total = 0.0;
        for (DeliveryRequest req : requests) {
            double fee = req.calculateFee();
            System.out.printf("%s: %.2f%n", req.getDeliveryType(), fee);
            total += fee;
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        List<DeliveryRequest> requests = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                double weight = scanner.nextDouble();
                double distance = scanner.nextDouble();
                if (type.equalsIgnoreCase("INTERNATIONAL")) {
                    double customsFee = scanner.nextDouble();
                    requests.add(new InternationalDelivery(weight, distance, customsFee));
                } else if (type.equalsIgnoreCase("EXPRESS")) {
                    requests.add(new ExpressDelivery(weight, distance));
                } else if (type.equalsIgnoreCase("STANDARD")) {
                    requests.add(new StandardDelivery(weight, distance));
                }
            }
            processRequests(requests);
        } else {
            // Sample test case
            requests.add(new StandardDelivery(10, 50));
            requests.add(new ExpressDelivery(5, 20));
            requests.add(new InternationalDelivery(20, 100, 30));
            processRequests(requests);
        }
        scanner.close();
    }
}
