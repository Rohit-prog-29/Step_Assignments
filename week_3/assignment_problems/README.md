# Week 3 - Assignment Problems (Category C)

This directory contains the Java implementations for **Week 3 Assignment Problems**.

---

## Problem Summaries

| # | Problem Name | Java File | Primary Concepts | Suggested Signature / Details |
|---|--------------|-----------|------------------|-------------------------------|
| 1 | Hackathon Score Curve Booster | `Problem1_HackathonScoreCurveBooster.java` | In-place array modification | `void curveScores(int[] scores, int bonus)` |
| 2 | Duplicate Team Name Finder | `Problem2_DuplicateTeamNameFinder.java` | Pairwise comparison, strings | `String findDuplicateTeam(String[] teamNames)` |
| 3 | Top-3 Podium Finder | `Problem3_TopThreePodiumFinder.java` | Single pass tracking top 3 | `int[] findTopThreeScores(int[] scores)` |
| 4 | Hackathon Seating Grid Optimizer | `Problem4_HackathonSeatingGridOptimizer.java` | 2D Arrays, helper method | `double rowAverage(int[] row)`, `String classifyRows(int[][] seatingScores, int threshold)` |
| 5 | Placement Drive Shortlisting | `Problem5_PlacementDriveShortlisting.java` | Method overloading, OOP, `Comparable` | `Candidate` class, `isEligible`, `shortlistAndRank(Candidate[] candidates)` |

---

## How to Run

```cmd
javac week_3/assignment_problems/*.java

java -cp week_3/assignment_problems Problem1_HackathonScoreCurveBooster
java -cp week_3/assignment_problems Problem2_DuplicateTeamNameFinder
java -cp week_3/assignment_problems Problem3_TopThreePodiumFinder
java -cp week_3/assignment_problems Problem4_HackathonSeatingGridOptimizer
java -cp week_3/assignment_problems Problem5_PlacementDriveShortlisting
```
