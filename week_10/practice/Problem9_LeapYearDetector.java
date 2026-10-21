import java.util.Scanner;

/**
 * Problem 9: Leap Year Detector
 * Task: Write a program that reads a year and determines if it is a leap year.
 * A year is a leap year if it is divisible by 4, but not by 100, unless it is
 * also divisible by 400.
 */
public class Problem9_LeapYearDetector {

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void checkAndPrint(int year) {
        if (isLeapYear(year)) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            while (scanner.hasNextInt()) {
                int year = scanner.nextInt();
                checkAndPrint(year);
            }
        } else {
            // Default sample: 2024, 1900, 2000
            checkAndPrint(2024);
            checkAndPrint(1900);
            checkAndPrint(2000);
        }
        scanner.close();
    }
}
