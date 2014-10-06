//http://www.xml.com/pub/a/2004/08/18/xstream.html
//
//To compile do 
//"javac -classpath /home/jgiles/Documents/workspace-sts-3.1.0.M1/restapi/src/webroot/WEB-INF/lib/xstream-1.4.2.jar SerializingXML.java 
//java -cp .:xstream-1.4.2.jar SerializingXML 

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class SerializingXML {
    public static void main(String[] args){
        XStream xstream = new XStream(new StaxDriver());
        String salutation = "Hello, World!";
        String xml = xstream.toXML(salutation);
        System.out.print(xml);
    }
}
