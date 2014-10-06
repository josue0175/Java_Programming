import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

class Date {
    int year;
    int month;
    int day;
}

public class SerializingXML2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        XStream xstream = new XStream(new StaxDriver());
        File xmlFile = new File("date.xml");
        Writer writer = null;
        Date date = new Date();

        date.year = 2004;
        date.month = 8;
        date.day = 15;

        xstream.alias("date", Date.class);

        String decl = "\n";

        String xml = xstream.toXML(date);

        System.out.print(decl + xml);

    try {
           
        writer = new FileWriter(xmlFile);
        writer.write(xstream.toXML(date));
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
  Date newdate = (Date)xstream.fromXML(xml);
  newdate.month = 12;
  newdate.day = 25;
  
  String newxml = xstream.toXML(newdate);
   
  System.out.print("\n\n" + newxml);
  writer.close();
  
  Date fromXML = (Date)xstream.fromXML(new FileInputStream(xmlFile));
  
  System.out.println(fromXML);
   
    }
}
