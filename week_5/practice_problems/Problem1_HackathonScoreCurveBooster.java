import java.util.Arrays;

/**
 * Week 5 Practice - Problem 1: Hackathon Score Curve Booster
 * Scenario: Campus hackathon judging panel boosting team scores in place.
 * 
 * Modifies the caller's array directly and uses Arrays.toString() for formatting.
 */
public class Problem1_HackathonScoreCurveBooster {

    /**
     * Boosts every score in place by adding flat bonus.
     * 
     * @param scores Array of team scores (modified in place)
     * @param bonus  Flat bonus to add
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null || bonus <= 0) return;
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 5 Practice - Hackathon Score Curve Booster");
        System.out.println("==================================================");

        int[] scores = {70, 85, 60};
        int bonus = 10;

        System.out.println("Input Scores:  " + Arrays.toString(scores) + ", bonus = " + bonus);
        curveScores(scores, bonus);
        System.out.println("Output Scores: " + Arrays.toString(scores));

        System.out.println("==================================================\n");
    }
}
