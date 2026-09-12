package week_1.practice_problems;

import java.util.Random;
import java.util.Scanner;

/**
 * Problem 1: Rock-Paper-Scissors Game
 * Scenario: The College Coding Arcade
 * 
 * Simulates several rounds of Rock-Paper-Scissors between a player and computer,
 * records the outcome of every round, and displays a summary table along with
 * win/loss statistics and win percentage.
 */
public class Problem1_RockPaperScissors {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    /**
     * Determines the winner of a single round of Rock-Paper-Scissors.
     * 
     * @param playerMove   The player's chosen move ("Rock", "Paper", or "Scissors")
     * @param computerMove The computer's move ("Rock", "Paper", or "Scissors")
     * @return Result string: "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid Move";
        }

        String p = playerMove.trim();
        String c = computerMove.trim();

        if (p.equalsIgnoreCase(c)) {
            return "Draw";
        }

        if ((p.equalsIgnoreCase("Rock") && c.equalsIgnoreCase("Scissors")) ||
            (p.equalsIgnoreCase("Paper") && c.equalsIgnoreCase("Rock")) ||
            (p.equalsIgnoreCase("Scissors") && c.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   College Coding Arcade - Rock-Paper-Scissors");
        System.out.println("==================================================");

        int totalRounds = 5;
        String[] predefinedPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();

        Scanner scanner = null;
        boolean interactive = false;
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            scanner = new Scanner(System.in);
            interactive = true;
        }

        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int round = 1; round <= totalRounds; round++) {
            String playerMove;
            if (interactive) {
                System.out.print("Round " + round + " - Enter your move (Rock, Paper, Scissors): ");
                playerMove = scanner.nextLine();
            } else {
                playerMove = predefinedPlayerMoves[round - 1];
            }

            String computerMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(playerMove, computerMove);

            playerMoves[round - 1] = playerMove;
            computerMoves[round - 1] = computerMove;
            results[round - 1] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        if (scanner != null) {
            scanner.close();
        }

        // Display summary table
        System.out.println("\n--------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-13s | %-13s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("Round %-2d | %-12s | %-13s | %-13s%n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("--------------------------------------------------");

        double winPercentage = ((double) wins / totalRounds) * 100.0;
        System.out.println("\nFinal Summary (after " + totalRounds + " rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
        System.out.println("==================================================\n");
    }
}
