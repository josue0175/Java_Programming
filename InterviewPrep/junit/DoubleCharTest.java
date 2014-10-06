import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleCharTest {

        @Test
        public void testDoubleChar() {
            DoubleChar dchar = new DoubleChar();

            String result = dchar.doubleChar("one");
            System.out.println("dchar" + dchar);
            System.out.println("result " + result);

            assertEquals("oonnee", result);

    }
}
