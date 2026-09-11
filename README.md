# Step_Assignments

This repository contains the weekly practice and assignment problems for the **STEP Program (Semester 3)**.

GitHub Repository: [https://github.com/Rohit-prog-29/Step_Assignments](https://github.com/Rohit-prog-29/Step_Assignments)

---

## 📁 Repository Structure

```
Step_Assignments/
├── README.md
├── week_1/
│   ├── practice_problems/     (5 Problems)
│   └── assignment_problems/   (5 Problems)
├── week_2/
│   ├── practice_problems/     (5 Problems - Category C LeetCode)
│   └── assignment_problems/   (5 Problems - Category C LeetCode)
├── week_3/
│   ├── practice_problems/     (5 Tiered Problems)
│   └── assignment_problems/   (5 Tiered Problems)
├── week_4/
│   ├── practice_problems/
│   └── assignment_problems/
└── week_5/
    ├── practice_problems/
    └── assignment_problems/
```

---

## 📚 Overview of Solved Problems

### Week 1
* **Practice Problems**:
  1. `Problem1_RockPaperScissors.java` - Rock-Paper-Scissors game simulator.
  2. `Problem2_PalindromeChecker.java` - Palindrome checker with 3 approaches (Iterative, Recursive, Array Reversal).
  3. `Problem3_BMICalculator.java` - Team BMI calculator and wellness report table.
  4. `Problem4_FirstNonRepeatingChar.java` - First non-repeating character finder.
  5. `Problem5_ReverseCustomerName.java` - Customer name string reversal.
* **Assignment Problems**:
  1. `Problem1_ExamSeatDuplication.java` - Seat duplication checker.
  2. `Problem2_TypingSpeedAccuracy.java` - Typing speed test accuracy checker.
  3. `Problem3_TrafficSignalStreak.java` - Traffic signal streak analyzer.
  4. `Problem4_WarehouseInventory.java` - Warehouse inventory balancer.
  5. `Problem5_MovieReviewWordLength.java` - Movie review word length profiler.

### Week 2 (LeetCode Category C)
* **Practice Problems**:
  1. `Problem1_TwoSum.java` - Two sum pair search ($O(n^2)$ pairwise search).
  2. `Problem2_BestTimeToBuyAndSellStock.java` - Max stock profit single pass.
  3. `Problem3_ContainsDuplicate.java` - Duplicate element detection.
  4. `Problem4_MergeTwoSortedArrays.java` - Two-pointer array merge.
  5. `Problem5_RotateArray.java` - Array rotation using modulo arithmetic.
* **Assignment Problems**:
  1. `Problem1_ProductExceptSelf.java` - Product of array except self without division ($O(n)$ time, $O(1)$ space).
  2. `Problem2_MaximumSubarray.java` - Maximum contiguous subarray sum (Kadane's Algorithm).
  3. `Problem3_ThreeSum.java` - 3Sum unique triplets ($O(n^2)$ two pointers).
  4. `Problem4_SubarraySumEqualsK.java` - Subarray sum equals k ($O(n)$ prefix sums + HashMap).
  5. `Problem5_FindMinInRotatedSortedArray.java` - Find minimum in rotated sorted array ($O(\log n)$ binary search).

### Week 3 (Tiered Problems)
* **Practice Problems**:
  1. `Problem1_FantasyTeamMultiplier.java` - Fantasy team score multiplier.
  2. `Problem2_DuplicatePlayerPick.java` - Duplicate player pick checker.
  3. `Problem3_TopPerformerTracker.java` - Single pass min, max, and spread tracker.
  4. `Problem4_MatchDayGridAnalyzer.java` - Match day 2D grid analyzer (Power Surge vs Normal).
  5. `Problem5_FantasyLeagueAutoDraft.java` - Auto-draft ranking engine (Method overloading & `Comparable`).
* **Assignment Problems**:
  1. `Problem1_HackathonScoreCurveBooster.java` - Hackathon score curve booster.
  2. `Problem2_DuplicateTeamNameFinder.java` - Duplicate team name finder.
  3. `Problem3_TopThreePodiumFinder.java` - Single pass top-3 podium finder.
  4. `Problem4_HackathonSeatingGridOptimizer.java` - Seating grid optimizer (Buzzing Zone vs Quiet Zone).
  5. `Problem5_PlacementDriveShortlisting.java` - Placement drive shortlisting & ranking engine (Method overloading & `Comparable`).

---

## 🛠️ How to Compile & Run

From the root directory:

```cmd
# Compile all problems
javac week_1/practice_problems/*.java week_1/assignment_problems/*.java week_2/practice_problems/*.java week_2/assignment_problems/*.java week_3/practice_problems/*.java week_3/assignment_problems/*.java

# Run any specific problem, e.g.:
java -cp week_2/assignment_problems Problem2_MaximumSubarray
java -cp week_3/assignment_problems Problem5_PlacementDriveShortlisting
```
