public class Circle implements GeometricObject {
    protected double radius = 1.0;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getPerimeter() {
        return radius;
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }
}
