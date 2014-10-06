package com.coderevisited.spring.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ReST Endpoint for the Platform Get and Verify Cache Service.
 *
 * @author nickls1 : Shawn-Ryan Nicklin
 */
@Controller
public class HealthCheckController {

	//@RequestMapping(method= RequestMethod.GET, produces = "application/json", headers="Accept=*/*")
    @RequestMapping(value = "system/healthCheck", method = RequestMethod.GET)
    public @ResponseBody HealthCheckResult healthCheck() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
    	// this should leverage dependency injection

    	/*For demo/test purposes outside the VMAX env*/
    	    	demoDerbyDB();
    	    	MockHealthCheckService service = new MockHealthCheckService();
    	    	return service.beginHealthCheck();
    	
    	//return new HealthCheckService().beginHealthCheck();
    }

	private void demoDerbyDB() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

    	Properties props = new Properties(); // connection properties
    	// providing a user name and password is optional in the embedded
    	// and derbyclient frameworks
    	props.put("user", "user1");
    	props.put("password", "passwd1");
    	Connection connect = DriverManager
    			
    			.getConnection("jdbc:derby:SpringMVC;create=true", props);

    	connect.setAutoCommit(false);
    	Statement s = connect.createStatement();
    	ArrayList statements = new ArrayList(); // list of Statements, PreparedStatements
    	statements.add(s);

    	s.execute("create table ticket(procid int, procname varchar(40))");
    	System.out.println("Created table ticket");

    	PreparedStatement psInsert = null;
    	PreparedStatement psUpdate = null;
    	psInsert = connect.prepareStatement(
    			"insert into ticket values (?, ?)");
    	statements.add(psInsert);

    	psInsert.setInt(1, 1956);
    	psInsert.setString(2, "NightmareProc");
    	psInsert.executeUpdate();
    	System.out.println("Inserted");

    	psInsert.setInt(1, 1910);
    	psInsert.setString(2, "ZombieProc");
    	psInsert.executeUpdate();
    	System.out.println("Inserted");

    	// parameter 1 and 3 are procid (int), parameter 2 is procname (varchar)
    	psUpdate = connect.prepareStatement(
    			"update ticket set procid=?, procname=? where procid=?");
    	statements.add(psUpdate);

    	psUpdate.setInt(1, 1800);
    	psUpdate.setString(2, "QUESOProc");
    	psUpdate.setInt(3, 1956);
    	psUpdate.executeUpdate();
    	System.out.println("Updated");

    	psUpdate.setInt(1, 3000);
    	psUpdate.setString(2, "SuperProc");
    	psUpdate.setInt(3, 1800);
    	psUpdate.executeUpdate();
    	System.out.println("Updated");


    	/*
               We select the rows and verify the results.
    	 */
    	ResultSet rs = null;
    	rs = s.executeQuery(
    			"SELECT procid, procname FROM ticket ORDER BY procid");


    	Integer procid; // street procid retrieved from the database
    	boolean failure = false;
    	if (!rs.next())
    	{
    		failure = true;
    		System.out.println("No rows in ResultSet");
    	}

    	if ((procid = rs.getInt(1)) != 1910)
    	{
    		failure = true;
    		System.out.println(
    				"Wrong row returned, expected procid=1910, got " + procid);
    	}

    	if (!rs.next())
    	{
    		failure = true;
    		System.out.println("Too few rows");
    	}

    	if ((procid = rs.getInt(1)) != 3000)
    	{
    		failure = true;
    		System.out.println(
    				"Wrong row returned, expected procid=3000, got " + procid);
    	}

    	if (rs.next())
    	{
    		failure = true;
    		System.out.println("Too many rows");
    	}
    	if (!failure) {
    		System.out.println("Verified the rows");
    	}

    	// delete the table
    	s.execute("drop table ticket");
    	System.out.println("Dropped table ticket");

    	/*
               We commit the transaction. Any changes will be persisted to
               the database now.
    	 */
    	connect.commit();
    	System.out.println("Committed the transaction");
	}

}
