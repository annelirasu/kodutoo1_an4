package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author anneli klass kiirendab andmebaasiühenduse loomist
 */
public class ConnFactory {

	String driverClassName = "org.hsqldb.jdbcDriver";

	String connectionUrl = "jdbc:hsqldb:${user.home}/i377/Team03d/piirivalveDb;shutdown=true";

	private static Connection connection;

	private static ConnFactory ConnFactory = null;

	private ConnFactory() throws SQLException {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}

		try {

			connection = DriverManager.getConnection(connectionUrl, "sa", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Connection getConnection() {

		return connection;
	}

	public static ConnFactory getInstance() throws SQLException {
		if (ConnFactory == null) {
			ConnFactory = new ConnFactory();
		}
		return ConnFactory;
	}
}
