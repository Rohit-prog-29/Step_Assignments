import java.util.Scanner;

abstract class Plot {
    protected String owner;
    protected String shape;

    public Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }

    public String getOwner() {
        return owner;
    }

    public String getShape() {
        return shape;
    }

    public abstract double calculateArea();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Problem1_GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalArea = 0.0;

        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();
            Plot plot = null;

            if (shape.equalsIgnoreCase("CIRCLE")) {
                double r = scanner.nextDouble();
                plot = new CirclePlot(owner, r);
            } else if (shape.equalsIgnoreCase("RECTANGLE")) {
                double l = scanner.nextDouble();
                double w = scanner.nextDouble();
                plot = new RectanglePlot(owner, l, w);
            } else if (shape.equalsIgnoreCase("TRIANGLE")) {
                double b = scanner.nextDouble();
                double h = scanner.nextDouble();
                plot = new TrianglePlot(owner, b, h);
            }

            if (plot != null) {
                double area = plot.calculateArea();
                System.out.printf("%s (%s): %.2f\n", plot.getOwner(), plot.getShape(), area);
                totalArea += area;
            }
        }

        System.out.printf("Total Area: %.2f\n", totalArea);
        scanner.close();
    }
}
