import java.util.Random;

/**
 * Problem 3: BMI Calculator for a Team
 * Scenario: The Corporate Wellness Program
 * 
 * Records height (m) and weight (kg) for a team of employees, computes BMI,
 * classifies health status, and presents all details in a tabular wellness report.
 */
public class Problem3_BMICalculator {

    /**
     * Classifies health status based on BMI.
     * BMI < 18.5 -> Underweight
     * 18.5 - 24.9 -> Normal
     * 25.0 - 29.9 -> Overweight
     * >= 30 -> Obese
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Calculates BMI and prints a tabular wellness report for team members.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid input data.");
            return;
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("----------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-10.2f | %-12s%n",
                    (i + 1), h, w, bmi, status);
        }
        System.out.println("----------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("   Corporate Wellness Program - Employee BMI Calculator");
        System.out.println("======================================================================");

        // Demo sample matching specific problem sample output
        System.out.println("Sample Input / Output Demo:");
        double[] sampleHeights = {1.75, 1.60};
        double[] sampleWeights = {70.0, 90.0};
        for (int i = 0; i < sampleHeights.length; i++) {
            double bmi = sampleWeights[i] / (sampleHeights[i] * sampleHeights[i]);
            System.out.printf("Person %d - Height: %.2f m, Weight: %.0f kg  =>  BMI: %.2f | Status: %s%n",
                    (i + 1), sampleHeights[i], sampleWeights[i], bmi, getBmiStatus(bmi));
        }

        System.out.println("\nFull Team Wellness Report (10 Employees):");
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        // Seeded random data for reproducible clean live demo
        Random rand = new Random(42);
        for (int i = 0; i < teamSize; i++) {
            // Height between 1.50m and 1.95m
            heights[i] = 1.50 + rand.nextDouble() * 0.45;
            // Weight between 45kg and 110kg
            weights[i] = 45.0 + rand.nextDouble() * 65.0;
        }

        // Set first two items to match exact problem example
        heights[0] = 1.75; weights[0] = 70.0;
        heights[1] = 1.60; weights[1] = 90.0;

        printWellnessReport(heights, weights);
        System.out.println("======================================================================\n");
    }
}
