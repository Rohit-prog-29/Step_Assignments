import java.util.Scanner;

/**
 * Problem 1: Vowel and Consonant Counter
 * Task: Write a program that reads a single word and then counts and prints the
 * total number of vowels and consonants in that word. Assume the input word
 * contains only alphabetic characters (case-insensitive).
 */
public class Problem1_VowelAndConsonantCounter {

    public static void countVowelsAndConsonants(String word) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String word = scanner.next();
            countVowelsAndConsonants(word);
        } else {
            // Default sample demonstration
            countVowelsAndConsonants("Programming");
        }
        scanner.close();
    }
}
