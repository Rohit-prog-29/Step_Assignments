class CollegeStudent {
    String name;
    double attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount;

    CollegeStudent(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class Problem5_StudentCollegeInformationManagement {
    public static void main(String[] args) {
        new CollegeStudent("Ravi", 88.5);
        new CollegeStudent("Anitha", 92.0);
        CollegeStudent.printCollegeInfo();
    }
}
