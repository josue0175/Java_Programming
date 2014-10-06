import java.util.*;

public class FindGuitarTester {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

    GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 12);
    List matchingGuitars = inventory.search(whatErinLikes);
    
    if(!matchingGuitars.isEmpty()){
        System.out.println("Erin, you might like these guitars:");
        for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("We have a " +
        spec.getBuilder() + " " + spec.getModel() +  " " +
        spec.getType() + " guitar:\n   " +
        spec.getBackWood() + " back and sides,\n   " +
        spec.getTopWood() + " top.\nYou can have it for only $" +
        guitar.getPrice() + "!");
        }   

    }else{
        System.out.println("Sorry, Erin, we have nothing for you.");
    }
   }
    
    private static void initializeInventory(Inventory inventory){
         GuitarSpec Fender1 = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6);
         GuitarSpec Fender2 = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 12);
         GuitarSpec Gibson1 = new GuitarSpec(Builder.GIBSON, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6);
         inventory.addGuitar("V95693", 1499.95, Fender1);
         inventory.addGuitar("V95693", 1599.95, Fender2);
         inventory.addGuitar("V95693", 1699.95, Gibson1);
    }
}
