import java.util.Scanner;

/**
 * Problem 8: Student Grade Assignment
 * Task: Write a program that reads a student's marks (out of 100) and prints their
 * corresponding grade based on the following criteria:
 * - A: 90 or above
 * - B: 75 to 89
 * - C: 60 to 74
 * - D: 40 to 59
 * - F: Below 40
 */
public class Problem8_StudentGradeAssignment {

    public static String assignGrade(double marks) {
        if (marks >= 90) {
            return "Grade A";
        } else if (marks >= 75) {
            return "Grade B";
        } else if (marks >= 60) {
            return "Grade C";
        } else if (marks >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            while (scanner.hasNextDouble()) {
                double marks = scanner.nextDouble();
                System.out.println(assignGrade(marks));
            }
        } else {
            // Default sample: 72, 95, 35
            System.out.println(assignGrade(72));
            System.out.println(assignGrade(95));
            System.out.println(assignGrade(35));
        }
        scanner.close();
    }
}
