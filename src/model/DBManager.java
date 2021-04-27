package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	Connection connection = null;

	public DBManager() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		// JDBC driver name and database URL
		final String DB_URL_with_SSL = "jdbc:mysql://localhost/asrcinema?useSSL=false & useJDBCCompliantTimezoneShift = true & useLegacyDatetimeCode = false & serverTimezone = UTC & allowPublicKeyRetrieval=true";

		// Database credentials
		final String USER = "root";
		final String PASS = "salvatore1997";
		connection = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS);
	}

	public Connection getConn() {
		return connection;
	}

	public static void shutdown() {
		try {
			DriverManager.getConnection("jdbc:mysql://localhost/asrcinema:;shutdown=true");
		} catch (SQLException ex) {
			throw new RuntimeException(ex.toString(), ex);
		}
	}

}
