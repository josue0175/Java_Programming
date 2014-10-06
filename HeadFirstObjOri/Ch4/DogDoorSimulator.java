import java.util.*;

public class DogDoorSimulator {
    public static void main(String [] args){
        DogDoor door = new DogDoor();
        BarkRecognizer recognizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);
        System.out.println("Fido starts Barking");
        recognizer.recognize("Woof");

        //remote.pressButton();

        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done...");

        try {
            Thread.currentThread().sleep(10000);
        }catch (InterruptedException e) { } //What does this catch? an event from the current Thread or is this just a timer exception?
        System.out.println("...but he's stuck outside...");
        System.out.println("\nFido starts barking...");
        recognizer.recognize("Woof");
        //System.out.println("...so Gina grabs the remote control...");
        //remote.pressButton();
    }
}
