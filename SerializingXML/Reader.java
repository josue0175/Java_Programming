import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.XStream;

public class Reader {

    public static void main(String[] args) {
        //XStream xs = new XStream(new DomDriver());
        XStream xs = new XStream(new StaxDriver());
        Employee e = new Employee();

        try {
            FileInputStream fis = new FileInputStream("/tmp/employeedata.txt");
            xs.fromXML(fis, e);

            //print the data from the object that has been read
            System.out.println(e.toString());
            
           } catch (FileNotFoundException ex) {
                ex.printStackTrace();
           }
           
          }
}
