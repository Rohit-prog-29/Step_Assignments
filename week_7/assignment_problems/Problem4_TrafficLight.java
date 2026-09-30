class TrafficLight {
    private final String lightId;
    private String color;

    TrafficLight(String lightId) {
        if (lightId == null || lightId.trim().isEmpty()) {
            throw new IllegalArgumentException("Light ID cannot be empty.");
        }
        this.lightId = lightId;
        this.color = "RED";
    }

    void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    String getColor() {
        return color;
    }

    String getLightId() {
        return lightId;
    }
}

public class Problem4_TrafficLight {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight("TL-9");
        System.out.println(light.getLightId() + ": " + light.getColor());
        light.next();
        System.out.println("After next: " + light.getColor());
        light.next();
        System.out.println("After next: " + light.getColor());
        light.next();
        System.out.println("After next: " + light.getColor());
    }
}