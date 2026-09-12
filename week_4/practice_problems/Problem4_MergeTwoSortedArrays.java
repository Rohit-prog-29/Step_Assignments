import java.util.Arrays;

/**
 * Week 4 Practice - Problem L4: Merge Two Sorted Arrays
 * Scenario: Examination office combining two pre-sorted score lists.
 * 
 * Merges two sorted arrays using a two-pointer while loop into a single sorted array.
 */
public class Problem4_MergeTwoSortedArrays {

    /**
     * Merges two sorted integer arrays into one sorted array.
     * 
     * @param arr1 First sorted array
     * @param arr2 Second sorted array
     * @return Fully merged and sorted result array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null) return arr2 == null ? new int[]{} : arr2.clone();
        if (arr2 == null) return arr1.clone();

        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            result[k++] = arr1[i++];
        }

        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 4 Practice - L4. Merge Two Sorted Arrays");
        System.out.println("==================================================");

        int[] arr1_a = {1, 3, 5};
        int[] arr2_a = {2, 4, 6};
        System.out.println("Input:  arr1 = [1, 3, 5], arr2 = [2, 4, 6]");
        System.out.println("Output: " + Arrays.toString(mergeSortedArrays(arr1_a, arr2_a)));

        System.out.println("--------------------------------------------------");

        int[] arr1_b = {};
        int[] arr2_b = {1, 2, 3};
        System.out.println("Input:  arr1 = [], arr2 = [1, 2, 3]");
        System.out.println("Output: " + Arrays.toString(mergeSortedArrays(arr1_b, arr2_b)));

        System.out.println("==================================================\n");
    }
}
