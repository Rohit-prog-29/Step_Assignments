import java.util.Scanner;

interface BusServiceable {
    double getTransportFee();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getTuitionFee();

    public double getHostelFee() {
        return 0.0;
    }

    public double calculateTotalFee() {
        double fee = getTuitionFee() + getHostelFee();
        if (this instanceof BusServiceable) {
            fee += ((BusServiceable) this).getTransportFee();
        }
        return fee;
    }
}

class DayScholarStudent extends Student implements BusServiceable {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 40000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 40000.0;
    }

    @Override
    public double getHostelFee() {
        return 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusServiceable {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 20000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

public class Problem3_CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            Student student = null;

            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                student = new DayScholarStudent(name);
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                student = new HostellerStudent(name);
            } else if (type.equalsIgnoreCase("SCHOLAR")) {
                student = new ScholarshipStudent(name);
            }

            if (student != null) {
                double fee = student.calculateTotalFee();
                System.out.printf("%s: %.2f\n", student.getName(), fee);
                grandTotal += fee;
            }
        }

        System.out.printf("Total Collected: %.2f\n", grandTotal);
        scanner.close();
    }
}
