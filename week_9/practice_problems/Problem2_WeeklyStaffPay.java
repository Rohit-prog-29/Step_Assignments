import java.util.Scanner;

abstract class StaffMember {
    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return 40.0 * rate + (hours - 40.0) * 1.5 * rate;
        }
    }
}

class InternStaff extends StaffMember {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class Problem2_WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalPayroll = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            StaffMember staff = null;

            if (type.equalsIgnoreCase("FULLTIME")) {
                double salary = scanner.nextDouble();
                staff = new FullTimeStaff(name, salary);
            } else if (type.equalsIgnoreCase("HOURLY")) {
                double hours = scanner.nextDouble();
                double rate = scanner.nextDouble();
                staff = new HourlyStaff(name, hours, rate);
            } else if (type.equalsIgnoreCase("INTERN")) {
                double stipend = scanner.nextDouble();
                staff = new InternStaff(name, stipend);
            }

            if (staff != null) {
                double pay = staff.calculatePay();
                System.out.printf("%s: %.2f\n", staff.getName(), pay);
                totalPayroll += pay;
            }
        }

        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        scanner.close();
    }
}
