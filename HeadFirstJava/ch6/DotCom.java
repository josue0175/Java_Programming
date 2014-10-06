import java.util.*;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }
    
    public void setName(String dotComName) {
        this.name = dotComName;
    }

    public String getName() {
        return name;
    }

    public String checkYourself(String userInput) {
      String result = "miss";
      int index = locationCells.indexOf(userInput); //indexOf() returns arraylocation or -1
      if (index >= 0) {
        locationCells.remove(index);
        if (locationCells.isEmpty()) {
            result = "kill";
            System.out.println("Ouch.  You sunk " + name + " : )");
        }else{
            result = "hit";
        }
      }
      return result;
    }
}
