import java.util.ArrayList;

public class SimpleDotComGame {

    public static void main(String[] args) {

        int numOfGuesses = 0;
        Integer inputSimulateNumber = 0;
        SimpleDotCom simpleDotCom = new SimpleDotCom();
        GameHelper helper = new GameHelper();
        int randomInt = (int) (Math.random() * 5);
        Integer i = new Integer(randomInt);
        ArrayList<String> locations = new ArrayList<String>();
        locations.add(i.toString());
        i++;
        locations.add(i.toString());
        i++;
        locations.add(i.toString());
        i++;
    
        simpleDotCom.setLocationCells(locations);
        boolean isAlive = true;
    
        while(isAlive == true) {
            //inputSimulateNumber = (int) (Math.random() * 5);
            //System.out.println("guess = " + inputSimulateNumber.toString());
            //String result = simpleDotCom.checkYourself(inputSimulateNumber.toString());
            String guess = helper.getUserInput("enter a number");
            String result = simpleDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("Number of Guesses = " + numOfGuesses);
            }
        }
    }
}
