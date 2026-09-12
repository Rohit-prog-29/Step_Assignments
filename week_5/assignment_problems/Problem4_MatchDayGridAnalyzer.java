/**
 * Week 5 Assignment - Problem 4: Match Day Grid Analyzer
 * Scenario: Cricket stats app evaluating runs scored per over across matches.
 * 
 * Uses reusable helper method rowAverage(int[] row) to classify matches as
 * "Power Surge" (average >= threshold) or "Normal".
 */
public class Problem4_MatchDayGridAnalyzer {

    /**
     * Private helper method computing average runs for a single match (row).
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
     * Classifies matches based on run rate average against threshold.
     * 
     * @param runsPerOver 2D array of runs per over per match
     * @param threshold   Run rate threshold for Power Surge
     * @return Formatted summary string
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "No match data available.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";
            if (i > 0) sb.append(" | ");
            sb.append("Match ").append(i).append(": ").append(status);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 5 Assignment - Match Day Grid Analyzer");
        System.out.println("==================================================");

        int[][] grid = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;

        System.out.println("Input: 2D Grid with threshold = 8");
        System.out.println("Output: \"" + classifyMatches(grid, threshold) + "\"");

        System.out.println("==================================================\n");
    }
}
