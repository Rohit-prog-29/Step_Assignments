# Week 1 - Practice Problems

This directory contains the complete Java implementations for **Week 1 Practice Problems (Day 1 Live-Coding Session)**.

---

## Problem Summaries & Implementations

| # | Problem Name | Java File | Primary Concepts Covered | Suggested Signature |
|---|--------------|-----------|---------------------------|---------------------|
| 1 | Rock-Paper-Scissors Game | `Problem1_RockPaperScissors.java` | Random numbers, loops, tabular output, statistics | `String playRound(String playerMove, String computerMove)` |
| 2 | Palindrome Checker (3 Approaches) | `Problem2_PalindromeChecker.java` | Loops, recursion, array reversal, string comparison | `isPalindromeIterative`, `isPalindromeRecursive`, `isPalindromeArrayReversal` |
| 3 | BMI Calculator for a Team | `Problem3_BMICalculator.java` | Parallel arrays, arithmetic, status classification, tabular output | `String getBmiStatus(double bmi)`, `void printWellnessReport(...)` |
| 4 | First Non-Repeating Character | `Problem4_FirstNonRepeatingChar.java` | Character frequency counting, HashMap, string scanning | `char findFirstNonRepeatingChar(String text)` |
| 5 | Reverse Customer Name | `Problem5_ReverseCustomerName.java` | String traversal, character array manipulation | `String reverseCustomerName(String customerName)` |

---

## How to Compile & Run

From the root of the repository (`Step_Assignments`):

```cmd
# 1. Compile all Java files in week_1/practice_problems
javac week_1/practice_problems/*.java

# 2. Run Problem 1: Rock-Paper-Scissors
java -cp week_1/practice_problems Problem1_RockPaperScissors

# 3. Run Problem 2: Palindrome Checker
java -cp week_1/practice_problems Problem2_PalindromeChecker

# 4. Run Problem 3: BMI Calculator
java -cp week_1/practice_problems Problem3_BMICalculator

# 5. Run Problem 4: First Non-Repeating Character
java -cp week_1/practice_problems Problem4_FirstNonRepeatingChar

# 6. Run Problem 5: Reverse Customer Name
java -cp week_1/practice_problems Problem5_ReverseCustomerName
```
