import java.util.Scanner;

interface SaverModeCapable {
    double applySaverDiscount(double units);
}

abstract class Appliance {
    protected double powerWatts;

    public Appliance(double powerWatts) {
        this.powerWatts = powerWatts;
    }

    public double calculateUnits(double hours, boolean isSaver) {
        double units = (powerWatts * hours) / 1000.0;
        if (isSaver) {
            if (this instanceof SaverModeCapable) {
                units = ((SaverModeCapable) this).applySaverDiscount(units);
            } else {
                return -1.0; // Saver mode unsupported
            }
        }
        return units;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance() {
        super(150.0);
    }
}

class ACAppliance extends Appliance implements SaverModeCapable {
    public ACAppliance() {
        super(1500.0);
    }

    @Override
    public double applySaverDiscount(double units) {
        return units * 0.75;
    }
}

class TVAppliance extends Appliance {
    public TVAppliance() {
        super(100.0);
    }
}

class WasherAppliance extends Appliance implements SaverModeCapable {
    public WasherAppliance() {
        super(500.0);
    }

    @Override
    public double applySaverDiscount(double units) {
        return units * 0.75;
    }
}

public class Problem5_HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double hours = scanner.nextDouble();
            boolean isSaver = false;

            // Check if there is a third token on the same line for SAVER
            String lineRest = scanner.nextLine().trim();
            if (!lineRest.isEmpty()) {
                String[] tokens = lineRest.split("\\s+");
                if (tokens.length > 0 && tokens[0].equalsIgnoreCase("SAVER")) {
                    isSaver = true;
                }
            }

            Appliance appliance = null;
            if (type.equalsIgnoreCase("FRIDGE")) appliance = new FridgeAppliance();
            else if (type.equalsIgnoreCase("AC")) appliance = new ACAppliance();
            else if (type.equalsIgnoreCase("TV")) appliance = new TVAppliance();
            else if (type.equalsIgnoreCase("WASHER")) appliance = new WasherAppliance();

            if (appliance != null) {
                double units = appliance.calculateUnits(hours, isSaver);
                if (units < 0) {
                    System.out.printf("%s: saver mode not supported\n", type.toUpperCase());
                } else {
                    double cost = appliance.calculateCost(units);
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", type.toUpperCase(), units, cost);
                    totalCost += cost;
                }
            }
        }

        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}
