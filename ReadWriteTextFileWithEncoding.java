//package com.emc.sms.api.test.facades;
//More at VolumeProvisionTest in Facade

import java.io.*;
import java.util.Scanner;

public class ReadWriteTextFileWithEncoding {

/** 
 Read and write a file using an explicit encoding.
 Removing the encoding from this code will simply cause the 
 system's default encoding to be used instead.  
*/

  
  /** Constructor. */
  ReadWriteTextFileWithEncoding(String aFileName, String aEncoding){
    fEncoding = aEncoding;
    fFileName = aFileName;
  }
  
  /** Write fixed content to the given file. */
  void write() throws IOException  {
    log("Writing to file named " + fFileName + ". Encoding: " + fEncoding);
    String output = String.format("Boku wa Moku yobi", System.getProperty("line.separator"));
    //Writer out = new OutputStreamWriter(new FileOutputStream(fFileName), fEncoding);
    BufferedWriter out = 
        new BufferedWriter (new OutputStreamWriter(new FileOutputStream(fFileName), fEncoding));
    try {
      out.write(FIXED_TEXT);
      out.newLine();
      out.write(FIXED_TEXT2);
    }
    finally {
      out.close();
    }
  }
  
  /** Read the contents of the given file. */
  void read() throws IOException {
    log("Reading from file.");
    StringBuilder text = new StringBuilder();
    String NL = System.getProperty("line.separator");
    Scanner scanner = new Scanner(new FileInputStream(fFileName), fEncoding);
    try {
      while (scanner.hasNextLine()){
        String[] tokens = scanner.nextLine().split(" ");
        System.out.println("Word found: " + tokens[0]);
        System.out.println("Word found: " + tokens[1]);
        //text.append(scanner.nextLine() + NL);
      }
    }
    finally{
      scanner.close();
    }
    log("Text read in: " + text);
  }
  
  // PRIVATE 
  private final String fFileName;
  private final String fEncoding;
  private final String FIXED_TEXT = "But soft! what code in yonder program breaks?";
  private final String FIXED_TEXT2 = "Boku no neko wa";
  
  private void log(String aMessage){
    System.out.println(aMessage);
  }

  /** Requires two arguments - the file name, and the encoding to use.  */
  public static void main(String... aArgs) throws IOException {
    //String fileName = aArgs[0];
    //String encoding = aArgs[1];
    String fileName = "/tmp/blah.txt";
    String encoding = "UTF-8";
    ReadWriteTextFileWithEncoding test = new ReadWriteTextFileWithEncoding(
      fileName, encoding
    );
    test.write();
    test.read();
  }
}
