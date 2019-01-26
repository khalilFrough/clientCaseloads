package mainClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import dbClass.SqliteDbClass;
public class LoginModel {
	
	Connection connection; 
	
	public LoginModel() {
		
		try {
			this.connection= SqliteDbClass.getConnection();
		}catch(SQLException ex){
			ex.printStackTrace();
			
		}
		if(this.connection==null) {
			System.exit(1);
		}
	}
	public boolean isDatabaseConnected() {
		return this.connection!= null; 
	}
	
	public boolean isLogin(String user, String pass, String opt)throws Exception {
		PreparedStatement pr =null; 
		ResultSet re= null; 
		String sql= "SELECT * FROM login WHERE Username=? Password=? division=?";
		
		try {
			pr=this.connection.prepareStatement(sql);
			pr.setString(1, user);
			pr.setString(2, pass);
			pr.setString(3, opt);
			re=pr.executeQuery(); 
			
			if(re.next()) {
				return true;
			}
				return false;
		}catch(SQLException ex) {
			return false; 
			
		}
		finally {
			{
				pr.close();
				re.close();
			}
		}
	}

}
