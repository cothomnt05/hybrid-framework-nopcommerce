package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerJTDSConnUtils {
	public static Connection getSQLServerConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "automationtest";
		String userName = "sa";
		String password = "automationfc";

		return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
	}

	public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
		Connection conn = null;

		try {
			// Khai bao class Driver cho SQL Server
			// Viec nay can thiet voi Java 5
			// Java 6 tu dong tim kiem Driver thich hop - ko bat buoc can dong nay
			Class.forName("net.sourceforge.jtds.jdbc.Driver");

			// Cau truc URL Connection danh cho SQL Server
			// Vi du
			// jdbc:jtds:sqlserver://localhost:1433/automationfc;instance=SQLEXPRESS
			String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + database + ";instance=" + sqlInstanceName;

			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
