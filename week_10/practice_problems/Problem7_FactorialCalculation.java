import java.math.BigInteger;
import java.util.Scanner;

/**
 * Problem 7: Factorial Calculation
 * Task: Write a program that reads a non-negative integer and calculates its factorial.
 * The factorial of a non-negative integer 'n', denoted by 'n!', is the product of
 * all positive integers less than or equal to 'n'. The factorial of 0 is defined as 1.
 */
public class Problem7_FactorialCalculation {

    public static BigInteger calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            while (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                System.out.println(calculateFactorial(n));
            }
        } else {
            // Default sample: 5 and 0
            System.out.println(calculateFactorial(5));
            System.out.println(calculateFactorial(0));
        }
        scanner.close();
    }
}
