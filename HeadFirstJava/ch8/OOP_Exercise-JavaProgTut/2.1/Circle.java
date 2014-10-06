public class Circle extends Shape {
    protected double radius;

    public Circle() { radius = 1.0; color="red";}

    public Circle(double radius) { this.radius = radius; color="red";}

    public Circle(double radius, String color, boolean filled) { 
        this.radius = radius; 
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }
        
    public void setRadius(double givenRadius) {
        this.radius = givenRadius;
    }
        
    public double getArea() {
        //return radius*radius*Math.PI
        return 3.14; 

    }
//    public double getPerimeter();
    public String toString() {
        return "Circle: radius=" + radius + " color=" + color + " filled=" + filled;
    }
}
