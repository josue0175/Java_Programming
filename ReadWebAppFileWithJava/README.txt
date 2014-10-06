How do you read a file "dynamically" from a running server?

http://www.coderanch.com/t/592883/Servlets/java/Reading-properties-file-WEB-INF

http://tshikatshikaaa.blogspot.nl/2012/07/maven-how-to-access-filesdata-in.html

http://fuyun.org/2009/11/how-to-read-input-files-in-maven-junit/

http://stackoverflow.com/questions/861500/url-to-load-resources-from-the-classpath-in-java

http://www.digizol.com/2007/04/open-file-war-web-application-java.html
:w

################
VersionController.java
################
InputStream inStream = RestApiRelease.class.getClassLoader().getResourceAsStream("/apiVersion/" + Global.apiVersionFileName);
//Pass a reference "by value" to the getter method
RestApiRelease.setApiVersionFromXML(inStream);
inStream.close(); //Make sure to close your stream/io!
apiVersion = RestApiRelease.getApiVersion();
###############
build.xml
################
<target name="apiVersion" description="build a version file. ">
        <mkdir dir="${classes.dir}/apiVersion" />
        <taskdef name="xmltask" classname="com.oopsconsultancy.xmltask.ant.XmlTask" classpathref="build.classpath" /> 
        <!-- <xmltask source="src/main/resources/apiBuildVersion.xml" dest="src/main/resources/apiVersion.xml"> -->
        <xmltask source="src/main/resources/${apiVersion.name}.template" dest="${classes.dir}/apiVersion/${apiVersion.name}" >
        <replace path="/ApiVersion[1]/revision/text()" 
            withText="${build.revision.number}" />
        </xmltask> 
    </target>

#In build/WEB-INF/apiVersion/apiVersion.xml
