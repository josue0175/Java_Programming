import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

class Date {
    int year;
    int month;
    int day;
}

public class SerializingXML2 {
    public static void main(String[] args) {

        XStream xstream = new XStream(new StaxDriver());

        xstream.alias("date", Date.class);

        String decl = "\n";

        Date newdate = (Date)xstream.fromXML(xml);

        String xml = xstream.toXML(date);

        System.out.print(decl + xml);

        
    }
}
