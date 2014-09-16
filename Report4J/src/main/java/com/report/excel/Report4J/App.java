package com.report.excel.Report4J;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			Connection con = newConnection("test", "test");
			Statement stat = con.createStatement();
			stat.execute("select * from user_objects");
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
    
    public static Connection newConnection(String user,String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    	Connection con = null; 
    	try { 
    	Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); 
    	con = DriverManager.getConnection ("jdbc:oracle:thin:@112.65.50.29:1521:orcl",user,password); 
    	} 
    	catch (SQLException e) { 
    	return null; 
    	} 
    	return con; 
    }
}
