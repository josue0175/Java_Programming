//Test special characters using the following script
//for i in '(' ')' '-' '=' '_' '+' '[' ']' '\' '{' '}' '|' ';' ':' '"' ',' '.' '/' '<' '>' '?' '`' '~' ' ' '!' '@' '#' '$' '%' '^' '&' '*'; do java ValidateString "${i}"; done

class ValidateString {
    
    public static void main(String[] args) {
        int num = 100;
        String temp = "blah";
        //System.out.print("Check of string " + args[0] + "is " + validateNameIdentifierField(temp, args[0]), num);
        System.out.println("Check of string " + args[0] + " is " + ValidateString.validateNameIdentifierField(temp, args[0], num));
    }


    public static String validateNameIdentifierField(String fieldName, String fieldValue, int size) {

        for (int i = 0; i < fieldValue.length(); i++) {
            char currChar = fieldValue.charAt(i);

            // 0 - 31, 33-44, & 46,47
            if (fieldValue.charAt(i) < '0' && fieldValue.charAt(i) < ' '
                    || currChar > ' ' && fieldValue.charAt(i) < '-' 
                    || currChar < '0' && fieldValue.charAt(i) > '-' 
                    )
                return "Invalid character for field: " + currChar;
             
            // 58 - 64
            if (fieldValue.charAt(i) > '9' && fieldValue.charAt(i) < 'A')
                return "Invalid character for field: " + currChar;
             
            //91-94
            if (fieldValue.charAt(i) > 'Z' && fieldValue.charAt(i) < '_')
                return "Invalid character for field: " + currChar;
             
            //96 & 123 - 127
            if (fieldValue.charAt(i) > 'z' || currChar == '`')
                return "Invalid character for field: " + currChar;
        }
                                                                                                                    return "";
    }

}
