
import java.util.*;
import java.io.*;
import java.net.*;

public class Spellchecker
{
    
        public static void main(String[] args) throws IOException
                {
                   
                Scanner user_input = new Scanner(System.in);
                boolean isSpellCorr = true;
                System.out.println("Enter 'false' if you want to see correctly spelled words otherwise 'true'"); 
                while(user_input.hasNext()) {
                    
                    if (user_input.hasNextBoolean()) {
                       isSpellCorr = user_input.nextBoolean();
                       System.out.println("Boolean chosen: " + isSpellCorr);
    
                       break;
                    }
                    else {
                       System.out.println("Enter 'true' if you want to see correctly spelled words"); 
                        user_input = new Scanner(System.in);
                    }
                }
                URL url = new URL("http://andrew.cmu.edu/course/15-121/dictionary.txt");
                Scanner sc = new Scanner( url.openStream() );

                HashSet<String> dict = new HashSet<String>();

                while (sc.hasNext()) dict.add(sc.next());
                sc.close();

                sc = new Scanner( new File("Words.txt") );

                while (sc.hasNextLine()) {
                    
                    String[] tokens = sc.nextLine().split("\\W");
                    for (String token : tokens) {
                       System.out.println(token); 
                       if(token.length() > 1 && !dict.contains(token.toLowerCase()) && !isSpellCorr) {
                            System.out.println(token + " is incorrectly spelled");
                       }
                       else if(token.length() > 1 && dict.contains(token.toLowerCase()) && isSpellCorr) {
                            System.out.println(token + " is correctly spelled");
                       }
                       // if(token.length() > 1 && !dict.contains(token.toLowerCase()) && isSpellCorr)
                       /* } else if (){
                            System.out.println(token + " not correctly spelled");
                            
                       } */

                    }
                }

}
    
}
