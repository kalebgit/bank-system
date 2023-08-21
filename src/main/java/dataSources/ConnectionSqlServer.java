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
			conn = DriverManager.getConnection(databaseInfo.getProperty("sqlUrl"), databaseInfo.getProperty("sqlUser"), 
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
