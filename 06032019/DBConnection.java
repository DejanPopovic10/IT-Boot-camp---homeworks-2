package rs.itbootcamp.gen4.nedelja6.agencija1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private final static String dburl = "jdbc:sqlite:skijaliste.db";
	private static Connection conn;
	
	// sakrivamo konstruktor kako se nikada ne bi napravio objekat te klase, vec cela interakcija ide kroz staticke metode
	private DBConnection() { }
	
	public static Connection getConnection() throws SQLException {
		if(conn==null || conn.isClosed())
			conn = DriverManager.getConnection(dburl);
		return conn;
	}
	
	public static void close() throws SQLException {
		if(conn!=null && !conn.isClosed())
			conn.close();
	}
	
	// kad hocemo da program samo 'proguta' gresku	
	public static void closeQuietly() {
		try {
			close();
		} catch (SQLException e) {
			System.err.println("Nemoguce zatvoriti konekciju");
			e.printStackTrace();
		}
	}
}
