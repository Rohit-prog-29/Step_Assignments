class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    AttendanceSheet(int maximumStudents) {
        if (maximumStudents < 0) {
            throw new IllegalArgumentException("Maximum students cannot be negative.");
        }
        presentStudents = new String[maximumStudents];
    }

    boolean markPresent(String name) {
        if (name == null || name.trim().isEmpty() || isPresent(name)) {
            return false;
        }
        if (presentCount == presentStudents.length) {
            return false;
        }
        presentStudents[presentCount++] = name;
        return true;
    }

    int getPresentCount() {
        return presentCount;
    }

    boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int index = 0; index < presentCount; index++) {
            if (presentStudents[index].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class Problem5_AttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}