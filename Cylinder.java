package LTGD;

public class Cylinder implements Shape {
    private Circle r;
    private Points center;
    private double height;

    public Cylinder() {
        this.center = new Points(0, 0);
        this.r = new Circle(0);
        this.height = 0;
    }

    public Cylinder(int x, int y, double radius, double height) {
        this.center = new Points(x, y);
        this.r = new Circle(radius);
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Cylinder [center=" + center + ", radius=" + r.getRadius() + ", height=" + height + "]";
    }

    @Override
    public double area() {
        double radius = r.getRadius();
        return 2 * Math.PI * radius * (radius + height); 
    }

    @Override
    public double volume() {
        double radius = r.getRadius();
        return Math.PI * radius * radius * height;
    }

    @Override
    public String getName() {
        return "Cylinder";
    }
}
