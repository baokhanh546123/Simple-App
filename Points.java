package LTGD;

public class Points implements Shape {
    int x, y;

    public Points() {
        this.x = 0;
        this.y = 0;
    }

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPoint() {
        System.out.println("(" + x + "; " + y + ")");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double volume() {
        return 0;
    }

    @Override
    public String getName() {
        return "Point";
    }
}
