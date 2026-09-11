/**
 * Week 3 Practice - Problem 2: Duplicate Player Pick Checker
 * Scenario: Fantasy app draft screen checking submitted lineup for repeated player names.
 * 
 * Uses plain nested loops without Collections.
 */
public class Problem2_DuplicatePlayerPick {

    /**
     * Checks a submitted lineup for repeated player names.
     * 
     * @param playerNames Array of player names
     * @return String indicating duplicate found or none
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length <= 1) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equalsIgnoreCase(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Duplicate Player Pick Checker");
        System.out.println("==================================================");

        String[] sample1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Input:  {\"Kohli\", \"Bumrah\", \"Kohli\", \"Rohit\"}");
        System.out.println("Output: \"" + findDuplicatePick(sample1) + "\"");

        System.out.println("--------------------------------------------------");

        String[] sample2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("Input:  {\"Kohli\", \"Bumrah\", \"Rohit\"}");
        System.out.println("Output: \"" + findDuplicatePick(sample2) + "\"");

        System.out.println("==================================================\n");
    }
}
