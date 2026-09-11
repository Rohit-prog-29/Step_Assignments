# Week 3 - Practice Problems (Category C Tiered)

This directory contains the Java implementations for **Week 3 Practice Problems**.

---

## Problem Summaries

| # | Problem Name | Java File | Primary Concepts | Suggested Signature / Details |
|---|--------------|-----------|------------------|-------------------------------|
| 1 | Fantasy Team Score Multiplier | `Problem1_FantasyTeamMultiplier.java` | In-place array modification | `void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex)` |
| 2 | Duplicate Player Pick Checker | `Problem2_DuplicatePlayerPick.java` | Pairwise comparison, strings | `String findDuplicatePick(String[] playerNames)` |
| 3 | Top Performer Tracker | `Problem3_TopPerformerTracker.java` | Single pass min/max tracking | `String findMinMaxSpread(int[] scores)` |
| 4 | Match Day Grid Analyzer | `Problem4_MatchDayGridAnalyzer.java` | 2D Arrays, helper method | `double rowAverage(int[] row)`, `String classifyMatches(int[][] runsPerOver, int threshold)` |
| 5 | Fantasy League Auto-Draft | `Problem5_FantasyLeagueAutoDraft.java` | Method overloading, OOP, `Comparable` | `Player` class, `isDraftable`, `draftAndRank(Player[] players)` |

---

## How to Run

```cmd
javac week_3/practice_problems/*.java

java -cp week_3/practice_problems Problem1_FantasyTeamMultiplier
java -cp week_3/practice_problems Problem2_DuplicatePlayerPick
java -cp week_3/practice_problems Problem3_TopPerformerTracker
java -cp week_3/practice_problems Problem4_MatchDayGridAnalyzer
java -cp week_3/practice_problems Problem5_FantasyLeagueAutoDraft
```
