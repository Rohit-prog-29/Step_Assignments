import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ExamQuestion {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public ExamQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract String getQuestionType();
    public abstract double gradeQuestion();
}

class McqQuestion extends ExamQuestion {
    public McqQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "MCQ";
    }

    @Override
    public double gradeQuestion() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0;
    }
}

class TfQuestion extends ExamQuestion {
    public TfQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "TF";
    }

    @Override
    public double gradeQuestion() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0;
    }
}

class EssayQuestion extends ExamQuestion {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "ESSAY";
    }

    @Override
    public double gradeQuestion() {
        String[] keywords = correctAnswer.split(",");
        int matchedCount = 0;
        String studentAnsLower = studentAnswer.toLowerCase();
        for (String kw : keywords) {
            String cleanKw = kw.trim().toLowerCase();
            if (!cleanKw.isEmpty() && studentAnsLower.contains(cleanKw)) {
                matchedCount++;
            }
        }

        if (matchedCount >= 2) {
            return points * 0.75;
        } else if (matchedCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class Problem4_ExaminationQuestionGrader {

    public static void processQuestions(List<ExamQuestion> questions) {
        double totalScore = 0.0;
        for (ExamQuestion q : questions) {
            double score = q.gradeQuestion();
            System.out.printf("%s: %.2f%n", q.getQuestionType(), score);
            totalScore += score;
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
    }

    public static void main(String[] args) {
        List<ExamQuestion> questions = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                String qText = scanner.next();
                String cAns = scanner.next();
                String sAns = scanner.next();
                double pts = scanner.nextDouble();
                switch (type.toUpperCase()) {
                    case "MCQ":
                        questions.add(new McqQuestion(qText, cAns, sAns, pts));
                        break;
                    case "TF":
                        questions.add(new TfQuestion(qText, cAns, sAns, pts));
                        break;
                    case "ESSAY":
                        questions.add(new EssayQuestion(qText, cAns, sAns, pts));
                        break;
                }
            }
            processQuestions(questions);
        } else {
            // Sample test case matching prompt exactly
            questions.add(new McqQuestion("What is the capital of France?", "Paris", "Paris", 10));
            questions.add(new TfQuestion("The Earth is flat?", "False", "True", 5));
            questions.add(new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20));
            questions.add(new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15));
            processQuestions(questions);
        }
        scanner.close();
    }
}
