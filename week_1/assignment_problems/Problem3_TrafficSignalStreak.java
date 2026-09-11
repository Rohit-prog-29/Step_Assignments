/**
 * Week 1 Assignment - Problem 3: The Traffic Signal Streak Analyzer
 * Scenario: City traffic control signal malfunction monitoring.
 * 
 * Scans a sequence of signal readings ('R', 'Y', 'G') to find and report
 * the longest continuous streak of the same color.
 */
public class Problem3_TrafficSignalStreak {

    /**
     * Finds and prints the longest streak of consecutive identical signal characters.
     * 
     * @param signalLog String of signal readings e.g., "RRGGGYRR"
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal log data available.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        // Final check after loop completes
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, maxStreak);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Traffic Signal Streak Analyzer");
        System.out.println("==================================================");

        String sample1 = "RRGGGYRR";
        System.out.println("Input:  \"" + sample1 + "\"");
        System.out.print("Output: ");
        findLongestStreak(sample1);

        System.out.println("--------------------------------------------------");

        String sample2 = "RRRRYYGG";
        System.out.println("Input:  \"" + sample2 + "\"");
        System.out.print("Output: ");
        findLongestStreak(sample2);

        System.out.println("==================================================\n");
    }
}
