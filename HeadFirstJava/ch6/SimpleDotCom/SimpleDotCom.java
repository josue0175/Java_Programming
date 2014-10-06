public class SimpleDotCom {
    int [] locationCells;
    int numOfHits = 0;
    
    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String stringGuess) {
      //Get the user guess & Convert to int
      
      int guess = Integer.parseInt(stringGuess);
      String result = "miss";

      for (int cell : locationCells) {
        //compare userguess to location cell
        //if guess matches
          if (guess == cell) {
            //increment number of hits
            //Find out if it was the last location cell
              result = "hit";
              numOfHits++;
              break;
          }
      }
      if (numOfHits == locationCells.length) {
          result = "kill";
      }

      System.out.println(result);
      return result;
    }

}
            //If number of hits is 3 RETURN "kill"
            //else not a kill RETURN "hit"
            //END if
        //ELSE the user guess did not match so RETURN "miss"
        //END IF
        //END REPEAT
        //END METHOD
