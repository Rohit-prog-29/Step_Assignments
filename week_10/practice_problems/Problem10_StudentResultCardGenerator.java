import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class Student {
    private String name;
    private double[] marks;

    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double calculateAverage() {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double m : marks) {
            sum += m;
        }
        return sum / marks.length;
    }

    public char determineGrade() {
        double avg = calculateAverage();
        if (avg >= 75.0) {
            // Note: Per problem specification: 'B' for an average of 75 or more
            return 'B';
        } else if (avg >= 60.0) {
            return 'C';
        } else if (avg >= 40.0) {
            // 'D' for an average between 40 and 59 (inclusive)
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printResultCard() {
        double avg = calculateAverage();
        char grade = determineGrade();
        System.out.printf(Locale.US, "%s: Average %.1f, Grade %c\n", name.toUpperCase(), avg, grade);
    }
}

/**
 * Problem 10: Student Result Card Generator
 * Task: Design a system for student result cards. Each student has a name and an
 * array of three marks. Implement a method to calculate the student's average mark.
 * Based on the average, assign a grade using the specified conditions. Print the
 * student's name in capital letters, average mark (one decimal place), and assigned grade.
 */
public class Problem10_StudentResultCardGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            // Sample format: "Asha [80, 90, 70]" or "Asha 80 90 70"
            int bracketStart = line.indexOf('[');
            int bracketEnd = line.indexOf(']');

            if (bracketStart != -1 && bracketEnd != -1) {
                String name = line.substring(0, bracketStart).trim();
                String marksPart = line.substring(bracketStart + 1, bracketEnd);
                String[] marksTokens = marksPart.split("[,\\s]+");
                List<Double> marksList = new ArrayList<>();
                for (String t : marksTokens) {
                    if (!t.trim().isEmpty()) {
                        marksList.add(Double.parseDouble(t.trim()));
                    }
                }
                double[] marks = new double[marksList.size()];
                for (int i = 0; i < marksList.size(); i++) marks[i] = marksList.get(i);
                students.add(new Student(name, marks));
            } else {
                String[] tokens = line.split("\\s+");
                if (tokens.length >= 4) {
                    String name = tokens[0];
                    double[] marks = new double[3];
                    for (int i = 0; i < 3; i++) {
                        marks[i] = Double.parseDouble(tokens[i + 1]);
                    }
                    students.add(new Student(name, marks));
                }
            }
        }

        if (students.isEmpty()) {
            // Default sample demonstration:
            // Asha [80, 90, 70]
            // Ravi [60, 55, 50]
            students.add(new Student("Asha", new double[]{80, 90, 70}));
            students.add(new Student("Ravi", new double[]{60, 55, 50}));
        }

        for (Student s : students) {
            s.printResultCard();
        }

        scanner.close();
    }
}
