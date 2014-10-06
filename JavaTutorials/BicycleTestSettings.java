public class BicycleTestSettings extends Bicycle {


    public BicycleTestSettings() {
        super();
        //bicycleContext.changeGear(11);
    }
    
    public static BicycleTestSettings setMethod() {
        BicycleTestSettings bicycleTestSettings = new BicycleTestSettings();
        bicycleTestSettings.changeGear(110);
        bicycleTestSettings.printStates();
        return bicycleTestSettings;
    }

}

