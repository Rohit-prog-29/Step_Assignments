import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TransportJourney {
    protected double distance;

    public TransportJourney(double distance) {
        this.distance = distance;
    }

    public abstract String getTransportType();
    public abstract double calculateFare();
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }

    @Override
    public double calculateFare() {
        return Math.min(10.0, 2.0 + (distance * 0.10));
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }

    @Override
    public double calculateFare() {
        return 3.0 + (distance * 0.15);
    }
}

class MetroJourney extends TransportJourney {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }

    @Override
    public double calculateFare() {
        return (1.50 + (distance * 0.20)) * peakHourFactor;
    }
}

public class Problem5_PublicTransportFareCalculator {

    public static void processJourneys(List<TransportJourney> journeys) {
        double total = 0.0;
        for (TransportJourney j : journeys) {
            double fare = j.calculateFare();
            System.out.printf("%s: %.2f%n", j.getTransportType(), fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        List<TransportJourney> journeys = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                double dist = scanner.nextDouble();
                if (type.equalsIgnoreCase("METRO")) {
                    double peak = scanner.nextDouble();
                    journeys.add(new MetroJourney(dist, peak));
                } else if (type.equalsIgnoreCase("BUS")) {
                    journeys.add(new BusJourney(dist));
                } else if (type.equalsIgnoreCase("TRAIN")) {
                    journeys.add(new TrainJourney(dist));
                }
            }
            processJourneys(journeys);
        } else {
            // Sample test case
            journeys.add(new BusJourney(15));
            journeys.add(new TrainJourney(50));
            journeys.add(new MetroJourney(10, 1.5));
            processJourneys(journeys);
        }
        scanner.close();
    }
}
