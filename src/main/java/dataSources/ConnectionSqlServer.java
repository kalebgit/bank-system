package dataSources;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import util.BankSystem;

public interface ConnectionSqlServer {
	
	default Connection getConnection() {
		Properties databaseInfo;
		Connection conn = null;
		try {
			databaseInfo = BankSystem.getPropertiesFrom("database.properties");
			String url = "jdbc:sqlserver://" + databaseInfo.getProperty("hostname") + ":1433" + 
					";instance" + databaseInfo.getProperty("sqlInstanceName") + ";DatabaseName=" + 
					databaseInfo.getProperty("sqlDatabase") + ";encrypt=true;trustServerCertificate=true";
			
			conn = DriverManager.getConnection(url, databaseInfo.getProperty("sqlUser"), 
					databaseInfo.getProperty("sqlPassword"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
