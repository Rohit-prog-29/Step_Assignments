import java.util.Scanner;

/**
 * Problem 6: Prime Number Checker
 * Task: Write a program that reads a number greater than 1 and determines whether
 * it is a prime number. A prime number is a natural number greater than 1 that has
 * no positive divisors other than 1 and itself. Print whether the number is prime or not.
 */
public class Problem6_PrimeNumberChecker {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void checkAndPrint(int n) {
        if (isPrime(n)) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            while (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                checkAndPrint(n);
            }
        } else {
            // Default sample: 29 and 21
            checkAndPrint(29);
            checkAndPrint(21);
        }
        scanner.close();
    }
}
