public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(3, 0);
        MyPoint p2 = new MyPoint(0, 4);

        System.out.println(p1.distance(p2));
        System.out.println(p1.distance(0, 4));
        System.out.println(p1.distance(5, 6));

        //ArrayList<MyPoint> myPoints = new ArrayList<MyPoint>();
        MyPoint[] points = new MyPoint[10];
        for (int i=0;i<10;i++) {
            points[i] = new MyPoint(i, i);
            System.out.println(points[i].toString());
        }
    }
}
