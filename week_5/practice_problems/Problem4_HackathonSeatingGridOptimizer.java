/**
 * Week 5 Practice - Problem 4: Hackathon Seating Grid Optimizer
 * Scenario: Venue seating grid classification into Quiet Zone vs Buzzing Zone.
 * 
 * Uses private helper rowAverage(int[] row) to classify each seating row.
 */
public class Problem4_HackathonSeatingGridOptimizer {

    /**
     * Private helper method computing average score for a single seating row.
     */
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0.0;
        double sum = 0;
        for (int val : row) {
            sum += val;
        }
        return sum / row.length;
    }

    /**
     * Classifies rows as "Quiet Zone" (average < threshold) or "Buzzing Zone" (average >= threshold).
     * 
     * @param seatingScores 2D array of seating scores
     * @param threshold     Threshold for Buzzing Zone
     * @return Formatted classification string
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "No seating data available.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";
            if (i > 0) sb.append(" | ");
            sb.append("Row ").append(i).append(": ").append(zone);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 5 Practice - Hackathon Seating Grid Optimizer");
        System.out.println("==================================================");

        int[][] seating = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;

        System.out.println("Input: Seating Grid with threshold = 60");
        System.out.println("Output: \"" + classifyRows(seating, threshold) + "\"");

        System.out.println("==================================================\n");
    }
}
