class PointAndShoot extends DigitalCamera{

    void create() {
        make = "Canon";
        model = "Powershot A590 IS";
        megapixels = 8.0;
        price = 129.95;
    }

    void describe() {
        
        System.out.println("Digital Camera");
        System.out.printf("Make:      %s\n", make);
        System.out.printf("Megapixels:      %.2f\n", megapixels);
        System.out.printf("Price:      %.2f\n", price);
    }


}
