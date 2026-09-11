/**
 * Week 1 Assignment - Problem 1: The Exam Hall Seat Duplication Checker
 * Scenario: Examination Cell seat allocation verification.
 * 
 * Compares every seat number against every other seat number using arrays and loops only
 * to detect any duplicate seat assignments.
 */
public class Problem1_ExamSeatDuplication {

    /**
     * Checks an array of seat numbers for duplicate assignments.
     * Uses nested loops and standard arrays (no Collections).
     * 
     * @param seatNumbers Array of integer seat numbers
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length <= 1) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    return; // Report first duplicate found
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Exam Hall Seat Duplication Checker");
        System.out.println("==================================================");

        int[] sample1 = {101, 102, 103, 102, 105};
        System.out.print("Input:  {101, 102, 103, 102, 105}\nOutput: ");
        checkDuplicateSeats(sample1);

        System.out.println("--------------------------------------------------");

        int[] sample2 = {101, 102, 103, 104, 105};
        System.out.print("Input:  {101, 102, 103, 104, 105}\nOutput: ");
        checkDuplicateSeats(sample2);

        System.out.println("==================================================\n");
    }
}
