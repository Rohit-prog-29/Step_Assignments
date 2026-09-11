# Week 1 - Assignment Problems

This directory contains the Java implementations for **Week 1 Assignment Problems**.

---

## Problem Summaries

| # | Problem Name | Java File | Primary Concepts | Suggested Method Signature |
|---|--------------|-----------|------------------|----------------------------|
| 1 | The Exam Hall Seat Duplication Checker | `Problem1_ExamSeatDuplication.java` | Arrays, nested loops, conditional logic | `void checkDuplicateSeats(int[] seatNumbers)` |
| 2 | The Typing Speed Test Accuracy Checker | `Problem2_TypingSpeedAccuracy.java` | String traversal, `charAt()`, percentage calculation | `void checkTypingAccuracy(String original, String typed)` |
| 3 | The Traffic Signal Streak Analyzer | `Problem3_TrafficSignalStreak.java` | String traversal, streak tracking, maximum streak | `void findLongestStreak(String signalLog)` |
| 4 | The Warehouse Inventory Balancer | `Problem4_WarehouseInventory.java` | Arrays, sum accumulation, tracking max index | `void analyzeInventory(int[] sectionA, int[] sectionB)` |
| 5 | The Movie Review Word Length Profiler | `Problem5_MovieReviewWordLength.java` | String splitting (`split()`), counting categories | `void classifyWordLengths(String review)` |

---

## How to Run

```cmd
javac week_1/assignment_problems/*.java

java -cp week_1/assignment_problems Problem1_ExamSeatDuplication
java -cp week_1/assignment_problems Problem2_TypingSpeedAccuracy
java -cp week_1/assignment_problems Problem3_TrafficSignalStreak
java -cp week_1/assignment_problems Problem4_WarehouseInventory
java -cp week_1/assignment_problems Problem5_MovieReviewWordLength
```
