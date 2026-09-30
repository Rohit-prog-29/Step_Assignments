class Character {
    private final int maximumHealth;
    private int health;

    Character(int maximumHealth) {
        if (maximumHealth <= 0) {
            throw new IllegalArgumentException("Maximum health must be positive.");
        }
        this.maximumHealth = maximumHealth;
        this.health = maximumHealth;
    }

    void takeDamage(int amount) {
        if (amount > 0) {
            health = Math.max(0, health - amount);
        }
    }

    void heal(int amount) {
        if (amount > 0) {
            health = (int) Math.min(maximumHealth, (long) health + amount);
        }
    }

    int getHealth() {
        return health;
    }
}

public class Problem1_HealthBar {
    public static void main(String[] args) {
        Character character = new Character(100);
        character.takeDamage(30);
        System.out.println("Health after damage: " + character.getHealth());
        character.heal(50);
        System.out.println("Health after healing: " + character.getHealth());
        character.takeDamage(150);
        System.out.println("Health after final damage: " + character.getHealth());
    }
}