/**
 * Problem 2: Palindrome Checker (3 Approaches)
 * Scenario: The QA Text Verification Toolkit
 * 
 * Verifies if a given string is a palindrome using 3 independent approaches:
 * 1. Iterative Comparison
 * 2. Recursive Comparison
 * 3. Array Reversal
 */
public class Problem2_PalindromeChecker {

    /**
     * Approach 1: Iterative Check
     * Compares characters from both ends moving toward the middle.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive Check
     * Recursively compares the first and last characters, shrinking the substring each call.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Approach 3: Array Reversal Check
     * Converts string to character array, reverses it, and compares it to the original.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return text.equals(new String(reversed));
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   QA Text Verification Toolkit - Palindrome Checker");
        System.out.println("==================================================");

        String[] testInputs = {"madam", "hello", "racecar", "step", "noon"};

        for (String input : testInputs) {
            boolean iter = isPalindromeIterative(input);
            boolean recur = isPalindromeRecursive(input);
            boolean rev = isPalindromeArrayReversal(input);

            String iterStr = iter ? "Palindrome" : "Not Palindrome";
            String recurStr = recur ? "Palindrome" : "Not Palindrome";
            String revStr = rev ? "Palindrome" : "Not Palindrome";

            System.out.println("Input: \"" + input + "\"");
            System.out.println("Output: Iterative: " + iterStr + " | Recursive: " + recurStr + " | Array Reversal: " + revStr);
            System.out.println("--------------------------------------------------");
        }
        System.out.println("==================================================\n");
    }
}
