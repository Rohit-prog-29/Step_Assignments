/**
 * Week 3 Assignment - Problem 2: Duplicate Team Name Finder
 * Scenario: Hackathon registration checking for duplicate team submissions.
 * 
 * Uses plain nested loops without Collections.
 */
public class Problem2_DuplicateTeamNameFinder {

    /**
     * Scans registered team names and reports the first duplicate found.
     * 
     * @param teamNames Array of team names
     * @return String indicating duplicate found or none
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length <= 1) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equalsIgnoreCase(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Duplicate Team Name Finder");
        System.out.println("==================================================");

        String[] sample1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println("Input:  {\"ByteForce\", \"CodeCrafters\", \"ByteForce\"}");
        System.out.println("Output: \"" + findDuplicateTeam(sample1) + "\"");

        System.out.println("--------------------------------------------------");

        String[] sample2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println("Input:  {\"ByteForce\", \"CodeCrafters\", \"NullPointers\"}");
        System.out.println("Output: \"" + findDuplicateTeam(sample2) + "\"");

        System.out.println("==================================================\n");
    }
}
