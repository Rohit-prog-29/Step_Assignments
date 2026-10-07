import java.util.Scanner;

abstract class TravelBooking {
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + distanceKm * 4.0;
    }
}

public class Problem5_TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double km = scanner.nextDouble();
            TravelBooking booking = null;

            if (mode.equalsIgnoreCase("BUS")) {
                booking = new BusBooking(km);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                booking = new TrainBooking(km);
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                booking = new FlightBooking(km);
            }

            if (booking != null) {
                double totalFare = booking.calculateTotalFare();
                System.out.printf("%s: %.2f\n", mode.toUpperCase(), totalFare);
            }
        }

        scanner.close();
    }
}
