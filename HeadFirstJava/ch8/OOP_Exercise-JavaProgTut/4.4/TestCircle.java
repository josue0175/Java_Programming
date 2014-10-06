public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.0);
        System.out.println(c1.getArea());

        ResizableCircle r1 = new ResizableCircle(2.0);
        System.out.println(r1.getArea());

        double resized = r1.resize(50);
        System.out.println("resized=" + resized);
        System.out.println(r1.getArea());
    }
}
