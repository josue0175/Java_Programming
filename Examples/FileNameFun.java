import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileNameFun {

    public static void main(String[] args){
                File name = new File("apiVersion.xml");
                File apiVersionFile = new File(System.getProperty("jboss.server.config.url"), name);
                //FileInputStream FIS = new java.io.FileInputStream(apiVersionFile);
                FileInputStream FIS = new FileInputStream(apiVersionFile);
                //FileInputStream FIS = new FileInputStream("/usr/share/jboss-6.1.0.Final/server/default/conf/apiVersion.xml");
                System.out.println(FIS);
    }
}
