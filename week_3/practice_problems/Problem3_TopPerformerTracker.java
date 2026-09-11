/**
 * Week 3 Practice - Problem 3: Top Performer Tracker
 * Scenario: Weekly fantasy recap identifying standout performer and lowest score.
 * 
 * Tracks minimum and maximum in a single pass without sorting array.
 */
public class Problem3_TopPerformerTracker {

    /**
     * Finds min, max, and spread in a single pass.
     * 
     * @param scores Array of scores
     * @return Formatted result string: "Min: <min> | Max: <max> | Spread: <max - min>"
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            return "Invalid score input.";
        }

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return String.format("Min: %d | Max: %d | Spread: %d", min, max, spread);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Top Performer Tracker");
        System.out.println("==================================================");

        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Input:  {45, 82, 79, 90, 33, 90, 61}");
        System.out.println("Output: \"" + findMinMaxSpread(scores) + "\"");

        System.out.println("==================================================\n");
    }
}
