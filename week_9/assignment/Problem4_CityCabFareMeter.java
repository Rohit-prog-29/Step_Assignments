import java.util.Scanner;

interface NightServiceable {
    double applyNightSurcharge(double baseFare);
}

abstract class Cab {
    protected static final double MINIMUM_FARE = 100.0;

    public abstract double getRatePerKm();

    public double calculateFare(double distanceKm, boolean isNight) {
        double rawFare = distanceKm * getRatePerKm();
        double fare = Math.max(rawFare, MINIMUM_FARE);
        if (isNight) {
            if (this instanceof NightServiceable) {
                fare = ((NightServiceable) this).applyNightSurcharge(fare);
            } else {
                return -1.0; // Service not available
            }
        }
        return fare;
    }
}

class MiniCab extends Cab {
    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

class SUVCab extends Cab implements NightServiceable {
    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

public class Problem4_CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalFare = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();
            boolean isNight = time.equalsIgnoreCase("NIGHT");

            Cab cab = null;
            if (cabType.equalsIgnoreCase("MINI")) {
                cab = new MiniCab();
            } else if (cabType.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab();
            } else if (cabType.equalsIgnoreCase("SUV")) {
                cab = new SUVCab();
            }

            if (cab != null) {
                double fare = cab.calculateFare(km, isNight);
                if (fare < 0) {
                    System.out.printf("%s: night service not available\n", cabType.toUpperCase());
                } else {
                    System.out.printf("%s: %.2f\n", cabType.toUpperCase(), fare);
                    totalFare += fare;
                }
            }
        }

        System.out.printf("Total: %.2f\n", totalFare);
        scanner.close();
    }
}
