public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("The circle has radius of " 
                         + c1.getRadius() + " and area of " + c1.getArea());
        Circle c2 = new Circle(2.0);
         System.out.println("The circle has radius of " + c2.getRadius() + " and area of " + c2.getArea());
        
        Circle c3 = new Circle(3.0,"blue");
         System.out.println("The circle has radius of " + c3.getRadius() + " and area of " + c3.getArea() + 
                 "and color " + c3.getColor());

        Circle c4 = new Circle();
        c4.setColor("purple"); 
        c4.setRadius(100);

         System.out.println("The circle has radius of " + c4.getRadius() + " and area of " + c4.getArea() + 
                 "and color " + c4.getColor());

    System.out.println(c4.toString());
    System.out.println(c4);
    }
}
