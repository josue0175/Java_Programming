import java.util.*;

public class DotComBust {
        private GameHelper helper = new GameHelper();
        private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
        private int numOfGuesses = 0;

        private void setUpGame() {
            DotCom one = new DotCom();
            one.setName("Pets.com");
            DotCom two = new DotCom();
            two.setName("eToys.com");
            DotCom three = new DotCom();
            three.setName("Go2.com");
            dotComsList.add(one);
            dotComsList.add(two);
            dotComsList.add(three);

            System.out.println("You goal is to sink three dot coms.");
            System.out.println("Pets.com, eToys.com, Go2.com");
            System.out.println("Try to sink them all in the fewest number of guesses");

            for (DotCom dotComToSet : dotComsList) {
                ArrayList<String> newLocation = helper.placeDotCom(3);
                System.out.println("Location Cells for " + dotComToSet.getName() + " is " + newLocation);
                dotComToSet.setLocationCells(newLocation);
            }
        }

        private void startPlaying(){
            while(!dotComsList.isEmpty()) {
               String userGuess = helper.getUserInput("Enter a Guess"); 
               checkUserGuess(userGuess);
            }
        finishGame();
        }

        private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        
        for (DotCom dotComToTest : dotComsList)
        {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit"))
            {
                break;
            }
            if (result.equals("kill"))
            {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

        private void finishGame() {
            System.out.println("All the dotComs are now dead.");
            if (numOfGuesses < 18) {
                System.out.println("It only took you " + numOfGuesses + " guesses.");
            } else {
                System.out.println("Boy, you sure took long enough; " + numOfGuesses + " guesses.");
                
            }
        }


        public static void main(String[] args) {
            DotComBust game = new DotComBust();
            game.setUpGame();
            game.startPlaying();
        }
}
