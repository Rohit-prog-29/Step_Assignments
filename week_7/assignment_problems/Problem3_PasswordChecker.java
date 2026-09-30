class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }
        this.password = password;
    }

    String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        }
        if (password.length() < 10) {
            return "Medium";
        }
        return "Strong";
    }
}

public class Problem3_PasswordChecker {
    public static void main(String[] args) {
        PasswordChecker shortPassword = new PasswordChecker("abcd");
        PasswordChecker mediumPassword = new PasswordChecker("abc12345");
        PasswordChecker longPassword = new PasswordChecker("abcdefghij12");

        System.out.println("abcd: " + shortPassword.getStrength());
        System.out.println("abc12345: " + mediumPassword.getStrength());
        System.out.println("abcdefghij12: " + longPassword.getStrength());
    }
}