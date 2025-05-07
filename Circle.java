package LTGD;

public class Circle implements Shape {
    double r;

    public Circle() {
        this.r=0;
    }

    public Circle(double r ) {
        this.r=r;
    }

    public void setRadius() {
        System.out.println(r);
    }

    public double getRadius() {
        return r;
    }


    @Override
    public String toString() {
        return "(" + r +  ")";
    }

    @Override
    public double area() {
        return (int) (Math.PI * r * r);
    }


    @Override
    public double volume() {
        return 0;
    }

    @Override
    public String getName() {
        return "Circle";
    }
    
}
