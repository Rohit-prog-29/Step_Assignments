import java.util.Arrays;

/**
 * Week 4 Practice - Problem L5: Rotate Array
 * Scenario: Playlist queue rotation to the right by k positions.
 * 
 * Rotates array elements using modulo arithmetic wraparound indexing:
 * newArray[(i + k) % n] = nums[i].
 */
public class Problem5_RotateArray {

    /**
     * Rotates an array to the right by k positions.
     * 
     * @param nums Input array
     * @param k    Number of right-shift positions
     * @return Rotated array
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums == null ? new int[]{} : nums.clone();
        }

        int n = nums.length;
        int effectiveK = k % n;
        if (effectiveK < 0) {
            effectiveK += n;
        }

        if (effectiveK == 0) {
            return nums.clone();
        }

        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + effectiveK) % n] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 4 Practice - L5. Rotate Array");
        System.out.println("==================================================");

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Input:  nums = [1, 2, 3, 4, 5, 6, 7], k = 3");
        System.out.println("Output: " + Arrays.toString(rotateArray(nums1, k1)));

        System.out.println("--------------------------------------------------");

        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("Input:  nums = [1, 2], k = 3");
        System.out.println("Output: " + Arrays.toString(rotateArray(nums2, k2)));

        System.out.println("==================================================\n");
    }
}
