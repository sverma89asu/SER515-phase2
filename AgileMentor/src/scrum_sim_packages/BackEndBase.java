package scrum_sim_packages;
import java.io.*;
import java.sql.*;
import java.util.*;

public class BackEndBase {
	String url = "jdbc:mysql:http://sql10.freemysqlhosting.net";
	String dbName = "sql10655066";

	String driver = "com.mysql.jdbc.Driver";
	String userName = "sql10655066"; 
	String password = "WZ1I9Hcbql";  

	Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(url, userName, password);
        System.out.println("Connection Established successfully");
        Statement st = con.createStatement();

}
