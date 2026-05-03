package com.te.utility;
import java.sql.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class ConnectionUtility {
	
	public static HikariDataSource ds;
	static {
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/miniProject");
		config.setUsername("root");
		config.setPassword("sql@123");
		
		config.setMaximumPoolSize(10);
		
		ds = new HikariDataSource(config);
	}
	
	public static Connection getConnection() throws SQLException {
		return  ds.getConnection();
	}

}
