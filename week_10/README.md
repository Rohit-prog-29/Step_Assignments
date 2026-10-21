# Week 10 - Control Flow, Arrays, Strings, OOP Basics & Algorithms (Category C)

This folder contains Java implementations for Week 10 covering **Control Flow, Loops, Arrays, Strings, Object-Oriented Programming Fundamentals, Binary Search, and 2D Matrices**.

---

## Folder Structure

- **[`assignment_problems/`](./assignment_problems)** (and **[`assignment/`](./assignment)**): Contains 4 coding assignment problems.
  1. `Problem4_ExamScoreBandCounter.java` - Modified binary search to count scores in `[low, high]` on up to $10^6$ elements in $O(\log N)$ time.
  2. `Problem6_ClassAttendanceTracker.java` - Single-pass algorithm to compute present days and longest consecutive attendance streak.
  3. `Problem8_DutyRosterRotation.java` - Roster rotation by $k$ places ($k \le 10^9$) in $O(n)$ time using modulo arithmetic.
  4. `Problem10_BusiestBusRow.java` - 2D grid analyzer to find the bus row with maximum passengers, breaking ties by lowest index.
  5. `README.md` - Assignment problems overview, complexity analysis, and run instructions.

- **[`practice_problems/`](./practice_problems)** (and **[`practice/`](./practice)**): Contains 10 coding practice problems along with Part B Quiz (Q1-Q20) and Part C Concept Questions (Q1-Q10).
  1. `Problem1_VowelAndConsonantCounter.java` - Counts vowels and consonants in a word.
  2. `Problem2_WordReverserAndPalindromeChecker.java` - Reverses words using `StringBuilder` and checks palindrome property.
  3. `Problem3_EvenAndOddNumbersInAList.java` - Counts even and odd numbers in a list.
  4. `Problem4_InPlaceArrayReversal.java` - Two-pointer in-place array reversal.
  5. `Problem5_DigitSumAndNumberReversal.java` - Computes digit sum and reversed number using modulo and division.
  6. `Problem6_PrimeNumberChecker.java` - Tests primality in $O(\sqrt{n})$ time.
  7. `Problem7_FactorialCalculation.java` - Factorial calculation with `BigInteger`.
  8. `Problem8_StudentGradeAssignment.java` - If-else ladder for grading marks.
  9. `Problem9_LeapYearDetector.java` - Leap year detection using boolean logic.
  10. `Problem10_StudentResultCardGenerator.java` - `Student` class calculating average marks and result cards.
  11. `README.md` - Complete solutions and detailed explanations for Part B Quiz (Q1-Q20) and Part C Concept Questions (Q1-Q10).

---

## How to Compile & Run

From the root directory:

```bash
# Compile all Week 10 programs
javac week_10/assignment_problems/*.java week_10/practice_problems/*.java

# Run sample assignment problem
java -cp week_10/assignment_problems Problem4_ExamScoreBandCounter

# Run sample practice problem
java -cp week_10/practice_problems Problem1_VowelAndConsonantCounter
```
