# Step_Assignments - Week 10 (Control Flow, Arrays, Strings, OOP Basics & Algorithms)

This repository branch contains the practice problems, assignment problems, quiz solutions, and concept questions for **Week 10: Control Flow, Arrays, Strings, OOP Basics & Algorithms (Category C)** for the **STEP Program (Semester 3)**.

GitHub Repository: [https://github.com/Rohit-prog-29/Step_Assignments](https://github.com/Rohit-prog-29/Step_Assignments)

---

## 📁 Branch Structure

```
Step_Assignments/
├── README.md
└── week_10/
    ├── README.md
    ├── assignment_problems/ (and assignment/)
    │   ├── Problem4_ExamScoreBandCounter.java
    │   ├── Problem6_ClassAttendanceTracker.java
    │   ├── Problem8_DutyRosterRotation.java
    │   ├── Problem10_BusiestBusRow.java
    │   └── README.md
    └── practice_problems/ (and practice/)
        ├── Problem1_VowelAndConsonantCounter.java
        ├── Problem2_WordReverserAndPalindromeChecker.java
        ├── Problem3_EvenAndOddNumbersInAList.java
        ├── Problem4_InPlaceArrayReversal.java
        ├── Problem5_DigitSumAndNumberReversal.java
        ├── Problem6_PrimeNumberChecker.java
        ├── Problem7_FactorialCalculation.java
        ├── Problem8_StudentGradeAssignment.java
        ├── Problem9_LeapYearDetector.java
        ├── Problem10_StudentResultCardGenerator.java
        └── README.md (Quiz Q1-Q20 & Concept Q1-Q10 Answers)
```

---

## 📚 Overview of Solved Problems

### Coding Assignment Problems (`week_10/assignment_problems/`)
1. **`Problem4_ExamScoreBandCounter.java`**: Counts marks in range `[low, high]` within a sorted array of up to $10^6$ items using modified binary search ($O(\log N)$ time, $O(1)$ space).
2. **`Problem6_ClassAttendanceTracker.java`**: Computes total attendance days and longest unbroken run of present days in a single pass ($O(N)$ time, $O(1)$ space).
3. **`Problem8_DutyRosterRotation.java`**: Rotates hostel cleaning roster right by $k$ places ($k \le 10^9$) in $O(n)$ time using modulo arithmetic to remove redundant full turns.
4. **`Problem10_BusiestBusRow.java`**: Scans 2D bus seating grid to identify the row carrying the highest number of students ($O(r \times c)$ time), breaking ties in favor of the smaller row index.

### Coding Practice Problems & Q&A (`week_10/practice_problems/`)
1. **`Problem1_VowelAndConsonantCounter.java`**: Counts vowels and consonants in a single word case-insensitively.
2. **`Problem2_WordReverserAndPalindromeChecker.java`**: Reverses word using `StringBuilder` and determines palindrome equality.
3. **`Problem3_EvenAndOddNumbersInAList.java`**: Counts even and odd numbers in a list using `% 2`.
4. **`Problem4_InPlaceArrayReversal.java`**: In-place array reversal using two pointers from opposite ends.
5. **`Problem5_DigitSumAndNumberReversal.java`**: Calculates digit sum and reverses digits via `% 10` and `/ 10`.
6. **`Problem6_PrimeNumberChecker.java`**: Efficient primality test checking factors up to $\lfloor\sqrt{n}\rfloor$.
7. **`Problem7_FactorialCalculation.java`**: Calculates non-negative factorial with `BigInteger` support for large inputs.
8. **`Problem8_StudentGradeAssignment.java`**: Grades student marks out of 100 via an `if-else if-else` ladder.
9. **`Problem9_LeapYearDetector.java`**: Determines leap years using divisibility conditions by 4, 100, and 400.
10. **`Problem10_StudentResultCardGenerator.java`**: Models `Student` class to compute average marks, assign grades, and format uppercase report cards.
11. **`README.md`**: Complete solutions and detailed explanations for Part B Quiz (Q1–Q20) and Part C Concept Questions (Q1–Q10).

---

## 🛠️ How to Compile & Run

From the repository root:

```bash
# Compile all Week 10 assignment and practice problems
javac week_10/assignment_problems/*.java week_10/practice_problems/*.java

# Run sample assignment problem
java -cp week_10/assignment_problems Problem4_ExamScoreBandCounter

# Run sample practice problem
java -cp week_10/practice_problems Problem1_VowelAndConsonantCounter
```
