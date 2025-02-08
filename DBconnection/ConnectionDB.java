package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	public static Connection getConnection() throws SQLException {
	   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankweb","root","root");
	   return conn;
	}

}
