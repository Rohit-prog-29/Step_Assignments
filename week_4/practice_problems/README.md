# Week 4 - Practice Problems (Category C)

This directory contains the Java implementations for **Week 4 Practice Problems (LeetCode Category C)**.

---

## Problem Summaries

| # | Problem Name | Java File | Primary Concepts | Suggested Method Signature |
|---|--------------|-----------|------------------|----------------------------|
| L1 | Two Sum | `Problem1_TwoSum.java` | Nested loops, array indexing, pairwise search | `int[] twoSum(int[] nums, int target)` |
| L2 | Best Time to Buy and Sell Stock | `Problem2_BestTimeToBuyAndSellStock.java` | Single pass tracking min & max profit | `int maxProfit(int[] prices)` |
| L3 | Contains Duplicate | `Problem3_ContainsDuplicate.java` | Nested loops, pairwise comparison, boolean logic | `boolean containsDuplicate(int[] nums)` |
| L4 | Merge Two Sorted Arrays | `Problem4_MergeTwoSortedArrays.java` | Two pointers, while loops, array merging | `int[] mergeSortedArrays(int[] arr1, int[] arr2)` |
| L5 | Rotate Array | `Problem5_RotateArray.java` | Modulo arithmetic, wraparound indexing | `int[] rotateArray(int[] nums, int k)` |

---

## How to Run

```cmd
javac week_4/practice_problems/*.java

java -cp week_4/practice_problems Problem1_TwoSum
java -cp week_4/practice_problems Problem2_BestTimeToBuyAndSellStock
java -cp week_4/practice_problems Problem3_ContainsDuplicate
java -cp week_4/practice_problems Problem4_MergeTwoSortedArrays
java -cp week_4/practice_problems Problem5_RotateArray
```
