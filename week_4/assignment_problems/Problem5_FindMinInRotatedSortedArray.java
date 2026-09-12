/**
 * Week 4 Assignment - Problem A5: Find Minimum in Rotated Sorted Array
 * Scenario: Duty roster sorted by join date, rotated at unknown pivot point.
 * 
 * Implements modified binary search in O(log n) time.
 */
public class Problem5_FindMinInRotatedSortedArray {

    /**
     * Finds minimum element in a rotated sorted array of unique elements.
     * 
     * @param nums Rotated sorted array of unique integers
     * @return Minimum element in array
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 4 Assignment - A5. Find Min in Rotated Array");
        System.out.println("==================================================");

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input:  nums = [3, 4, 5, 1, 2]");
        System.out.println("Output: " + findMin(nums1));

        System.out.println("--------------------------------------------------");

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Input:  nums = [4, 5, 6, 7, 0, 1, 2]");
        System.out.println("Output: " + findMin(nums2));

        System.out.println("--------------------------------------------------");

        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Input:  nums = [11, 13, 15, 17]");
        System.out.println("Output: " + findMin(nums3));

        System.out.println("==================================================\n");
    }
}
