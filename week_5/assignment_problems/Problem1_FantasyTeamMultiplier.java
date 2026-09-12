import java.util.Arrays;

/**
 * Week 5 Assignment - Problem 1: Fantasy Team Score Multiplier
 * Scenario: Fantasy sports app applying Captain (2x) and Vice-Captain (1.5x) multipliers.
 * 
 * Modifies caller's array directly in place.
 */
public class Problem1_FantasyTeamMultiplier {

    /**
     * Applies Captain (2x) and Vice-Captain (1.5x) score multipliers directly to array.
     * 
     * @param playerScores     Array of player scores (modified in-place)
     * @param captainIndex     Index of captain
     * @param viceCaptainIndex Index of vice-captain
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) return;
        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }
        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 5 Assignment - Fantasy Team Score Multiplier");
        System.out.println("==================================================");

        double[] scores = {40, 55, 30, 62};
        System.out.println("Input Scores:  " + Arrays.toString(scores));
        applyMultipliers(scores, 1, 3);
        System.out.println("Output Scores: " + Arrays.toString(scores));

        System.out.println("==================================================\n");
    }
}
