import java.math.*;

public class BigDecimalCompare {
    public static void main(String[] args) {
        BigDecimal bg = new BigDecimal("12345678");
        Long l = new Long("12345678");
        BigDecimal simlong = new BigDecimal(l);
        
        System.out.println("bg = " + bg);
        System.out.println("simlong = " + simlong);
        System.out.println("l = " + l.longValue());

//        if (bg.compareTo(new BigDecimal(l)) == 0 ) {
        if (bg.equals(simlong)) {
            System.out.println(" Equivalent using compareTo()");
        }

        if (bg == BigDecimal.valueOf(l)) {
            System.out.println(" Equivalent using valueOf()");
        }
    }
} 

