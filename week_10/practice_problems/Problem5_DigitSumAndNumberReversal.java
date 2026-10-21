import java.util.Scanner;

/**
 * Problem 5: Digit Sum and Number Reversal
 * Task: Write a program that reads a positive integer and performs two operations:
 * it calculates and prints the sum of its digits, and it prints the number with
 * its digits reversed.
 */
public class Problem5_DigitSumAndNumberReversal {

    public static void computeSumAndReverse(int num) {
        int sumOfDigits = 0;
        int reversed = 0;
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            sumOfDigits += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sumOfDigits);
        System.out.println("Reverse: " + reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            computeSumAndReverse(num);
        } else {
            // Default sample: 4721
            computeSumAndReverse(4721);
        }
        scanner.close();
    }
}
