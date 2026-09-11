import java.util.HashMap;
import java.util.Map;

/**
 * Week 2 Assignment - Problem A4: Subarray Sum Equals K
 * Scenario: Hostel attendance-change log analyzing stretches with net change k.
 * 
 * Uses prefix sums and HashMap frequency counting in O(n) time and O(n) space.
 */
public class Problem4_SubarraySumEqualsK {

    /**
     * Finds total number of contiguous subarrays whose sum equals k.
     * 
     * @param nums Input array of integers (may contain negative numbers)
     * @param k    Target sum k
     * @return Total count of matching subarrays
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // Base case for empty prefix

        int currentPrefixSum = 0;
        int count = 0;

        for (int num : nums) {
            currentPrefixSum += num;

            if (prefixSumMap.containsKey(currentPrefixSum - k)) {
                count += prefixSumMap.get(currentPrefixSum - k);
            }

            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Category C - A4. Subarray Sum Equals K");
        System.out.println("==================================================");

        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Input:  nums = [1, 1, 1], k = 2");
        System.out.println("Output: " + subarraySum(nums1, k1));

        System.out.println("--------------------------------------------------");

        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("Input:  nums = [1, -1, 0], k = 0");
        System.out.println("Output: " + subarraySum(nums2, k2));

        System.out.println("==================================================\n");
    }
}
