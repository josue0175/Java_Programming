abstract class DigitalCamera {
    String make;
    String model;
    double megapixels;
    double price;
    
   /* void describe() {
        System.out.println("Digital Camera");
        System.out.printf("Make:        %s\n", make);
        System.out.printf("Model:       %s\n", model);
        System.out.printf("Megapixels:  %.2f\n", megapixels);
        System.out.printf("Price:       %.2f\n", price);

    }
    */
    abstract void describe();
}
