import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Category C · Coding Assignment
 * Problem 4: Exam Score Band Counter
 *
 * TASK:
 * A university stores the marks of all students in an exam as an array sorted in
 * ascending order; marks can repeat. Faculty members frequently ask how many
 * students scored within a band [low, high], inclusive of both ends.
 *
 * Implement a function countInBand(scores, low, high) that returns the number of
 * scores s such that low <= s <= high. The array is large and queried very often,
 * so your solution must not scan the scores one by one.
 *
 * CONSTRAINTS:
 * - 1 <= length of scores <= 10^6
 * - scores is sorted in ascending order
 * - 0 <= low <= high <= 100
 *
 * COMPLEXITY:
 * - Linear Scan: Time O(N), Space O(1)
 * - Binary Search: Time O(log N), Space O(1)
 * - Duplicates handling: When duplicate values exist at the band boundaries,
 *   a standard binary search might land on any arbitrary duplicate. We must find:
 *   1) The first occurrence of a score >= low (lower bound index)
 *   2) The first occurrence of a score > high (upper bound index)
 *   The count of scores in [low, high] is then (upper bound index - lower bound index).
 */
public class Problem4_ExamScoreBandCounter {

    /**
     * Finds the first index where scores[i] >= target (lower bound).
     * If all elements are < target, returns scores.length.
     */
    public static int findFirstGTE(int[] scores, int target) {
        int low = 0;
        int high = scores.length - 1;
        int result = scores.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= target) {
                result = mid;
                high = mid - 1; // Search left half for earlier occurrence
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * Finds the first index where scores[i] > target (upper bound).
     * If no element is > target, returns scores.length.
     */
    public static int findFirstGT(int[] scores, int target) {
        int low = 0;
        int high = scores.length - 1;
        int result = scores.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > target) {
                result = mid;
                high = mid - 1; // Search left half for earlier occurrence
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * Counts the number of scores within [low, high] in O(log N) time.
     */
    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }
        int lowerIndex = findFirstGTE(scores, low);
        int upperIndex = findFirstGT(scores, high);
        return Math.max(0, upperIndex - lowerIndex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        Integer low = null;
        Integer high = null;

        if (scanner.hasNextLine()) {
            String fullInput = scanner.nextLine().trim();
            // Parse flexible formats, e.g.:
            // scores = [35, 42, 42, 50, 58, 58, 58, 63, 71, 88], low = 42, high = 58
            // or raw lines
            if (fullInput.contains("scores")) {
                int start = fullInput.indexOf('[');
                int end = fullInput.indexOf(']');
                if (start != -1 && end != -1) {
                    String[] tokens = fullInput.substring(start + 1, end).split("[,\\s]+");
                    for (String t : tokens) {
                        if (!t.isEmpty()) list.add(Integer.parseInt(t));
                    }
                }
                if (fullInput.contains("low")) {
                    String afterLow = fullInput.substring(fullInput.indexOf("low"));
                    Scanner s = new Scanner(afterLow.replaceAll("[^0-9 ]", " "));
                    if (s.hasNextInt()) low = s.nextInt();
                    if (s.hasNextInt()) high = s.nextInt();
                    s.close();
                }
            } else {
                fullInput = fullInput.replace("[", "").replace("]", "").replace(",", " ");
                Scanner lineScanner = new Scanner(fullInput);
                while (lineScanner.hasNextInt()) {
                    list.add(lineScanner.nextInt());
                }
                lineScanner.close();
                if (scanner.hasNextInt()) low = scanner.nextInt();
                if (scanner.hasNextInt()) high = scanner.nextInt();
            }
        }

        int[] scores;
        if (!list.isEmpty() && low != null && high != null) {
            scores = new int[list.size()];
            for (int i = 0; i < list.size(); i++) scores[i] = list.get(i);
            System.out.println(countInBand(scores, low, high));
        } else {
            // Default sample demonstration:
            // Sample 1: scores = [35, 42, 42, 50, 58, 58, 58, 63, 71, 88], low = 42, high = 58 -> Output: 6
            // Sample 2: low = 90, high = 100 -> Output: 0
            int[] sampleScores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
            System.out.println("Sample 1 (low=42, high=58): " + countInBand(sampleScores, 42, 58));
            System.out.println("Sample 2 (low=90, high=100): " + countInBand(sampleScores, 90, 100));
        }
        scanner.close();
    }
}
