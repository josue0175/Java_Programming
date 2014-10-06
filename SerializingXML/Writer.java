import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Writer {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setName("Jack");
        e.setDesignation("Manager");
        e.setDepartment("Finance");

        //Serialize the object
        XStream xs = new XStream(new StaxDriver());
         try {
            FileOutputStream fs = new FileOutputStream("/tmp/employeedata.txt");
            xs.toXML(e, fs);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}

