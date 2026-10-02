import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ParkedVehicle {
    protected int hours;

    public ParkedVehicle(int hours) {
        this.hours = hours;
    }

    public abstract String getVehicleType();
    public abstract double calculateCharge();
}

class BikeVehicle extends ParkedVehicle {
    public BikeVehicle(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class CarVehicle extends ParkedVehicle {
    public CarVehicle(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }

    @Override
    public double calculateCharge() {
        if (hours <= 0) return 0.0;
        return 30.0 + (hours - 1) * 20.0;
    }
}

class TruckVehicle extends ParkedVehicle {
    public TruckVehicle(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }

    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0);
    }
}

public class Problem2_CampusParkingChargeCalculator {

    public static void processVehicles(List<ParkedVehicle> vehicles) {
        double total = 0.0;
        for (ParkedVehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            System.out.printf("%s: %.2f%n", vehicle.getVehicleType(), charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        List<ParkedVehicle> vehicles = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                int hours = scanner.nextInt();
                switch (type.toUpperCase()) {
                    case "BIKE":
                        vehicles.add(new BikeVehicle(hours));
                        break;
                    case "CAR":
                        vehicles.add(new CarVehicle(hours));
                        break;
                    case "TRUCK":
                        vehicles.add(new TruckVehicle(hours));
                        break;
                }
            }
            processVehicles(vehicles);
        } else {
            // Sample test case
            vehicles.add(new BikeVehicle(3));
            vehicles.add(new CarVehicle(4));
            vehicles.add(new TruckVehicle(1));
            vehicles.add(new CarVehicle(1));
            processVehicles(vehicles);
        }
        scanner.close();
    }
}
