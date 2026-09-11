import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Week 2 Assignment - Problem A3: 3Sum
 * Scenario: Student budgeting tool finding distinct triplet transactions that sum to zero.
 * 
 * Sorts array, then uses two-pointer approach with duplicate skipping in O(n^2) time.
 */
public class Problem3_ThreeSum {

    /**
     * Finds all unique triplets [nums[i], nums[j], nums[k]] such that nums[i] + nums[j] + nums[k] == 0.
     * 
     * @param nums Input array of integers
     * @return 2D array of unique triplets
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for third element
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Category C - A3. 3Sum");
        System.out.println("==================================================");

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input:  nums = [-1, 0, 1, 2, -1, -4]");
        System.out.println("Output: " + Arrays.deepToString(threeSum(nums1)));

        System.out.println("--------------------------------------------------");

        int[] nums2 = {0, 0, 0};
        System.out.println("Input:  nums = [0, 0, 0]");
        System.out.println("Output: " + Arrays.deepToString(threeSum(nums2)));

        System.out.println("==================================================\n");
    }
}
