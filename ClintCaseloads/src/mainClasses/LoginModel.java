package mainClasses;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import dbClass.SqliteDbClass;

/* this class is the main class which get the connection from the database
it also read the database data for the login page and passes it to the login Controller 
class */
public class LoginModel {
	Connection connection; 
	
//	gets the connection to the database. 
	public LoginModel() {
		
		try {
//			calling the SqliteDbClass to get the inital connection. 
			this.connection= SqliteDbClass.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		if(this.connection==null) {
			System.exit(1);
		}
	}
	
//	 if connected to the database, then it returns not null. 
	public boolean isDatabaseConnected() {
		return this.connection != null; 
	}
	
	
//	this method reads the data from the database and passess it to the loginController method. 
	public boolean isLogin(String user, String pass, String opt)throws Exception {
		PreparedStatement pr =null; 
		ResultSet rs= null; 
		String sql= "SELECT * FROM login WHERE Username= ? and Password= ? and division= ?";
		
		try {
			pr=this.connection.prepareStatement(sql);
			pr.setString(1, user);
			pr.setString(2, pass);
			pr.setString(3, opt);
			
			rs=pr.executeQuery(); 
			
			if(rs.next()) {
				
				return true; 
			}
				return false;
				
		}catch(SQLException ex) {
			return false; 
			
		}
//		good practice to close the connection all the times. 
		
		finally {
				pr.close();
				rs.close();
		}
	}
	
}
