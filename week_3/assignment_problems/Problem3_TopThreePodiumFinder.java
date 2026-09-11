import java.util.Arrays;

/**
 * Week 3 Assignment - Problem 3: Top-3 Podium Finder
 * Scenario: Instant stage announcement of top 3 scores without full sorting.
 * 
 * Tracks first, second, and third highest scores in a single pass left-to-right.
 */
public class Problem3_TopThreePodiumFinder {

    /**
     * Finds top 3 scores in descending order in a single pass.
     * 
     * @param scores Array of team scores (length >= 3)
     * @return Array of top 3 scores in descending order [first, second, third]
     */
    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            return new int[]{};
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Top-3 Podium Finder");
        System.out.println("==================================================");

        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Input:  {45, 82, 79, 90, 33, 90, 61}");
        System.out.println("Output: " + Arrays.toString(findTopThreeScores(scores)));

        System.out.println("==================================================\n");
    }
}
