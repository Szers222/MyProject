package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private static Connection conn;
	private static String url  = "jdbc:mysql://localhost:3306/project_db";
	private static String username = "root";
	private static String password ="" ;
	
	public static Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);	
			} catch (Exception e) {
				System.out.println("Lỗi: " + e);
			}
		}
		return conn;
	}
}
