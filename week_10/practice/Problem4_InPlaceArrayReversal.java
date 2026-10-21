import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 4: In-Place Array Reversal
 * Task: Write a program that reverses the order of token numbers stored in a list.
 * The reversal must be done 'in-place', meaning you should modify the original list
 * directly without creating a second list.
 */
public class Problem4_InPlaceArrayReversal {

    /**
     * Reverses the given array in-place using two-pointer swapping.
     *
     * @param arr the integer array to reverse
     */
    public static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNextInt()) {
                list.add(lineScanner.nextInt());
            }
            lineScanner.close();
        }

        int[] arr;
        if (!list.isEmpty()) {
            arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
        } else {
            // Default sample: [11, 22, 33, 44]
            arr = new int[]{11, 22, 33, 44};
        }

        reverseInPlace(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}
