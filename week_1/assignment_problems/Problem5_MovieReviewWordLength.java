package week_1.assignment_problems;

/**
 * Week 1 Assignment - Problem 5: The Movie Review Word Length Profiler
 * Scenario: Movie review platform spam moderation profiling.
 * 
 * Splits review into words and classifies them into Short (1-4 letters),
 * Medium (5-8 letters), or Long (9+ letters).
 */
public class Problem5_MovieReviewWordLength {

    /**
     * Classifies and counts word lengths in a movie review string.
     * 
     * @param review Input movie review string
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split by whitespace and punctuation
        String[] words = review.trim().split("[\\s\\p{Punct}]+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            if (word.isEmpty()) continue;
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Movie Review Word Length Profiler");
        System.out.println("==================================================");

        String sample = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input:  \"" + sample + "\"");
        System.out.print("Output: ");
        classifyWordLengths(sample);

        System.out.println("==================================================\n");
    }
}
