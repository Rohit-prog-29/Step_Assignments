class CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount;

    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class Problem5_EmployeeCompanyInformationManagement {
    public static void main(String[] args) {
        new CompanyEmployee("Asha", 50000);
        new CompanyEmployee("Bharat", 55000);
        new CompanyEmployee("Charan", 60000);
        CompanyEmployee.printCompanyInfo();
    }
}
