package week_1.practice_problems;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem 4: First Non-Repeating Character
 * Scenario: The Unique Letter Hunt Mini-Game
 * 
 * Computes the frequency of characters in a string, scans left to right,
 * and identifies the first character whose frequency is exactly 1.
 */
public class Problem4_FirstNonRepeatingChar {

    /**
     * Scans text and returns the first non-repeating character.
     * Returns '\0' if no non-repeating character exists.
     * 
     * @param text Input string
     * @return First non-repeating character or '\0'
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Count frequency using map or array
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Scan left to right to find first char with count == 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freqMap.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Unique Letter Hunt Mini-Game - First Non-Repeating Char");
        System.out.println("==================================================");

        String[] testCases = {"swiss", "aabbcc", "developer", "automation", "z"};

        for (String input : testCases) {
            char result = findFirstNonRepeatingChar(input);
            System.out.println("Input: \"" + input + "\"");
            if (result != '\0') {
                System.out.println("Output: First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("Output: No Non-Repeating Character Found");
            }
            System.out.println("--------------------------------------------------");
        }
        System.out.println("==================================================\n");
    }
}
