# Week 4 - Assignment Problems (Category C)

This directory contains the Java implementations for **Week 4 Assignment Problems (LeetCode Category C)**.

---

## Problem Summaries

| # | Problem Name | Java File | Primary Concepts | Suggested Method Signature | Time & Space |
|---|--------------|-----------|------------------|----------------------------|--------------|
| A1 | Product of Array Except Self | `Problem1_ProductExceptSelf.java` | Prefix/suffix products, 2 passes, no division | `int[] productExceptSelf(int[] nums)` | $O(n)$ time, $O(1)$ space |
| A2 | Maximum Subarray | `Problem2_MaximumSubarray.java` | Kadane's Algorithm, running sum reset | `int maxSubArray(int[] nums)` | $O(n)$ time, $O(1)$ space |
| A3 | 3Sum | `Problem3_ThreeSum.java` | Sorting, two pointers, duplicate avoidance | `int[][] threeSum(int[] nums)` | $O(n^2)$ time, $O(1)$ space |
| A4 | Subarray Sum Equals K | `Problem4_SubarraySumEqualsK.java` | Prefix sums, HashMap frequency counting | `int subarraySum(int[] nums, int k)` | $O(n)$ time, $O(n)$ space |
| A5 | Find Minimum in Rotated Sorted Array | `Problem5_FindMinInRotatedSortedArray.java` | Modified binary search | `int findMin(int[] nums)` | $O(\log n)$ time, $O(1)$ space |

---

## How to Run

```cmd
javac week_4/assignment_problems/*.java

java -cp week_4/assignment_problems Problem1_ProductExceptSelf
java -cp week_4/assignment_problems Problem2_MaximumSubarray
java -cp week_4/assignment_problems Problem3_ThreeSum
java -cp week_4/assignment_problems Problem4_SubarraySumEqualsK
java -cp week_4/assignment_problems Problem5_FindMinInRotatedSortedArray
```
