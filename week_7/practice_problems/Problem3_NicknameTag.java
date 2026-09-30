class NameTag {
    private final String firstName;
    private final char lastInitial;

    NameTag(String fullName) {
        if (fullName == null) {
            throw new IllegalArgumentException("Full name cannot be null.");
        }
        String[] nameParts = fullName.trim().split("\\s+");
        if (nameParts.length != 2) {
            throw new IllegalArgumentException("Provide one first name and one last name.");
        }
        firstName = nameParts[0];
        lastInitial = nameParts[1].charAt(0);
    }

    String getNickname() {
        return firstName + " " + lastInitial + ".";
    }
}

public class Problem3_NicknameTag {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname());
    }
}