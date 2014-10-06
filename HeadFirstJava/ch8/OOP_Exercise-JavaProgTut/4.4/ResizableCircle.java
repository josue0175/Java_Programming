public class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    public double resize(int percent) {
        double newPercent = (double)percent/100;
        System.out.println("Percent=" + percent);
        System.out.println("newPercent=" + newPercent);
        System.out.println("super.radius=" + super.radius);
        super.radius = super.radius*newPercent;

        return super.radius;
    }
}
