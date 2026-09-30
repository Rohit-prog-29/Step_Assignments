class Scorecard {
    private final boolean[] results;
    private int answersRecorded;

    Scorecard(int questionCount) {
        if (questionCount < 0) {
            throw new IllegalArgumentException("Question count cannot be negative.");
        }
        results = new boolean[questionCount];
    }

    boolean recordAnswer(boolean isCorrect) {
        if (answersRecorded == results.length) {
            return false;
        }
        results[answersRecorded++] = isCorrect;
        return true;
    }

    int getScore() {
        int score = 0;
        for (boolean isCorrect : results) {
            if (isCorrect) {
                score++;
            }
        }
        return score;
    }
}

public class Problem2_QuizScorecard {
    public static void main(String[] args) {
        Scorecard scorecard = new Scorecard(4);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(false);
        scorecard.recordAnswer(true);

        System.out.println("Score: " + scorecard.getScore());
        System.out.println("Extra answer accepted: " + scorecard.recordAnswer(true));
    }
}