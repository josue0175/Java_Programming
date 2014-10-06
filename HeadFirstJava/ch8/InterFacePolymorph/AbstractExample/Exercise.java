public class Exercise {
    public static void main(String[] args) {
        PointAndShoot camera = new PointAndShoot();


        //camera.create();
        //or directly access the public/private members of the class like so...
        camera.make = "Olympus";
        camera.model = "FE-170";
        camera.megapixels = 6.0;
        camera.price = 119.95;

        camera.describe();
    
    }
}
