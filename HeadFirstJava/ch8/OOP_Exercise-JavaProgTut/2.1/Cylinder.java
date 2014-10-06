public class Cylinder extends Circle {
      private double height;  // private vc Cylinder() {
   
      public Cylinder() {
        super();        // call superclass no-arg constructor Circle()
        height = 1.0; 
      }

      public Cylinder(double height) {
        super();
        this.height = height;
      }

      public Cylinder(double radius, double height) {
        super(radius);  // call superclass constructor Circle(r)
        this.height = height;
      }
      public double getHeight() {
        
        return height; 
       }
      //Overriding getArea requires getVolume to specify the parent (superclass)
      public double getVolume() {
        return super.getArea()*height; 
      }

      //overriding Circle class getArea
      public double getArea() {
        return 2*Math.PI*radius*radius;
      }

      @Override
       public String toString() {
                  // in Cylinder class
         return "Cylinder: subclass of " + super.toString() + " height=" + height;
       }
      
}
