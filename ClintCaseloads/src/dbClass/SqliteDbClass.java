package dbClass;
import java.sql.*;

public class SqliteDbClass {
	
	private static final String USERNAME="dbuser";
	private static final String PASSWORD="dbpassword";
	private static final String CONN= "jdbc:mysql://localhost//login";
	private static final String SQCONN="jdbc:sqlite://Users//khalilfrough//Desktop//JavaFx//login.db";

	public static Connection getConnection()throws SQLException {
		
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(SQCONN);
			
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return null; 
	}
	
}
