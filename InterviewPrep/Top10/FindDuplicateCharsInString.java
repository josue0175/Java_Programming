import java.util.*;
public class FindDuplicateCharsInString {

    public static void main(String[] args){
        String s = "abcdeefghajklmzabeee";
        FindDuplicateCharsInString.findDuplicateCharsInString(s);
    }

    private static void findDuplicateCharsInString(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> duplicates = new HashMap<Character, Integer>();

        for(int i = 0; i<str.length();i++){
            Character ch = str.charAt(i);
            Integer freq = (Integer) map.get(ch);

            if(freq == null){
                map.put(ch,1);
            }else{
               map.put(ch, freq+1);
               duplicates.put(ch, freq+1);
            }
        }

        for(Map.Entry<Character, Integer> entry : duplicates.entrySet()) {
            System.out.println(entry.getKey() + " " +entry.getValue());
        }
    } 
}

            
