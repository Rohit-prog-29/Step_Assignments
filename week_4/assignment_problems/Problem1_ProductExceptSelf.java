import java.util.Arrays;

/**
 * Week 4 Assignment - Problem A1: Product of Array Except Self
 * Scenario: Product bundle price engine calculating product of all other items without division.
 * 
 * Uses two passes: forward pass for prefix products and backward pass for suffix products.
 * Time Complexity: O(n), Space Complexity: O(1) extra space beyond output array.
 */
public class Problem1_ProductExceptSelf {

    /**
     * Calculates product of all elements except nums[i] without using division.
     * 
     * @param nums Input array of integers
     * @return Output array answer where answer[i] is product of all elements except nums[i]
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: Accumulate prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Multiply by suffix products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 4 Assignment - A1. Product of Array Except Self");
        System.out.println("==================================================");

        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Input:  nums = [1, 2, 3, 4]");
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums1)));

        System.out.println("--------------------------------------------------");

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Input:  nums = [-1, 1, 0, -3, 3]");
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums2)));

        System.out.println("==================================================\n");
    }
}
