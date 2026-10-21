import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Category C · Coding Assignment
 * Problem 6: Class Attendance Tracker
 *
 * TASK:
 * A teacher records attendance for one student as an array of 1s (present) and 0s (absent),
 * one value per day. The teacher wants to know how many days the student was present and
 * the longest run of days the student attended without a break.
 *
 * Implement a function attendanceSummary(days) that returns the number of present days
 * and the length of the longest unbroken run of present days.
 *
 * CONSTRAINTS:
 * - 1 <= length of days <= 100
 * - Each value is 0 or 1
 *
 * COMPLEXITY REQUIREMENTS:
 * - Time Complexity: O(N) where N is the length of the days array.
 * - Auxiliary Space Complexity: O(1) extra space.
 * - Single Pass: Yes, both answers are determined simultaneously in a single pass
 *   by updating the present day counter and running streak tracker within the same loop.
 */
public class Problem6_ClassAttendanceTracker {

    public static class AttendanceResult {
        public final int presentDays;
        public final int longestStreak;

        public AttendanceResult(int presentDays, int longestStreak) {
            this.presentDays = presentDays;
            this.longestStreak = longestStreak;
        }

        @Override
        public String toString() {
            return "Present: " + presentDays + ", Longest streak: " + longestStreak;
        }
    }

    /**
     * Calculates total present days and longest streak of consecutive present days in a single pass.
     */
    public static AttendanceResult attendanceSummary(int[] days) {
        int presentCount = 0;
        int longestStreak = 0;
        int currentStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new AttendanceResult(presentCount, longestStreak);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.contains("days")) {
                int start = line.indexOf('[');
                int end = line.indexOf(']');
                if (start != -1 && end != -1) {
                    line = line.substring(start + 1, end);
                }
            }
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNextInt()) {
                list.add(lineScanner.nextInt());
            }
            lineScanner.close();
        }

        if (!list.isEmpty()) {
            int[] days = new int[list.size()];
            for (int i = 0; i < list.size(); i++) days[i] = list.get(i);
            System.out.println(attendanceSummary(days));
        } else {
            // Default sample demonstration:
            // Sample 1: days = [1, 1, 0, 1, 1, 1, 0, 1] -> Present: 6, Longest streak: 3
            // Sample 2: days = [0, 0, 0] -> Present: 0, Longest streak: 0
            int[] sample1 = {1, 1, 0, 1, 1, 1, 0, 1};
            int[] sample2 = {0, 0, 0};
            System.out.println("Sample 1: " + attendanceSummary(sample1));
            System.out.println("Sample 2: " + attendanceSummary(sample2));
        }

        scanner.close();
    }
}
