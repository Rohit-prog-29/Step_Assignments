import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Week 5 Practice - Problem 5: Placement Drive Shortlisting & Ranking Engine
 * Scenario: Placement cell shortlisting candidates and ranking them by composite score.
 * 
 * Features:
 * - Candidate class implementing Comparable<Candidate>
 * - Overloaded static isEligible methods
 * - Shortlisting & ranking using standard Arrays.sort()
 */
public class Problem5_PlacementDriveShortlisting {

    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        public double getCompositeScore() {
            return (cgpa * 10.0) + codingScore;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    /**
     * Overloaded rule 1: CGPA-only quick filter (CGPA >= 8.0).
     */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 8.0;
    }

    /**
     * Overloaded rule 2: Combined CGPA and coding score filter (CGPA >= 6.5 and codingScore >= 60).
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    /**
     * Shortlists eligible candidates and ranks them by composite score.
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> shortlistedList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlistedList.add(c);
            }
        }

        Candidate[] shortlistedArray = shortlistedList.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(shortlistedArray[i].getName())
              .append(String.format(" (%.1f)", shortlistedArray[i].getCompositeScore()));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 5 Practice - Placement Drive Shortlisting & Ranking Engine");
        System.out.println("==================================================");

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println("Output: \"" + shortlistAndRank(candidates) + "\"");
        System.out.println("==================================================\n");
    }
}
