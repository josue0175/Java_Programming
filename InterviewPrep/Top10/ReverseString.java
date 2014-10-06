public class ReverseString {
    public static void main(String[] args){
          //original string
          String str = "Sony is going to introduce Internet TV soon";
          System.out.println("Original String: " + str);

          //iterative method to reverse String in Java
          String reverseStr = reverse(str);
          System.out.println("Reverse String in Java using Iteration: " +
          reverseStr);

    }

     public static String reverse(String str) {
             StringBuilder strBuilder = new StringBuilder();
                     char[] strChars = str.toCharArray();

                             for (int i = strChars.length - 1; i >= 0; i--) {
                                         strBuilder.append(strChars[i]);
                                                 }

                                                         return
                                                         strBuilder.toString();
}
}
