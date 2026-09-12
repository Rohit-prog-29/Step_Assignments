/**
 * Week 4 Practice - Problem L3: Contains Duplicate
 * Scenario: Exam seating chart roll number duplicate verification.
 * 
 * Uses nested loops to check if any two distinct positions hold identical values.
 */
public class Problem3_ContainsDuplicate {

    /**
     * Checks if array contains any duplicate values using pairwise comparison.
     * 
     * @param nums Input array of integers
     * @return true if duplicate exists, false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 4 Practice - L3. Contains Duplicate");
        System.out.println("==================================================");

        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input:  nums = [1, 2, 3, 1]");
        System.out.println("Output: " + containsDuplicate(nums1));

        System.out.println("--------------------------------------------------");

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Input:  nums = [1, 2, 3, 4]");
        System.out.println("Output: " + containsDuplicate(nums2));

        System.out.println("==================================================\n");
    }
}
