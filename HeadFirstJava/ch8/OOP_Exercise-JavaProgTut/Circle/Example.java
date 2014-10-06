public class Example {
    
    public static void main(String[] args) {
        Shape s1 = new Circle(5.0, "blue", true); 
        System.out.println(s1);
        System.out.println(s1.getArea());

        Circle c1 = (Circle)s1;
        System.out.println(c1);
        System.out.println(c1.getArea());

    }
}
