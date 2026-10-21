# Week 10 - Coding Assignment Problems (Category C)

This directory contains solutions for Week 10 Coding Assignment problems covering **Binary Search, Array Manipulations, Rotation Algorithms, and 2D Matrix Traversals** in Java.

---

## Assignment Problems Overview

1. **Problem 4: Exam Score Band Counter** ([`Problem4_ExamScoreBandCounter.java`](./Problem4_ExamScoreBandCounter.java))
   - **Task:** Counts the number of exam scores fall within `[low, high]` (inclusive) in a sorted array containing up to $10^6$ elements.
   - **Approach:** Standard linear scanning takes $O(N)$ time, which is too slow for frequent queries on large datasets. This solution utilizes modified binary search ($O(\log N)$ time, $O(1)$ space):
     - `findFirstGTE(scores, low)` finds the first index where `score >= low` (lower bound).
     - `findFirstGT(scores, high)` finds the first index where `score > high` (upper bound).
     - Duplicates at band edges are cleanly handled by searching the left sub-ranges upon match.
     - Result count is `upperIndex - lowerIndex`.

2. **Problem 6: Class Attendance Tracker** ([`Problem6_ClassAttendanceTracker.java`](./Problem6_ClassAttendanceTracker.java))
   - **Task:** Analyzes a binary attendance array of $1$s (present) and $0$s (absent) to return the total number of present days and the longest unbroken streak of consecutive present days.
   - **Approach:** Single-pass iteration ($O(N)$ time, $O(1)$ auxiliary space) tracking a running streak that increments on $1$s (updating max streak) and resets to $0$ on $0$s.

3. **Problem 8: Duty Roster Rotation** ([`Problem8_DutyRosterRotation.java`](./Problem8_DutyRosterRotation.java))
   - **Task:** Rotates a hostel cleaning roster right by $k$ positions where $k \le 10^9$.
   - **Approach:** Rotating 1-by-1 takes $O(k \times n)$ time, which would cause Time Limit Exceeded (TLE) when $k = 10^9$. By reducing full cycles via $k \pmod n$, each element at index $i$ is directly placed at index $(i + k) \pmod n$ in $O(n)$ time and $O(n)$ space (or $O(1)$ auxiliary space via 3-step reversal).

4. **Problem 10: Busiest Bus Row** ([`Problem10_BusiestBusRow.java`](./Problem10_BusiestBusRow.java))
   - **Task:** Scans a 2D bus seating grid to identify the row index carrying the highest total students. If rows tie, the smaller row index is chosen.
   - **Approach:** Traverses each row with an outer loop and sums seat counts in an inner loop ($O(r \times c)$ time, $O(1)$ auxiliary space). Enforces strict inequality (`rowSum > maxTotal`) so that ties strictly favor the smaller index.

---

## Compilation & Execution

```bash
# Compile assignment problems
javac week_10/assignment_problems/*.java

# Run sample problems
java -cp week_10/assignment_problems Problem4_ExamScoreBandCounter
java -cp week_10/assignment_problems Problem6_ClassAttendanceTracker
java -cp week_10/assignment_problems Problem8_DutyRosterRotation
java -cp week_10/assignment_problems Problem10_BusiestBusRow
```
