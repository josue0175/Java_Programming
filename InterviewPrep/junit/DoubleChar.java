public class DoubleChar {

    public String doubleChar(String str){
        String s = "";

        for(int i = 0; i < str.length();i++) {
            s +=  str.substring(i,i+1) + str.substring(i,i+1);
        }
        return s;
    }
}
