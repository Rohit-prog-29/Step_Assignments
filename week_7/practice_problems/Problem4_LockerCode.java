class Locker {
    private final int lockerNumber;
    private String combinationCode;

    Locker(int lockerNumber, String combinationCode) {
        if (combinationCode == null || combinationCode.isEmpty()) {
            throw new IllegalArgumentException("Combination code cannot be empty.");
        }
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    boolean changeCode(String currentCode, String newCode) {
        if (currentCode == null || !combinationCode.equals(currentCode)
                || newCode == null || newCode.isEmpty()) {
            return false;
        }
        combinationCode = newCode;
        return true;
    }

    int getLockerNumber() {
        return lockerNumber;
    }
}

public class Problem4_LockerCode {
    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        System.out.println("Correct code accepted: " + locker.changeCode("1234", "5678"));
        System.out.println("Wrong code accepted: " + locker.changeCode("0000", "9999"));
        System.out.println("Locker number: " + locker.getLockerNumber());
    }
}