import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Week 5 Assignment - Problem 5: Fantasy League Auto-Draft Ranking Engine
 * Scenario: Auto-draft ranking engine filtering draftable players and sorting by fantasy performance.
 * 
 * Features:
 * - Player class implementing Comparable<Player>
 * - Overloaded static isDraftable methods
 * - Draft ranking using standard Arrays.sort()
 */
public class Problem5_FantasyLeagueAutoDraft {

    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    /**
     * Overloaded rule 1: Matches-played-only rule for established players (>= 10 matches).
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Overloaded rule 2: Combined matches and fitness rule (>= 5 matches and not injured).
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    /**
     * Filters draftable players and ranks them descending by batting average.
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableList.add(p);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(draftableArray[i].getName());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Week 5 Assignment - Fantasy League Auto-Draft");
        System.out.println("==================================================");

        Player[] lineup = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println("Output: \"" + draftAndRank(lineup) + "\"");
        System.out.println("==================================================\n");
    }
}
