/**
 * Week 4 Assignment - Problem A2: Maximum Subarray
 * Scenario: Trader searching for consecutive days with maximum cumulative profit.
 * 
 * Implements Kadane's Algorithm to find maximum sum contiguous subarray in O(n) time.
 */
public class Problem2_MaximumSubarray {

    /**
     * Finds maximum sum of a contiguous subarray using Kadane's Algorithm.
     * 
     * @param nums Array of integers (may contain negative numbers)
     * @return Maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 4 Assignment - A2. Maximum Subarray");
        System.out.println("==================================================");

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input:  nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]");
        System.out.println("Output: " + maxSubArray(nums1));

        System.out.println("--------------------------------------------------");

        int[] nums2 = {-3, -1, -2};
        System.out.println("Input:  nums = [-3, -1, -2]");
        System.out.println("Output: " + maxSubArray(nums2));

        System.out.println("==================================================\n");
    }
}
