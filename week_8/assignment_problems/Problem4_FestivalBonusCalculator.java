import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class BonusEmployee {
    protected String name;
    protected double monthlySalary;

    public BonusEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends BonusEmployee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends BonusEmployee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends BonusEmployee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0;
    }
}

public class Problem4_FestivalBonusCalculator {

    public static void processEmployees(List<BonusEmployee> employees) {
        double totalBonus = 0.0;
        for (BonusEmployee emp : employees) {
            double bonus = emp.calculateBonus();
            System.out.printf("%s: %.2f%n", emp.getName(), bonus);
            totalBonus += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", totalBonus);
    }

    public static void main(String[] args) {
        List<BonusEmployee> employees = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                String name = scanner.next();
                double salary = scanner.nextDouble();
                switch (type.toUpperCase()) {
                    case "FULLTIME":
                        employees.add(new FullTimeEmployee(name, salary));
                        break;
                    case "PARTTIME":
                        employees.add(new PartTimeEmployee(name, salary));
                        break;
                    case "INTERN":
                        employees.add(new InternEmployee(name, salary));
                        break;
                }
            }
            processEmployees(employees);
        } else {
            // Sample test case
            employees.add(new FullTimeEmployee("Asha", 50000));
            employees.add(new PartTimeEmployee("Ravi", 30000));
            employees.add(new InternEmployee("Neha", 15000));
            processEmployees(employees);
        }
        scanner.close();
    }
}
