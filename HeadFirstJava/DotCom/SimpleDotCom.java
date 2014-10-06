import java.util.ArrayList;

public class SimpleDotCom {
    private ArrayList<String> locationCells;
    int numOfHits = 0;
    
//    public void setLocationCells(int[] locs) {
    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public String checkYourself(String stringGuess) {
      //Get the user guess & Convert to int
      
      String result = "miss";

      int index = locationCells.indexOf(stringGuess);

      if (index >= 0) {
        locationCells.remove(index);

        if (locationCells.isEmpty()) {
            result = "kill";
        } else {
            result = "hit";
        }
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
