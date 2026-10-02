import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class HostelRoom {
    protected int units;

    public HostelRoom(int units) {
        this.units = units;
    }

    public abstract String getRoomType();
    public abstract double calculateBill();
}

class SingleRoom extends HostelRoom {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends HostelRoom {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }

    @Override
    public double calculateBill() {
        if (occupants <= 0) return 0.0;
        return (units * 6.0) / occupants;
    }
}

class AcRoom extends HostelRoom {
    public AcRoom(int units) {
        super(units);
    }

    @Override
    public String getRoomType() {
        return "AC";
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class Problem3_HostelElectricityBill {

    public static void processRooms(List<HostelRoom> rooms) {
        double total = 0.0;
        for (HostelRoom room : rooms) {
            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", room.getRoomType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        List<HostelRoom> rooms = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                int units = scanner.nextInt();
                if (type.equalsIgnoreCase("SHARED")) {
                    int occupants = scanner.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                } else if (type.equalsIgnoreCase("SINGLE")) {
                    rooms.add(new SingleRoom(units));
                } else if (type.equalsIgnoreCase("AC")) {
                    rooms.add(new AcRoom(units));
                }
            }
            processRooms(rooms);
        } else {
            // Sample test case
            rooms.add(new SingleRoom(120));
            rooms.add(new SharedRoom(150, 3));
            rooms.add(new AcRoom(100));
            processRooms(rooms);
        }
        scanner.close();
    }
}
