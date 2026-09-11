import java.util.Arrays;

/**
 * Week 2 Practice - Problem L1: Two Sum
 * Scenario: Shopkeeper matching item prices to customer budget.
 * 
 * Uses nested loops to find indices [i, j] such that nums[i] + nums[j] == target.
 */
public class Problem1_TwoSum {

    /**
     * Finds indices of two numbers that add up to target using pairwise search.
     * 
     * @param nums   Array of item prices
     * @param target Target budget
     * @return Array containing two indices [i, j]
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Category C - L1. Two Sum");
        System.out.println("==================================================");

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input:  nums = [2, 7, 11, 15], target = 9");
        System.out.println("Output: " + Arrays.toString(twoSum(nums1, target1)));

        System.out.println("--------------------------------------------------");

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Input:  nums = [3, 2, 4], target = 6");
        System.out.println("Output: " + Arrays.toString(twoSum(nums2, target2)));

        System.out.println("==================================================\n");
    }
}
