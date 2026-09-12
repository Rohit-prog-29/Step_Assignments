package week_1.assignment_problems;

/**
 * Week 1 Assignment - Problem 2: The Typing Speed Test Accuracy Checker
 * Scenario: Online typing practice accuracy validation.
 * 
 * Compares user typed text against original passage character-by-character,
 * calculates accuracy percentage, and reports first mismatch position.
 */
public class Problem2_TypingSpeedAccuracy {

    /**
     * Compares original and typed strings and prints accuracy statistics.
     * 
     * @param original Original passage
     * @param typed    User's typed attempt
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        int totalChars = Math.min(original.length(), typed.length());
        int matchedChars = 0;
        int firstMismatchPos = -1;
        char origChar = '\0';
        char typedChar = '\0';

        for (int i = 0; i < totalChars; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedChars++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1; // 1-based position indexing
                    origChar = original.charAt(i);
                    typedChar = typed.charAt(i);
                }
            }
        }

        double accuracy = ((double) matchedChars / original.length()) * 100.0;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matchedChars, original.length(), accuracy));

        if (firstMismatchPos != -1) {
            sb.append(String.format("First Mismatch at position %d ('%c' vs '%c')", firstMismatchPos, origChar, typedChar));
        } else {
            sb.append("No Mismatches");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Typing Speed Test Accuracy Checker");
        System.out.println("==================================================");

        System.out.println("Sample 1:");
        System.out.println("Input: original=\"hello world\", typed=\"hello worlt\"");
        System.out.print("Output: ");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("--------------------------------------------------");

        System.out.println("Sample 2:");
        System.out.println("Input: original=\"coding\", typed=\"coding\"");
        System.out.print("Output: ");
        checkTypingAccuracy("coding", "coding");

        System.out.println("==================================================\n");
    }
}
